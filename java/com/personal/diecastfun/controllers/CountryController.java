package com.personal.diecastfun.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.personal.diecastfun.controllers.models.CarModel;
import com.personal.diecastfun.controllers.models.SortedList;
import com.personal.diecastfun.controllers.service.BrandFacade;
import com.personal.diecastfun.controllers.service.CarFacade;
import com.personal.diecastfun.utils.PaginationResults;
import com.personal.diecastfun.utils.Paginator;

@Controller
@RequestMapping(value = "/countries")
public class CountryController extends BasicController {

	@Inject
	private BrandFacade brandFacade;
	@Inject
	private CarFacade carFacade;
	@Inject
	private Paginator paginator;

	@RequestMapping(value = "/{country}", method = RequestMethod.POST)
	public ModelAndView getCarsByCountry(@PathVariable String country,
			@RequestParam(value = "cars", required = false) ArrayList<String> cars) {
		ModelAndView mv = new ModelAndView("carlisttemplate");

		List<CarModel> filteredCars = new ArrayList<CarModel>();

		for (String carId : cars) {
			CarModel carModel = carFacade.findCarById(carId);
			if (brandFacade.findBrand(carModel.getBrand()).getCountry().equals(country)) {
				filteredCars.add(carModel);
			}
		}

		PaginationResults results = paginator.paginate(new SortedList<CarModel>(filteredCars));
		addPaginationInformation(mv, results);
		mv.addObject("completeresults", cars);
		addBasicInformationToModel(mv);

		return mv;
	}
}
