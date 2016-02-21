package com.personal.diecastfun.conditions;

import com.personal.diecastfun.controllers.models.CarModel;

public interface ICondition {

	String getValue();

	boolean isValid(CarModel car);
}
