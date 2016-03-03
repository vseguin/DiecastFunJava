package com.personal.diecastfun.controllers.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.personal.diecastfun.controllers.models.CarModel;
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
public class CarFacade {

	private Map<String, CarModel> cachedCarModels = new HashMap<String, CarModel>();
	private Map<String, Car> cachedCars = Maps.newHashMap();

	@Autowired
	private CarRepository carRepository;
	@Autowired
	private QueuedCarsRepository queuedCarsRepository;
	@Autowired
	private VotesRepository votesRepository;

	public void addCar(Car car) {
		carRepository.save(car);
		cachedCars.put(car.getId(), car);
	}

	public String addCar(CarModel carModel) {
		int id = 0;

		QueuedCar car = new QueuedCar().withBrand(carModel.getBrand()).withModel(carModel.getModel())
				.withMaker(carModel.getMaker()).withEra(carModel.getEra()).withScale(carModel.getScale())
				.withColor(carModel.getColorName()).withRestored(carModel.getIsRestaured())
				.withCustomized(carModel.getIsCustomized()).withTags(carModel.getTags()).withCount(0);

		while (carRepository.exists(car.generateId())) {
			id++;
			car.setCount(id);
		}

		car.withId(car.generateId());

		queuedCarsRepository.save(car);

		return car.getId();
	}

	public int countByEra(Era era) {
		return carRepository.countByEra(era);
	}

	public int countByTag(Tags tag) {
		return carRepository.countByTags(tag);
	}

	public SortedList<CarModel> findAllCars() {
		List<Car> allCars = getAllCars();
		if (cachedCarModels.values().size() != allCars.size()) {
			cachedCarModels = new HashMap<String, CarModel>();
			for (Car car : allCars) {
				cachedCarModels.put(car.getId(), new CarModel(car));
			}
		}

		return new SortedList<CarModel>(new ArrayList<CarModel>(cachedCarModels.values()));
	}

	public SortedList<CarModel> findAllCarsCorrespondingToBrand(String brand) {
		List<CarModel> models = new ArrayList<CarModel>();

		for (Car car : carRepository.findByBrand(brand)) {
			addCarModel(models, car);
		}
		return new SortedList<CarModel>(models);

	}

	public SortedList<CarModel> findAllCarsCorrespondingToCategory(String category) {
		List<CarModel> models = new ArrayList<CarModel>();

		for (Car car : carRepository.findByTags(Tags.valueOf(category))) {
			addCarModel(models, car);
		}
		return new SortedList<CarModel>(models);

	}

	public SortedList<CarModel> findAllCarsCorrespondingToEra(String era) {
		List<CarModel> models = new ArrayList<CarModel>();

		for (Car car : carRepository.findByEra(Era.valueOf(era))) {
			addCarModel(models, car);
		}
		return new SortedList<CarModel>(models);

	}

	public SortedList<CarModel> findAllCarsCorrespondingToKeywords(String keywords) {
		List<CarModel> models = new ArrayList<CarModel>();
		List<String> foundIds = new ArrayList<String>();

		for (Car car : getAllCars()) {
			if (!Strings.isNullOrEmpty(keywords)) {
				if (car.containsWord(keywords) && !foundIds.contains(car.getId())) {
					addCarModel(models, car);
					foundIds.add(car.getId());
				}
			} else {
				addCarModel(models, car);
				foundIds.add(car.getId());
			}
		}

		return new SortedList<CarModel>(models);
	}

	public SortedList<CarModel> findAllCarsCorrespondingToMaker(String maker) {
		List<CarModel> models = new ArrayList<CarModel>();

		for (Car car : carRepository.findByMaker(maker)) {
			addCarModel(models, car);
		}
		return new SortedList<CarModel>(models);
	}

	public List<CarModel> findCustomizations() {
		List<CarModel> models = new ArrayList<CarModel>();

		for (Car car : carRepository.findByCustomized(true)) {
			addCarModel(models, car);
		}
		return models;
	}

	public List<CarModel> findRandomRestorations() {
		List<CarModel> models = new ArrayList<CarModel>();

		List<Car> restorations = carRepository.findByRestored(true);
		int numberOfCars = 0;
		if (!restorations.isEmpty()) {
			while (numberOfCars < 10) {
				int index = new Random().nextInt(restorations.size());
				addCarModel(models, restorations.get(index));
				numberOfCars++;
				restorations.remove(index);
			}
		}

		return models;
	}

	public List<CarModel> findRestorations() {
		List<CarModel> models = new ArrayList<CarModel>();

		for (Car car : carRepository.findByRestored(true)) {
			addCarModel(models, car);
		}
		return models;
	}

	public CarModel findCarById(String id) {
		CarModel carModel;
		if (cachedCarModels.containsKey(id)) {
			carModel = cachedCarModels.get(id);
		} else {
			Car realCar = carRepository.findOne(id);

			carModel = new CarModel(realCar);
			cachedCarModels.put(realCar.getId(), carModel);
		}
		return carModel;
	}

	public String findRandomCarId() {
		Random generator = new Random();
		List<Car> cars = getAllCars();

		return cars.get(generator.nextInt(cars.size())).getId();
	}

	public List<CarModel> findMostPopular() {
		return new MostPopularStrategy(carRepository, votesRepository).findCars(getAllCars());
	}

	public List<CarModel> findNewAdditions() {
		return new NewAdditionsStrategy(carRepository).findCars(getAllCars());
	}

	public List<CarModel> findSeeAlso(String id) {
		return new SeeAlsoStrategy(id).findCars(getAllCars());
	}

	private void addCarModel(List<CarModel> models, Car car) {
		String carId = car.getId();
		if (cachedCarModels.containsKey(carId)) {
			models.add(cachedCarModels.get(carId));
		} else {
			CarModel carModel = new CarModel(car);
			cachedCarModels.put(car.getId(), carModel);
			models.add(carModel);
		}
	}

	private List<Car> getAllCars() {
		return Lists.newArrayList(cachedCars.values());
	}

	@PostConstruct
	private void init() {
		carRepository.findAll().forEach(c -> {
			cachedCars.put(c.getId(), c);
		});
	}
}
