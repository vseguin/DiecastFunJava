package com.personal.diecastfun.controllers.models;

import com.personal.diecastfun.domain.Tags;

public class TagModel implements Comparable<TagModel> {

  private Tags tag;
  private int carCount;

  public TagModel(Tags tag, int carCount) {
    this.tag = tag;
    this.carCount = carCount;
  }

  public Tags getTag() {
    return tag;
  }

  public void setTag(Tags tag) {
    this.tag = tag;
  }

  public int getCarCount() {
    return carCount;
  }

  public void setCarCount(int carCount) {
    this.carCount = carCount;
  }

  @Override
  public int compareTo(TagModel tagModel) {
    return this.getTag().toString().compareTo(tagModel.getTag().toString());
  }

}
