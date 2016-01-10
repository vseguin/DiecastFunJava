package com.personal.diecastfun.controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.personal.diecastfun.controllers.service.BasicFacade;
import com.personal.diecastfun.controllers.service.CarFacade;

@Controller
public class HomeController extends BasicController {

  @Inject
  private BasicFacade basicFacade;
  @Inject
  private CarFacade carFacade;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ModelAndView home() {
    ModelAndView mv = new ModelAndView("home");

    mv.addObject("newadditions", carFacade.findNewAdditions());
    mv.addObject("restorations", carFacade.findRandomRestorations());
    mv.addObject("customs", carFacade.findCustomizations());
    mv.addObject("mostpopular", carFacade.findMostPopular());
    mv.addObject("featuredcar", carFacade.findCarById(carFacade.findRandomCarId()));
    addBasicInformationToModel(mv, basicFacade.getTotalCarCount());

    return mv;
  }
}
