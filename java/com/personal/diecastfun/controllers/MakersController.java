package com.personal.diecastfun.controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.personal.diecastfun.controllers.models.MakerModel;
import com.personal.diecastfun.controllers.models.SortedList;
import com.personal.diecastfun.controllers.service.BasicFacade;
import com.personal.diecastfun.controllers.service.CarFacade;
import com.personal.diecastfun.controllers.service.MakerFacade;
import com.personal.diecastfun.utils.PaginationResults;
import com.personal.diecastfun.utils.Paginator;

@Controller
@RequestMapping(value = "/makers")
public class MakersController extends BasicController {

	@Inject
	private BasicFacade basicFacade;
	@Inject
	private MakerFacade makerFacade;
	@Inject
	private CarFacade carFacade;
	@Inject
	private Paginator paginator;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("carmakers");

		SortedList<MakerModel> model = new SortedList<MakerModel>(makerFacade.findAllMakers());
		mv.addObject("sortedmakers", model);
		addBasicInformationToModel(mv, basicFacade.getTotalCarCount());

		return mv;
	}

	@RequestMapping(value = "/{maker}", method = RequestMethod.GET)
	public ModelAndView getSpecificMaker(@PathVariable String maker) {
		ModelAndView mv = new ModelAndView("carlist");

		PaginationResults results = paginator.paginate(carFacade.findAllCarsCorrespondingToMaker(maker));
		mv.addObject("title", maker);
		mv.addObject("previousview", "makers");
		mv.addObject("previousviewtitle", "Maker Brands");
		addBasicInformationToModel(mv, basicFacade.getTotalCarCount());
		addPaginationInformation(mv, results);

		return mv;
	}

}
