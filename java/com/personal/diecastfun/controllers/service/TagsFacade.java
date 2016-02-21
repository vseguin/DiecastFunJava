package com.personal.diecastfun.controllers.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.personal.diecastfun.controllers.models.TagModel;
import com.personal.diecastfun.domain.Tags;
import com.personal.diecastfun.domain.repositories.CarRepository;

public class TagsFacade {

  @Inject
  private CarRepository carRepository;

  public List<TagModel> findAllTags() {
    List<TagModel> models = new ArrayList<TagModel>();
    for (Tags tag : Tags.values()) {
      TagModel model = new TagModel(tag, carRepository.countByTags(tag));
      models.add(model);
    }

    return models;
  }
}
