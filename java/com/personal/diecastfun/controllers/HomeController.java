package com.personal.diecastfun.controllers;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.personal.diecastfun.controllers.models.CarModel;
import com.personal.diecastfun.controllers.models.SortedList;
import com.personal.diecastfun.controllers.service.CarFacade;

@Controller
public class HomeController extends BasicController
{
    @Inject
    private CarFacade carFacade;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home()
    {
        ModelAndView mv = getModelAndView("home");

        mv.addObject("carcount", carFacade.getTotalCount());
        mv.addObject("newadditions", carFacade.findNewAdditions());
        mv.addObject("restoration", getRandomCarModelFromList(carFacade.findRestorations()));
        mv.addObject("custom", getRandomCarModelFromList(carFacade.findCustomizations()));
        mv.addObject("mostpopular", getRandomCarModelFromList(carFacade.findMostPopular()));
        mv.addObject("featuredcar", carFacade.findCarById(carFacade.findRandomCarId()));

        return mv;
    }

    @RequestMapping(value = "/mostpopular", method = RequestMethod.GET)
    public ModelAndView getMostPopularCars()
    {
        ModelAndView mv = getModelAndView("carlist");

        List<CarModel> cars = carFacade.findMostPopular();

        mv.addObject("cars", new SortedList<>(cars));
        mv.addObject("title", "Most Popular");
        mv.addObject("totalCount", cars.size());
        mv.addObject("hidePagination", true);

        return mv;
    }

    private CarModel getRandomCarModelFromList(List<CarModel> carModels)
    {
        CarModel car = null;
        Random random = new Random();

        if (!carModels.isEmpty()) {
            car = carModels.get(random.nextInt(carModels.size()));
        }

        return car;
    }
}
