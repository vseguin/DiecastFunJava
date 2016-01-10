package com.personal.diecastfun.conditions;

import com.personal.diecastfun.domain.Car;

public class BrandCondition implements ICondition {

  private String brand;

  public BrandCondition(String brand) {
    this.brand = brand;
  }

  @Override
  public boolean isValid(Car car) {
    return car.getBrand().equalsIgnoreCase(brand);
  }

  @Override
  public String getValue() {
    return brand;
  }
}
