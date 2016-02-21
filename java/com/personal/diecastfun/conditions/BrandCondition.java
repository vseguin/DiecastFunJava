package com.personal.diecastfun.conditions;

import com.personal.diecastfun.controllers.models.CarModel;

public class BrandCondition implements ICondition {

	private String brand;

	public BrandCondition(String brand) {
		this.brand = brand;
	}

	@Override
	public boolean isValid(CarModel car) {
		return car.getBrand().equalsIgnoreCase(brand);
	}

	@Override
	public String getValue() {
		return brand;
	}
}
