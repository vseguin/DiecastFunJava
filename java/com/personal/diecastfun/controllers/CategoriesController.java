package com.personal.diecastfun.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;
import com.personal.diecastfun.controllers.models.SortedList;
import com.personal.diecastfun.controllers.models.TagModel;
import com.personal.diecastfun.controllers.service.CarFacade;
import com.personal.diecastfun.domain.Tags;

@Controller
@RequestMapping(value = "/categories")
public class CategoriesController extends BasicController {

	@Inject
	private CarFacade carFacade;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = getModelAndView("carcategories");

		List<TagModel> tags = Lists.newArrayList(Tags.values()).stream()
				.map(t -> new TagModel(t, carFacade.countByTag(t))).collect(Collectors.toList());

		mv.addObject("tags", new SortedList<>(tags));

		return mv;
	}
}
