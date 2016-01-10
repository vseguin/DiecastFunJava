package com.personal.diecastfun.controllers.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import com.personal.diecastfun.controllers.models.CarModel;
import com.personal.diecastfun.domain.Car;
import com.personal.diecastfun.domain.CarRepository;

public class NewAdditionsStrategy extends Strategy {

	private static final int NEW_ADDITIONS_SIZE = 15;
	private static final int DAYS_NEW_ADDITIONS = -15;

	private CarRepository carRepository;

	public NewAdditionsStrategy(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	@Override
	public List<CarModel> findCars() {
		List<CarModel> models = new ArrayList<CarModel>();

		Calendar limitDate = Calendar.getInstance();
		limitDate.add(Calendar.DAY_OF_WEEK, DAYS_NEW_ADDITIONS);
		Calendar mostRecentInsertionDate = carRepository
				.findMostRecentInsertionDate();
		List<Car> cars = new ArrayList<Car>(carRepository.findAll());

		while (models.size() <= NEW_ADDITIONS_SIZE
				&& mostRecentInsertionDate.after(limitDate)) {
			mostRecentInsertionDate.add(Calendar.DAY_OF_WEEK, -2);
			Iterator<Car> iterator = cars.iterator();
			while (iterator.hasNext()) {
				Car car = iterator.next();
				if (car != null
						&& car.getInsertionDateAsCalendar().after(
								mostRecentInsertionDate)
						&& models.size() <= NEW_ADDITIONS_SIZE) {
					addCarModel(models, car);
					iterator.remove();
				}
			}
		}

		return models;
	}
}
