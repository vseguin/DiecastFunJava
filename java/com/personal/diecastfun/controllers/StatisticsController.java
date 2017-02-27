package com.personal.diecastfun.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.personal.diecastfun.controllers.service.BrandFacade;
import com.personal.diecastfun.controllers.service.CarFacade;
import com.personal.diecastfun.controllers.service.MakerFacade;

@Controller
@RequestMapping(value = "/statistics")
public class StatisticsController extends BasicController
{
    @Autowired
    private BrandFacade brandFacade;
    @Autowired
    private CarFacade carFacade;
    @Autowired
    private MakerFacade makerFacade;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getStatisticsPage()
    {
        ModelAndView mv = getModelAndView("statistics");

        mv.addObject("brandcount", brandFacade.getTotalCount());
        mv.addObject("carcount", carFacade.getTotalCount());
        mv.addObject("makercount", brandFacade.getTotalCount());

        mv.addObject("brands", carFacade.getBrandsCount());
        mv.addObject("categories", carFacade.getTagsCount());
        mv.addObject("colors", carFacade.getColorsCount());
        mv.addObject("countries", carFacade.getCountriesCount());
        mv.addObject("eras", carFacade.getErasCount());
        mv.addObject("makers", carFacade.getMakersCount());

        mv.addObject("votes", carFacade.getVotesCount());

        return mv;
    }
}
