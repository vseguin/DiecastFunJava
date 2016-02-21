package com.personal.diecastfun.conditions;

import com.personal.diecastfun.controllers.models.CarModel;
import com.personal.diecastfun.domain.Era;

public class EraCondition implements ICondition {

	private Era era;

	public EraCondition(Era era) {
		this.era = era;
	}

	@Override
	public boolean isValid(CarModel car) {
		return car.getEra().equals(era);
	}

	@Override
	public String getValue() {
		return era.toString();
	}
}
