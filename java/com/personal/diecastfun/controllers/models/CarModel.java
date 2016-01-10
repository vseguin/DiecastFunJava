package com.personal.diecastfun.controllers.models;

import java.util.ArrayList;
import java.util.List;

import com.personal.diecastfun.domain.Car;
import com.personal.diecastfun.domain.Tags;
import com.personal.diecastfun.utils.ColorTranslator;

public class CarModel implements Comparable<CarModel> {

  private String id;
  private String brand;
  private String model;
  private String maker;
  private String scale;
  private String color;
  private String colorName;
  private boolean isRestaured;
  private boolean isCustomized;
  private boolean isNew;
  private String thumbnail;
  private List<String> pictures = new ArrayList<String>();
  private List<Tags> tags = new ArrayList<Tags>();

  public CarModel(Car car) {
    this.id = car.getCompleteId();
    this.brand = car.getBrand();
    this.model = car.getModel();
    this.maker = car.getMaker();
    this.scale = car.getScale();
    this.colorName = car.getColor();
    this.color = ColorTranslator.translateColor(colorName);
    this.isRestaured = car.isRestaured();
    this.isCustomized = car.isCustomized();
    this.tags = car.getTags();
    pictures.add(id + "-1.jpg");
    pictures.add(id + "-2.jpg");
    pictures.add(id + "-3.jpg");
    this.thumbnail = pictures.get(0);
    this.isNew = car.isNew();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public List<String> getPictures() {
    return pictures;
  }

  public void setPictures(List<String> pictures) {
    this.pictures = pictures;
  }

  public String getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
  }

  public String getMaker() {
    return maker;
  }

  public void setMaker(String maker) {
    this.maker = maker;
  }

  public String getScale() {
    return scale;
  }

  public void setScale(String scale) {
    this.scale = scale;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public boolean getIsRestaured() {
    return isRestaured;
  }

  public void setRestaured(boolean isRestaured) {
    this.isRestaured = isRestaured;
  }

  public boolean getIsCustomized() {
    return isCustomized;
  }

  public void setCustomized(boolean isCustomized) {
    this.isCustomized = isCustomized;
  }

  public String getColorName() {
    return colorName;
  }

  public void setColorName(String colorName) {
    this.colorName = colorName;
  }

  public boolean getIsNew() {
    return isNew;
  }

  public void setNew(boolean isNew) {
    this.isNew = isNew;
  }

  public List<Tags> getTags() {
    return tags;
  }

  public void setTags(List<Tags> tags) {
    this.tags = tags;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof CarModel) {
      CarModel model = (CarModel) obj;
      return model.getId().equals(getId());
    } else {
      return false;
    }
  }

  @Override
  public int compareTo(CarModel car) {
    return getId().compareTo(car.getId());
  }
}
