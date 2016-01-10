package com.personal.diecastfun.controllers;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.personal.diecastfun.controllers.models.CarModel;
import com.personal.diecastfun.controllers.models.SortedList;
import com.personal.diecastfun.controllers.service.BasicFacade;
import com.personal.diecastfun.controllers.service.CarFacade;
import com.personal.diecastfun.utils.PaginationResults;
import com.personal.diecastfun.utils.Paginator;

@Controller
@RequestMapping(value = "/search")
public class SearchController extends BasicController {

	@Inject
	private BasicFacade basicFacade;
	@Inject
	private CarFacade carFacade;
	@Inject
	private Paginator paginator;

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView search(@RequestParam(required = true, value = "keywords") String keywords) {
		ModelAndView mv = new ModelAndView("carlist");

		SortedList<CarModel> cars = carFacade.findAllCarsCorrespondingToKeywords(keywords);
		PaginationResults results = paginator.paginate(cars);
		mv.addObject("title", "Search Results");
		mv.addObject("searchresults", cars.size());
		addBasicInformationToModel(mv, basicFacade.getTotalCarCount());
		addPaginationInformation(mv, results);

		return mv;
	}

	@RequestMapping(value = "/filterByCount", method = RequestMethod.POST)
	public ModelAndView filterByCount(@RequestParam(value = "cars", required = true) ArrayList<String> cars,
			@RequestParam(value = "carCount", required = true) int carCount,
			@RequestParam(value = "view", required = true) String view) {
		ModelAndView mv = new ModelAndView(view);

		PaginationResults results = paginator.paginateWithCount(++carCount);
		addPaginationInformation(mv, results);
		mv.addObject("completeresults", cars);

		return mv;
	}
}
