package com.personal.diecastfun.controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.personal.diecastfun.controllers.service.BasicFacade;
import com.personal.diecastfun.controllers.service.CarFacade;
import com.personal.diecastfun.controllers.service.ViewsFacade;
import com.personal.diecastfun.controllers.service.VotesFacade;
import com.personal.diecastfun.utils.PaginationResults;
import com.personal.diecastfun.utils.Paginator;

@Controller
@RequestMapping(value = "/cars")
public class CarsController extends BasicController {

	@Inject
	private BasicFacade basicFacade;
	@Inject
	private CarFacade carFacade;
	@Inject
	private ViewsFacade viewsFacade;
	@Inject
	private VotesFacade votesFacade;
	@Inject
	private Paginator paginator;

	@RequestMapping(value = "/allcars", method = RequestMethod.GET)
	public ModelAndView getAllCars() {
		ModelAndView mv = new ModelAndView("carlist");

		PaginationResults results = paginator.paginate(carFacade.findAllCars());
		mv.addObject("title", "All Cars");
		addBasicInformationToModel(mv, basicFacade.getTotalCarCount());
		addPaginationInformation(mv, results);

		return mv;
	}

	@RequestMapping(value = "/{carId}", method = RequestMethod.GET)
	public ModelAndView getSpecificCar(@PathVariable String carId) {
		viewsFacade.addView(carId);
		ModelAndView mv = new ModelAndView("cardetails");

		mv.addObject("id", carId);
		mv.addObject("car", carFacade.findCarById(carId));
		mv.addObject("seealso", carFacade.findSeeAlso(carId));
		mv.addObject("votes", votesFacade.getVotesById(carId));
		mv.addObject("views", viewsFacade.getViews(carId));
		addBasicInformationToModel(mv, basicFacade.getTotalCarCount());

		return mv;
	}

	@RequestMapping(value = "/random", method = RequestMethod.GET)
	public ModelAndView getRandomCar() {
		return getSpecificCar(carFacade.findRandomCarId());
	}
}
