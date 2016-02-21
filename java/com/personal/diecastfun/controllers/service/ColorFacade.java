package com.personal.diecastfun.controllers.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.personal.diecastfun.controllers.models.ColorModel;
import com.personal.diecastfun.domain.repositories.CarRepository;
import com.personal.diecastfun.utils.ColorTranslator;

public class ColorFacade {

  @Inject
  private CarRepository carRepository;

  public List<ColorModel> findAllColors() {
    List<ColorModel> models = new ArrayList<ColorModel>();
    for (String color : ColorTranslator.findAllColors()) {
      ColorModel model = new ColorModel(color, carRepository.countByColor(color));
      models.add(model);
    }

    return models;
  }

  public int countByColor(String color) {
    return carRepository.countByColor(color);
  }
}
