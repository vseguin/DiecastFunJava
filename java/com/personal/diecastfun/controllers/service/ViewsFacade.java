package com.personal.diecastfun.controllers.service;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;

import com.personal.diecastfun.domain.View;
import com.personal.diecastfun.domain.repositories.CarRepository;
import com.personal.diecastfun.domain.repositories.ViewsRepository;

public class ViewsFacade
{
    @Inject
    private CarRepository carsRepository;
    @Autowired
    private ViewsRepository viewsRepository;

    public void addView(String id)
    {
        if (carsRepository.exists(id)) {
            View view = viewsRepository.findOne(id);

            if (view == null) {
                view = new View(id, 0);
            }

            view.increment();
            viewsRepository.save(view);
        }
    }

    public int getViews(String id)
    {
        return viewsRepository.findOne(id).getNumber();
    }
}
