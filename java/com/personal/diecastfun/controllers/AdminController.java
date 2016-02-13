package com.personal.diecastfun.controllers;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.personal.diecastfun.controllers.models.CarModel;
import com.personal.diecastfun.controllers.service.CarFacade;
import com.personal.diecastfun.controllers.service.MakerFacade;
import com.personal.diecastfun.utils.JsonIdWrapper;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

	@Inject
	private CarFacade carFacade;
	@Inject
	private MakerFacade makerFacade;

	@RequestMapping(value = "/cars", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody JsonIdWrapper addCar(@RequestBody CarModel carModel) {
		String id = carFacade.addCar(carModel);

		if (!makerFacade.findAllMakers().stream().anyMatch(m -> m.getName().equals(carModel.getMaker()))) {
			makerFacade.addMaker(carModel.getMaker());
		}

		return new JsonIdWrapper().withId(id);
	}
}
