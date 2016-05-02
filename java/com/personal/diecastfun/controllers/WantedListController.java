package com.personal.diecastfun.controllers;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;
import com.personal.diecastfun.domain.WantedCar;
import com.personal.diecastfun.domain.repositories.WantedCarRepository;

@Controller
@RequestMapping(value = "/wantedlist")
public class WantedListController extends BasicController {

	@Autowired
	private WantedCarRepository wantedCarRepository;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getWantedList() {
		ModelAndView mv = new ModelAndView("wantedlist");

		List<WantedCar> wantedCars = Lists.newArrayList(wantedCarRepository.findAllByOrderByMakerAsc());
		Map<String, List<WantedCar>> groupedCars = wantedCars.stream()
				.collect(Collectors.groupingBy(WantedCar::getMaker, LinkedHashMap::new, Collectors.toList()));

		groupedCars.values().stream().forEach(l -> {
			Collections.sort(l, new Comparator<WantedCar>() {
				@Override
				public int compare(WantedCar o1, WantedCar o2) {
					return o1.getBrand().compareTo(o2.getBrand());
				}
			});
		});

		mv.addObject("wantedList", groupedCars);

		addBasicInformationToModel(mv);

		return mv;
	}
}
