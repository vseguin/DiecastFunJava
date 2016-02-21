package com.personal.diecastfun.controllers.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.personal.diecastfun.controllers.models.ViewModel;
import com.personal.diecastfun.domain.Car;
import com.personal.diecastfun.domain.View;
import com.personal.diecastfun.domain.repositories.CarRepository;
import com.personal.diecastfun.domain.repositories.ViewsRepository;

public class ViewsFacade {

	@Inject
	private CarRepository carsRepository;
	@Autowired
	private ViewsRepository viewsRepository;

	public void addView(String id) {
		if (carsRepository.exists(id)) {
			View view = viewsRepository.findOne(id);

			if (view == null) {
				view = new View(id, 0);
			}

			view.increment();
			viewsRepository.save(view);
		}
	}

	public int getViews(String id) {
		return viewsRepository.findOne(id).getNumber();
	}

	public List<ViewModel> getAllViews() {
		List<Car> cars = Lists.newArrayList(carsRepository.findAll());
		List<ViewModel> views = new ArrayList<ViewModel>();
		for (View view : viewsRepository.findAllByOrderByNumberDesc()) {
			Car car = cars.stream().filter(c -> c.getId().equals(view.getCarId())).findFirst().get();
			views.add(new ViewModel(view.getCarId(), car.getCompleteName(), car.getMaker(), view.getNumber()));
		}

		return views;
	}

	public int getViewsCount() {
		int viewsCount = 0;
		for (View view : viewsRepository.findAll()) {
			viewsCount += view.getNumber();
		}

		return viewsCount;
	}
}
