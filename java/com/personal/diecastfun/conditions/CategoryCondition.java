package com.personal.diecastfun.conditions;

import com.personal.diecastfun.controllers.models.CarModel;
import com.personal.diecastfun.domain.Tags;

public class CategoryCondition implements ICondition {

	private Tags category;

	public CategoryCondition(Tags category) {
		this.category = category;
	}

	@Override
	public boolean isValid(CarModel car) {
		return car.getTags().contains(category);
	}

	@Override
	public String getValue() {
		return category.toString();
	}
}
