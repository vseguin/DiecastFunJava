package com.personal.diecastfun.controllers;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.personal.diecastfun.controllers.models.CarModel;
import com.personal.diecastfun.controllers.service.CarFacade;

@Controller
public class HomeController extends BasicController {

	@Inject
	private CarFacade carFacade;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("home");

		CarModel featuredCar = carFacade.findCarById(carFacade.findRandomCarId());
		featuredCar.setPictures(
				featuredCar.getPictures().stream().map(p -> p.replace("'", "%27")).collect(Collectors.toList()));

		mv.addObject("newadditions", carFacade.findNewAdditions());
		mv.addObject("restoration", getRandomCarModelFromList(carFacade.findRestorations()));
		mv.addObject("custom", getRandomCarModelFromList(carFacade.findCustomizations()));
		mv.addObject("mostpopular", getRandomCarModelFromList(carFacade.findMostPopular()));
		mv.addObject("featuredcar", featuredCar);
		addBasicInformationToModel(mv);

		return mv;
	}

	private CarModel getRandomCarModelFromList(List<CarModel> carModels) {
		CarModel car = null;
		Random random = new Random();

		if (!carModels.isEmpty()) {
			car = carModels.get(random.nextInt(carModels.size()));
		}

		return car;
	}
}
