package com.personal.diecastfun.controllers;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.personal.diecastfun.controllers.models.CarModel;
import com.personal.diecastfun.controllers.models.SortedList;
import com.personal.diecastfun.controllers.service.CarFacade;
import com.personal.diecastfun.controllers.service.ViewsFacade;
import com.personal.diecastfun.domain.Comment;
import com.personal.diecastfun.domain.repositories.CommentsRepository;
import com.personal.diecastfun.utils.PaginationResults;
import com.personal.diecastfun.utils.Paginator;

@Controller
public class MiscellaneousController extends BasicController {

	@Inject
	private CarFacade carFacade;
	@Inject
	private ViewsFacade viewsFacade;
	@Inject
	private Paginator paginator;

	@Autowired
	private CommentsRepository commentsRepository;

	@RequestMapping(value = "/views", method = RequestMethod.GET)
	public ModelAndView getViews() {
		ModelAndView mv = getModelAndView("views");

		mv.addObject("views", viewsFacade.getAllViews());
		mv.addObject("viewscount", viewsFacade.getViewsCount());

		return mv;
	}

	@RequestMapping(value = "/guestbook", method = RequestMethod.GET)
	public ModelAndView getGuestBook() {
		ModelAndView mv = getModelAndView("guestbook");

		mv.addObject("comments", commentsRepository.findAll());

		return mv;
	}

	@RequestMapping(value = "/guestbook", method = RequestMethod.POST)
	public ModelAndView postNewComment(@ModelAttribute("comment") Comment comment) {
		if (!comment.getMessage().contains("http")) {
			commentsRepository.save(comment);
		}

		return getGuestBook();
	}

	@RequestMapping(value = "/mostpopular", method = RequestMethod.GET)
	public ModelAndView getMostPopular() {
		return buildModelAndView("Most Popular", new SortedList<CarModel>(carFacade.findMostPopular()));
	}

	@RequestMapping(value = "/customs", method = RequestMethod.GET)
	public ModelAndView getCustoms() {
		return buildModelAndView("Customs", new SortedList<CarModel>(carFacade.findCustomizations()));
	}

	@RequestMapping(value = "/restorations", method = RequestMethod.GET)
	public ModelAndView getRestorations() {
		return buildModelAndView("Restorations", new SortedList<CarModel>(carFacade.findRestorations()));
	}

	private ModelAndView buildModelAndView(String title, SortedList<CarModel> cars) {
		ModelAndView mv = getModelAndView("carlist");

		PaginationResults results = paginator.paginate(cars);
		mv.addObject("title", title);
		addPaginationInformation(mv, results);

		return mv;
	}
}
