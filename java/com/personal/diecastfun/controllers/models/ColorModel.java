package com.personal.diecastfun.controllers.models;

public class ColorModel implements Comparable<ColorModel> {

  private String color;
  private int carCount;

  public ColorModel(String color, int carCount) {
    this.color = color;
    this.carCount = carCount;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getCarCount() {
    return carCount;
  }

  public void setCarCount(int carCount) {
    this.carCount = carCount;
  }

  @Override
  public int compareTo(ColorModel colorModel) {
    return this.getColor().compareTo(colorModel.getColor().toString());
  }

}
