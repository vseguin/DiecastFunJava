package com.personal.diecastfun.controllers;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.personal.diecastfun.controllers.models.AddBrandModel;
import com.personal.diecastfun.controllers.models.CarModel;
import com.personal.diecastfun.controllers.service.BrandFacade;
import com.personal.diecastfun.controllers.service.CarFacade;
import com.personal.diecastfun.controllers.service.MakerFacade;
import com.personal.diecastfun.utils.JsonIdWrapper;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

	@Inject
	private BrandFacade brandFacade;
	@Inject
	private CarFacade carFacade;
	@Inject
	private MakerFacade makerFacade;

	@RequestMapping(value = "/carbrands", method = RequestMethod.POST, consumes = "application/json")
	@ResponseStatus(value = HttpStatus.CREATED)
	public @ResponseBody JsonIdWrapper addBrand(@RequestBody AddBrandModel addBrandModel) {
		brandFacade.addBrand(addBrandModel.getName(), addBrandModel.getCountry());

		return new JsonIdWrapper().withId(addBrandModel.getName());
	}

	@RequestMapping(value = "/cars", method = RequestMethod.POST, consumes = "application/json")
	@ResponseStatus(value = HttpStatus.CREATED)
	public @ResponseBody JsonIdWrapper addCar(@RequestBody CarModel carModel) {
		String id = carFacade.addCar(carModel);

		if (!makerFacade.findAllMakers().stream().anyMatch(m -> m.getName().equals(carModel.getMaker()))) {
			makerFacade.addMaker(carModel.getMaker());
		}

		brandFacade.updateBrand(carModel.getBrand());

		return new JsonIdWrapper().withId(id);
	}
}
