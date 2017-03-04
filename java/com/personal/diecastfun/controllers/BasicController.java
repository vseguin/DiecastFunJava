package com.personal.diecastfun.controllers;

import javax.inject.Inject;

import org.springframework.web.servlet.ModelAndView;

import com.personal.diecastfun.controllers.service.ConfigFacade;

public abstract class BasicController
{
    @Inject
    private ConfigFacade configFacade;

    protected ModelAndView getModelAndView(String viewName)
    {
        ModelAndView mv = new ModelAndView("main");

        mv.addObject("picturesUrl", configFacade.getPicturesUrl());
        mv.addObject("view", viewName);

        return mv;
    }
}
