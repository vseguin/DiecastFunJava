package com.personal.diecastfun.controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.personal.diecastfun.controllers.models.MakerModel;
import com.personal.diecastfun.controllers.models.SortedList;
import com.personal.diecastfun.controllers.service.MakerFacade;

@Controller
@RequestMapping(value = "/makers")
public class MakersController extends BasicController {

	@Inject
	private MakerFacade makerFacade;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = getModelAndView("carmakers");

		SortedList<MakerModel> model = new SortedList<MakerModel>(makerFacade.findAllMakers());
		mv.addObject("sortedmakers", model);

		return mv;
	}
}
