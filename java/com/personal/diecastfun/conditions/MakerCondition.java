package com.personal.diecastfun.conditions;

import com.personal.diecastfun.controllers.models.CarModel;

public class MakerCondition implements ICondition {

	private String maker;

	public MakerCondition(String maker) {
		this.maker = maker;
	}

	@Override
	public boolean isValid(CarModel car) {
		return car.getMaker().equalsIgnoreCase(maker);
	}

	@Override
	public String getValue() {
		return maker;
	}
}
