package com.personal.diecastfun.controllers;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.personal.diecastfun.utils.PaginationResults;
import com.personal.diecastfun.utils.Paginator;

@Controller
@RequestMapping(value = "/paginate")
public class PaginationController extends BasicController {

	@Inject
	private Paginator paginator;

	@RequestMapping(value = "next/{currentPage}", method = RequestMethod.POST)
	public ModelAndView nextPage(@PathVariable int currentPage, String title, String view,
			@RequestParam(value = "cars", required = false) ArrayList<String> cars) {
		ModelAndView mv = new ModelAndView(view);

		PaginationResults results = paginator.paginate(++currentPage);
		getModelAndView(title, mv, results);
		mv.addObject("completeresults", cars);

		return mv;
	}

	@RequestMapping(value = "previous/{currentPage}", method = RequestMethod.POST)
	public ModelAndView previousPage(@PathVariable int currentPage, String title, String view,
			@RequestParam(value = "cars", required = false) ArrayList<String> cars) {
		ModelAndView mv = new ModelAndView(view);

		PaginationResults results = paginator.paginate(--currentPage);
		getModelAndView(title, mv, results);
		mv.addObject("completeresults", cars);

		return mv;
	}

	private void getModelAndView(String title, ModelAndView mv, PaginationResults results) {
		mv.addObject("title", title);
		addBasicInformationToModel(mv);
		addPaginationInformation(mv, results);
	}
}
