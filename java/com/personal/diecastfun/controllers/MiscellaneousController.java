package com.personal.diecastfun.controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.personal.diecastfun.controllers.models.CarModel;
import com.personal.diecastfun.controllers.models.SortedList;
import com.personal.diecastfun.controllers.service.CarFacade;
import com.personal.diecastfun.utils.PaginationResults;
import com.personal.diecastfun.utils.Paginator;

@Controller
public class MiscellaneousController extends BasicController
{

    @Inject
    private CarFacade carFacade;
    @Inject
    private Paginator paginator;

    @RequestMapping(value = "/mostpopular", method = RequestMethod.GET)
    public ModelAndView getMostPopular()
    {
        return buildModelAndView("Most Popular", new SortedList<CarModel>(carFacade.findMostPopular()));
    }

    @RequestMapping(value = "/customs", method = RequestMethod.GET)
    public ModelAndView getCustoms()
    {
        return buildModelAndView("Customs", new SortedList<CarModel>(carFacade.findCustomizations()));
    }

    @RequestMapping(value = "/restorations", method = RequestMethod.GET)
    public ModelAndView getRestorations()
    {
        return buildModelAndView("Restorations", new SortedList<CarModel>(carFacade.findRestorations()));
    }

    private ModelAndView buildModelAndView(String title, SortedList<CarModel> cars)
    {
        ModelAndView mv = getModelAndView("carlist");

        PaginationResults results = paginator.paginate(cars);
        mv.addObject("title", title);
        addPaginationInformation(mv, results);

        return mv;
    }
}
