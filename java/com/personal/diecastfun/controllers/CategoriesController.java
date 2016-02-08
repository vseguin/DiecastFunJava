package com.personal.diecastfun.controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.personal.diecastfun.controllers.service.CarFacade;
import com.personal.diecastfun.domain.Tags;
import com.personal.diecastfun.utils.PaginationResults;
import com.personal.diecastfun.utils.Paginator;

@Controller
@RequestMapping(value = "/categories")
public class CategoriesController extends BasicController {

	@Inject
	private CarFacade carFacade;
	@Inject
	private Paginator paginator;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("carcategories");

		addBasicInformationToModel(mv);
		mv.addObject("tags", Tags.values());

		return mv;
	}

	@RequestMapping(value = "/{category}", method = RequestMethod.GET)
	public ModelAndView getSpecificCategory(@PathVariable String category) {
		ModelAndView mv = new ModelAndView("carlist");

		PaginationResults results = paginator.paginate(carFacade.findAllCarsCorrespondingToCategory(category));
		mv.addObject("title", category);
		mv.addObject("previousview", "categories");
		mv.addObject("previousviewtitle", "Car Categories");
		addBasicInformationToModel(mv);
		addPaginationInformation(mv, results);

		return mv;
	}

}
