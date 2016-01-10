package com.personal.diecastfun.conditions;

import com.personal.diecastfun.domain.Car;

public interface ICondition {

  String getValue();

  boolean isValid(Car car);
}
