package com.personal.diecastfun.controllers.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.base.Strings;
import com.personal.diecastfun.controllers.models.CarModel;
import com.personal.diecastfun.controllers.models.SortedList;
import com.personal.diecastfun.domain.Car;
import com.personal.diecastfun.domain.CarRepository;
import com.personal.diecastfun.domain.Era;
import com.personal.diecastfun.domain.Tags;
import com.personal.diecastfun.domain.repositories.VotesRepository;

public class CarFacade {

	private Map<String, CarModel> cachedCars = new HashMap<String, CarModel>();

	@Inject
	private CarRepository carRepository;
	@Autowired
	private VotesRepository votesRepository;

	public int countByEra(Era era) {
		return carRepository.countByEra(era);
	}

	public int countByTag(Tags tag) {
		return carRepository.countByTag(tag);
	}

	public SortedList<CarModel> findAllCars() {
		List<Car> allCars = new ArrayList<Car>(carRepository.findAll());
		if (cachedCars.values().size() != allCars.size()) {
			cachedCars = new HashMap<String, CarModel>();
			for (Car car : allCars) {
				cachedCars.put(car.getCompleteId(), new CarModel(car));
			}
		}

		return new SortedList<CarModel>(new ArrayList<CarModel>(cachedCars.values()));
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

		for (Car car : carRepository.findByCategory(category)) {
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

		for (Car car : carRepository.findAll()) {
			if (!Strings.isNullOrEmpty(keywords)) {
				if (car.containsWord(keywords) && !foundIds.contains(car.getCompleteId())) {
					addCarModel(models, car);
					foundIds.add(car.getCompleteId());
				}
			} else {
				addCarModel(models, car);
				foundIds.add(car.getCompleteId());
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

		for (Car car : carRepository.findCustomizations()) {
			addCarModel(models, car);
		}
		return models;
	}

	public List<CarModel> findRandomRestorations() {
		List<CarModel> models = new ArrayList<CarModel>();

		List<Car> restorations = carRepository.findRestorations();
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

		for (Car car : carRepository.findRestorations()) {
			addCarModel(models, car);
		}
		return models;
	}

	public CarModel findCarById(String id) {
		CarModel carModel;
		if (cachedCars.containsKey(id)) {
			carModel = cachedCars.get(id);
		} else {
			Car realCar = carRepository.findById(id);
			carModel = new CarModel(realCar);
			cachedCars.put(realCar.getCompleteId(), carModel);
		}
		return carModel;
	}

	public String findRandomCarId() {
		return carRepository.findRandomId();
	}

	public List<CarModel> findMostPopular() {
		return new MostPopularStrategy(carRepository, votesRepository).findCars();
	}

	public List<CarModel> findNewAdditions() {
		return new NewAdditionsStrategy(carRepository).findCars();
	}

	public List<CarModel> findSeeAlso(String id) {
		return new SeeAlsoStrategy(carRepository, id).findCars();
	}

	private void addCarModel(List<CarModel> models, Car car) {
		String carId = car.getCompleteId();
		if (cachedCars.containsKey(carId)) {
			models.add(cachedCars.get(carId));
		} else {
			CarModel carModel = new CarModel(car);
			cachedCars.put(car.getCompleteId(), carModel);
			models.add(carModel);
		}
	}
}
