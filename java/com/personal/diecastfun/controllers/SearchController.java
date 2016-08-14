package com.personal.diecastfun.controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.personal.diecastfun.controllers.models.CarModel;
import com.personal.diecastfun.controllers.models.SortedList;
import com.personal.diecastfun.controllers.service.CarFacade;
import com.personal.diecastfun.utils.PaginationResults;
import com.personal.diecastfun.utils.Paginator;

@Controller
@RequestMapping(value = "/search")
public class SearchController extends BasicController {

	@Inject
	private CarFacade carFacade;
	@Inject
	private Paginator paginator;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView search(@RequestParam(required = false, value = "q") String query) {
		ModelAndView mv = getModelAndView("carlist");

		SortedList<CarModel> cars = carFacade.findAllCarsCorrespondingToKeywords(query);
		PaginationResults results = paginator.paginate(cars);
		mv.addObject("title", "Search Results");
		mv.addObject("searchresults", cars.size());
		addPaginationInformation(mv, results);

		return mv;
	}
}
