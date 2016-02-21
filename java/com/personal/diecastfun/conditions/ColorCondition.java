package com.personal.diecastfun.conditions;

import com.personal.diecastfun.controllers.models.CarModel;

public class ColorCondition implements ICondition {

	private String color;

	public ColorCondition(String color) {
		this.color = color;
	}

	@Override
	public boolean isValid(CarModel car) {
		return car.getColorName().equalsIgnoreCase(color);
	}

	@Override
	public String getValue() {
		return color;
	}
}
