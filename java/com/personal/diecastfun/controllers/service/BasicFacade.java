package com.personal.diecastfun.controllers.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.personal.diecastfun.domain.repositories.CarRepository;

public class BasicFacade {

	@Autowired
	private CarRepository carRepository;

	public long getTotalCarCount() {
		return carRepository.count();
	}
}
