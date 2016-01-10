package com.personal.diecastfun.conditions;

import com.personal.diecastfun.domain.Car;

public class MakerCondition implements ICondition {

  private String maker;

  public MakerCondition(String maker) {
    this.maker = maker;
  }

  @Override
  public boolean isValid(Car car) {
    return car.getMaker().equalsIgnoreCase(maker);
  }

  @Override
  public String getValue() {
    return maker;
  }
}
