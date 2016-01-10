package com.personal.diecastfun.controllers.models;

import com.personal.diecastfun.domain.Era;

public class EraModel implements Comparable<EraModel> {

  private Era era;
  private int carCount;

  public EraModel(Era era, int carCount) {
    this.era = era;
    this.carCount = carCount;
  }

  public Era getEra() {
    return era;
  }

  public void setEra(Era era) {
    this.era = era;
  }

  public int getCarCount() {
    return carCount;
  }

  public void setCarCount(int carCount) {
    this.carCount = carCount;
  }

  @Override
  public int compareTo(EraModel eraModel) {
    return this.getEra().compareTo(eraModel.getEra());
  }

}
