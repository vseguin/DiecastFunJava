package com.personal.diecastfun.controllers.service;

import javax.inject.Inject;

import com.personal.diecastfun.domain.CarRepository;

public class BasicFacade {

	@Inject
	private CarRepository carRepository;

	public int getTotalCarCount() {
		return carRepository.countAll();
	}

}
