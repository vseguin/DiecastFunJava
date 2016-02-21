package com.personal.diecastfun.controllers.service;

import java.util.List;

import com.personal.diecastfun.controllers.models.CarModel;
import com.personal.diecastfun.domain.Car;

public abstract class Strategy {

	public abstract List<CarModel> findCars(List<Car> cars);

	protected void addCarModel(List<CarModel> models, Car car) {
		CarModel carModel = new CarModel(car);
		models.add(carModel);
	}

}
