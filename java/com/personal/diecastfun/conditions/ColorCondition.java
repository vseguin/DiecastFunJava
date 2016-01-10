package com.personal.diecastfun.conditions;

import com.personal.diecastfun.domain.Car;

public class ColorCondition implements ICondition {

  private String color;

  public ColorCondition(String color) {
    this.color = color;
  }

  @Override
  public boolean isValid(Car car) {
    return car.getColor().equalsIgnoreCase(color);
  }

  @Override
  public String getValue() {
    return color;
  }
}
