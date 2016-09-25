package com.personal.diecastfun.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;
import com.personal.diecastfun.controllers.models.EraModel;
import com.personal.diecastfun.controllers.models.SortedList;
import com.personal.diecastfun.controllers.service.CarFacade;
import com.personal.diecastfun.domain.Era;

@Controller
@RequestMapping(value = "/eras")
public class ErasController extends BasicController {

	@Inject
	private CarFacade carFacade;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = getModelAndView("eras");

		List<EraModel> eras = Lists.newArrayList(Era.values()).stream()
				.map(e -> new EraModel(e, carFacade.countByEra(e))).collect(Collectors.toList());

		mv.addObject("eras", new SortedList<>(eras));

		return mv;
	}
}
