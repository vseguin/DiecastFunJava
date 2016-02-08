package com.personal.diecastfun.controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.personal.diecastfun.controllers.service.CarFacade;
import com.personal.diecastfun.domain.Era;
import com.personal.diecastfun.utils.PaginationResults;
import com.personal.diecastfun.utils.Paginator;

@Controller
@RequestMapping(value = "/eras")
public class ErasController extends BasicController {

	@Inject
	private CarFacade carFacade;
	@Inject
	private Paginator paginator;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("eras");

		addBasicInformationToModel(mv);
		mv.addObject("eras", Era.values());

		return mv;
	}

	@RequestMapping(value = "/{era}", method = RequestMethod.GET)
	public ModelAndView getSpecificEra(@PathVariable String era) {
		ModelAndView mv = new ModelAndView("carlist");

		PaginationResults results = paginator.paginate(carFacade.findAllCarsCorrespondingToEra(era));
		mv.addObject("title", era);
		mv.addObject("previousview", "eras");
		mv.addObject("previousviewtitle", "Eras");
		addBasicInformationToModel(mv);
		addPaginationInformation(mv, results);

		return mv;
	}

}
