package com.personal.diecastfun.controllers.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.personal.diecastfun.controllers.models.MakerModel;
import com.personal.diecastfun.domain.CarRepository;
import com.personal.diecastfun.domain.Maker;
import com.personal.diecastfun.domain.repositories.MakersRepository;
import com.personal.diecastfun.utils.PicturesHelper;

public class MakerFacade {

	@Autowired
	private MakersRepository makerRepository;

	@Inject
	private CarRepository carRepository;

	public List<MakerModel> findAllMakers() {
		return getModels(Lists.newArrayList(makerRepository.findAll()));
	}

	private List<MakerModel> getModels(List<Maker> makers) {
		List<MakerModel> models = new ArrayList<MakerModel>();
		for (Maker maker : makers) {
			MakerModel model = new MakerModel(maker, PicturesHelper.getPictureName(maker.getName()),
					carRepository.countByMaker(maker.getName()));
			models.add(model);
		}

		return models;
	}
}
