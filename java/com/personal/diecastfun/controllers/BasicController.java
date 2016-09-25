package com.personal.diecastfun.controllers;

import java.util.Arrays;

import javax.inject.Inject;

import org.springframework.web.servlet.ModelAndView;

import com.personal.diecastfun.controllers.service.BasicFacade;
import com.personal.diecastfun.controllers.service.ConfigFacade;
import com.personal.diecastfun.domain.Country;
import com.personal.diecastfun.utils.PaginationResults;

public abstract class BasicController {

	@Inject
	protected BasicFacade basicFacade;
	@Inject
	private ConfigFacade configFacade;

	// TODO vseguin remove this eventually
	protected void addPaginationInformation(ModelAndView mv, PaginationResults results) {
		mv.addObject("currentpage", results.getCurrentPage());
		mv.addObject("hasprevious", results.hasPrevious());
		mv.addObject("hasnext", results.hasNext());
		mv.addObject("cars", results.getPaginationResults());
		mv.addObject("completeresults", results.getCompleteResults());
		mv.addObject("countries", getCountries());
	}

	protected ModelAndView getModelAndView(String viewName) {
		ModelAndView mv = new ModelAndView("main");

		mv.addObject("picturesUrl", configFacade.getPicturesUrl());
		mv.addObject("view", viewName);

		return mv;
	}

	private String[] getCountries() {
		String[] countries = new String[Country.values().length];

		int i = 0;
		for (Country country : Country.values()) {
			countries[i] = country.toString();
			i++;
		}

		Arrays.sort(countries);
		return countries;
	}
}
