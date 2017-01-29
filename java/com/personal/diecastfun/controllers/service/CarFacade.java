package com.personal.diecastfun.controllers.service;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.personal.diecastfun.controllers.models.CarModel;
import com.personal.diecastfun.controllers.models.CarQueryModel;
import com.personal.diecastfun.controllers.models.CarQueryResultModel;
import com.personal.diecastfun.controllers.models.SortedList;
import com.personal.diecastfun.domain.Car;
import com.personal.diecastfun.domain.Era;
import com.personal.diecastfun.domain.QueuedCar;
import com.personal.diecastfun.domain.Tags;
import com.personal.diecastfun.domain.repositories.CarRepository;
import com.personal.diecastfun.domain.repositories.QueuedCarsRepository;
import com.personal.diecastfun.domain.repositories.VotesRepository;

@Component
@DependsOn("carRepository")
public class CarFacade
{

    private Map<String, Car> cachedCars = Maps.newHashMap();

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private QueuedCarsRepository queuedCarsRepository;
    @Autowired
    private VotesRepository votesRepository;

    @Autowired
    private EntityManager entityManager;

    public void addCar(Car car)
    {
        carRepository.save(car);
        cachedCars.put(car.getId(), car);
    }

    public String addCar(CarModel carModel)
    {
        int id = 0;

        QueuedCar car = new QueuedCar().withBrand(carModel.getBrand())
                                       .withModel(carModel.getModel())
                                       .withMaker(carModel.getMaker())
                                       .withEra(carModel.getEra())
                                       .withScale(carModel.getScale())
                                       .withColor(carModel.getColorName())
                                       .withRestored(carModel.getIsRestaured())
                                       .withCustomized(carModel.getIsCustomized())
                                       .withTags(carModel.getTags())
                                       .withCount(0);

        while (carRepository.exists(car.generateId())) {
            id++;
            car.setCount(id);
        }

        car.withId(car.generateId());

        queuedCarsRepository.save(car);

        return car.getId();
    }

    public int countByEra(Era era)
    {
        return carRepository.countByEra(era);
    }

    public int countByTag(Tags tag)
    {
        return carRepository.countByTags(tag);
    }

    public CarQueryResultModel findCars(CarQueryModel queryModel)
    {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Car> cq = builder.createQuery(Car.class);

        Root<Car> root = cq.from(Car.class);

        if (!Strings.isNullOrEmpty(queryModel.getBrand())) {
            cq.where(builder.equal(root.get("brand"), queryModel.getBrand()));
        }

        cq.orderBy(builder.asc(root.get("id")));

        TypedQuery<Car> typedQuery = entityManager.createQuery(cq);
        typedQuery.setFirstResult(queryModel.getPage() * queryModel.getPerPage());
        typedQuery.setMaxResults(queryModel.getPerPage());

        CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
        Root<Car> carRoot = countQuery.from(Car.class);
        countQuery.select(builder.count(carRoot));
        countQuery.where(builder.and(cq.getRestriction()));

        Integer totalCount = entityManager.createQuery(countQuery).getSingleResult().intValue();

        return new CarQueryResultModel().withCars(new SortedList<>(getModelsFromCars(typedQuery.getResultList())))
                                        .withTotalCount(totalCount);
    }

    public SortedList<CarModel> findAllCars()
    {
        return new SortedList<>(getModelsFromCars(Lists.newArrayList(carRepository.findAll())));
    }

    /*
     * public SortedList<CarModel> findAllCarsCorrespondingToKeywords(String
     * keywords) { List<CarModel> models = new ArrayList<CarModel>();
     * List<String> foundIds = new ArrayList<String>();
     *
     * for (Car car : getAllCars()) { if (!Strings.isNullOrEmpty(keywords)) { if
     * (car.containsWord(keywords) && !foundIds.contains(car.getId())) {
     * addCarModel(models, car); foundIds.add(car.getId()); } } else {
     * addCarModel(models, car); foundIds.add(car.getId()); } }
     *
     * return new SortedList<CarModel>(models); }
     */

    public List<CarModel> findCustomizations()
    {
        return getModelsFromCars(carRepository.findByCustomized(true));
    }

    public List<CarModel> findRestorations()
    {
        return getModelsFromCars(carRepository.findByRestored(true));
    }

    public CarModel findCarById(String id)
    {
        Car realCar = carRepository.findOne(id);

        return new CarModel(realCar);
    }

    public String findRandomCarId()
    {
        Random generator = new Random();
        List<Car> cars = getAllCars();

        return cars.get(generator.nextInt(cars.size())).getId();
    }

    public List<CarModel> findMostPopular()
    {
        return new MostPopularStrategy(carRepository, votesRepository).findCars(getAllCars());
    }

    public List<CarModel> findNewAdditions()
    {
        return new NewAdditionsStrategy(carRepository).findCars(getAllCars());
    }

    public List<CarModel> findSeeAlso(String id)
    {
        return new SeeAlsoStrategy(id).findCars(getAllCars());
    }

    private List<CarModel> getModelsFromCars(List<Car> cars)
    {
        return cars.stream().map(c -> new CarModel(c)).collect(Collectors.toList());
    }

    private List<Car> getAllCars()
    {
        return Lists.newArrayList(cachedCars.values());
    }

    @PostConstruct
    private void init()
    {
        carRepository.findAll().forEach(c -> {
            cachedCars.put(c.getId(), c);
        });
    }
}
