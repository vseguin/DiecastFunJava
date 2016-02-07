package com.personal.diecastfun.controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.personal.diecastfun.controllers.models.BrandModel;
import com.personal.diecastfun.controllers.models.SortedList;
import com.personal.diecastfun.controllers.service.BasicFacade;
import com.personal.diecastfun.controllers.service.BrandFacade;
import com.personal.diecastfun.controllers.service.CarFacade;
import com.personal.diecastfun.utils.PaginationResults;
import com.personal.diecastfun.utils.Paginator;

@Controller
@RequestMapping(value = "/carbrands")
public class CarBrandsController extends BasicController {

	@Inject
	private BrandFacade brandFacade;
	@Inject
	private BasicFacade basicFacade;
	@Inject
	private CarFacade carFacade;
	@Inject
	private Paginator paginator;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("carbrands");

		SortedList<BrandModel> model = new SortedList<BrandModel>(brandFacade.findAllBrands());
		mv.addObject("sortedbrands", model);
		mv.addObject("countries", brandFacade.findCountries());
		addBasicInformationToModel(mv, basicFacade.getTotalCarCount());

		return mv;
	}

	@RequestMapping(value = "/{brand}", method = RequestMethod.GET)
	public ModelAndView getSpecificBrand(@PathVariable String brand) {
		ModelAndView mv = new ModelAndView("carlist");

		PaginationResults results = paginator.paginate(carFacade.findAllCarsCorrespondingToBrand(brand));
		mv.addObject("title", brand);
		mv.addObject("previousview", "carbrands");
		mv.addObject("previousviewtitle", "Car Brands");
		addBasicInformationToModel(mv, basicFacade.getTotalCarCount());
		addPaginationInformation(mv, results);

		return mv;
	}

	@RequestMapping(value = "/{country}", method = RequestMethod.POST)
	public ModelAndView getBrandsByCountry(@PathVariable String country) {
		ModelAndView mv = new ModelAndView("carbrandstemplate");

		SortedList<BrandModel> model = new SortedList<BrandModel>(brandFacade.findBrandsByCountry(country));
		mv.addObject("sortedbrands", model);
		mv.addObject("countries", brandFacade.findCountries());

		return mv;
	}

}
