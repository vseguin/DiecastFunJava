package com.personal.diecastfun.controllers.models;

import com.personal.diecastfun.domain.Country;

public class CountryModel implements Comparable<CountryModel> {

  private String country;
  private String picture;
  private int carCount;

  public CountryModel(Country country, int carCount) {
    this.country = String.valueOf(country);
    this.picture = this.country.toLowerCase() + ".png";
    this.carCount = carCount;

    if (country == Country.UnitedKingdom) {
      this.country = "United Kingdom";
    } else if (country == Country.UnitedStates) {
      this.country = "United States";
    } else if (country == Country.SouthKorea) {
      this.country = "South Korea";
    } else if (country == Country.CzechRepublic) {
      this.country = "Czech Republic";
    }
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

  public int getCarCount() {
    return carCount;
  }

  public void setCarCount(int carCount) {
    this.carCount = carCount;
  }

  @Override
  public int compareTo(CountryModel model) {
    return this.getCountry().compareTo(model.getCountry());
  }
}
