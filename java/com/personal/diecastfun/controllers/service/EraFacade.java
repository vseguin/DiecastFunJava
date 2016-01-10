package com.personal.diecastfun.controllers.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.personal.diecastfun.controllers.models.EraModel;
import com.personal.diecastfun.domain.CarRepository;
import com.personal.diecastfun.domain.Era;

public class EraFacade {

  @Inject
  private CarRepository carRepository;

  public List<EraModel> findAllEras() {
    List<EraModel> models = new ArrayList<EraModel>();
    for (Era era : Era.values()) {
      EraModel model = new EraModel(era, carRepository.countByEra(era));
      models.add(model);
    }

    return models;
  }
}
