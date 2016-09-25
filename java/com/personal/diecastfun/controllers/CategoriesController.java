package com.personal.diecastfun.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;
import com.personal.diecastfun.controllers.models.CarModel;
import com.personal.diecastfun.controllers.models.SortedList;
import com.personal.diecastfun.controllers.models.TagModel;
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
		ModelAndView mv = getModelAndView("carcategories");

		List<TagModel> tags = Lists.newArrayList(Tags.values()).stream()
				.map(t -> new TagModel(t, findCarsCorrespondingToCategory(t).size())).collect(Collectors.toList());

		mv.addObject("tags", new SortedList<>(tags));

		return mv;
	}

	@RequestMapping(value = "/{category}", method = RequestMethod.GET)
	public ModelAndView getSpecificCategory(@PathVariable String category) {
		ModelAndView mv = getModelAndView("carlist");

		PaginationResults results = paginator
				.paginate(carFacade.findAllCarsCorrespondingToCategory(Tags.valueOf(category)));
		mv.addObject("title", category);
		mv.addObject("previousview", "categories");
		mv.addObject("previousviewtitle", "Car Categories");
		addPaginationInformation(mv, results);

		return mv;
	}

	private SortedList<CarModel> findCarsCorrespondingToCategory(Tags category) {
		return carFacade.findAllCarsCorrespondingToCategory(category);
	}
}
