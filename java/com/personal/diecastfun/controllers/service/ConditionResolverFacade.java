package com.personal.diecastfun.controllers.service;

import java.util.ArrayList;
import java.util.List;

import com.personal.diecastfun.conditions.ConditionResolver;
import com.personal.diecastfun.conditions.ICondition;
import com.personal.diecastfun.controllers.models.CarModel;
import com.personal.diecastfun.domain.Car;

public class ConditionResolverFacade {

  private ConditionResolver conditionResolver;

  public ConditionResolverFacade(ConditionResolver conditionResolver) {
    this.conditionResolver = conditionResolver;
  }

  public void addCondition(ICondition condition) {
    conditionResolver.addCondition(condition);
  }

  public void removeCondition(String value) {
    conditionResolver.removeConditionCorrespondingTo(value);
  }

  public void removeConditions(Class classToRemove) {
    conditionResolver.removeConditionsCorrespondingTo(classToRemove);
  }

  public void clearAll() {
    conditionResolver.initialize();
  }

  public List<CarModel> resolveConditions() {
    List<CarModel> cars = new ArrayList<CarModel>();
    for (Car car : conditionResolver.resolveConditions()) {
      cars.add(new CarModel(car));
    }

    return cars;
  }

}
