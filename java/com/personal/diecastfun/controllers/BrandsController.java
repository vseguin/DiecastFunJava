package com.personal.diecastfun.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Strings;
import com.personal.diecastfun.controllers.models.BrandModel;
import com.personal.diecastfun.controllers.models.CountryModel;
import com.personal.diecastfun.controllers.models.SortedList;
import com.personal.diecastfun.controllers.service.BrandFacade;
import com.personal.diecastfun.domain.Country;

@Controller
@RequestMapping(value = "/carbrands")
public class BrandsController extends BasicController {

	@Inject
	private BrandFacade brandFacade;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getBrands(@RequestParam(required = false, value = "country") String country) {
		ModelAndView mv = getModelAndView("carbrands");

		List<BrandModel> brands = brandFacade.findAllBrands();

		if (!Strings.isNullOrEmpty(country)) {
			Optional<Country> optCountry = Arrays.stream(Country.values()).filter(c -> country.equals(c.getCode()))
					.findFirst();

			if (optCountry.isPresent()) {
				brands = brandFacade.findBrandsByCountry(optCountry.get());
				mv.addObject("filter", new CountryModel(optCountry.get()));
			}
		}

		SortedList<BrandModel> model = new SortedList<BrandModel>(brands);
		mv.addObject("sortedbrands", model);
		mv.addObject("countries", brandFacade.findCountries());

		return mv;
	}
}
