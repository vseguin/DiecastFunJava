package com.personal.diecastfun.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.personal.diecastfun.controllers.models.BrandModel;
import com.personal.diecastfun.controllers.models.CarModel;
import com.personal.diecastfun.controllers.models.ColorModel;
import com.personal.diecastfun.controllers.models.MakerModel;
import com.personal.diecastfun.controllers.service.BrandFacade;
import com.personal.diecastfun.controllers.service.CarFacade;
import com.personal.diecastfun.controllers.service.ColorFacade;
import com.personal.diecastfun.controllers.service.MakerFacade;
import com.personal.diecastfun.controllers.service.VotesFacade;
import com.personal.diecastfun.domain.Country;
import com.personal.diecastfun.domain.Era;
import com.personal.diecastfun.domain.Tags;

@Controller
@RequestMapping(value = "/statistics")
public class StatisticsController extends BasicController {

	@Inject
	private BrandFacade brandFacade;
	@Inject
	private CarFacade carFacade;
	@Inject
	private ColorFacade colorFacade;
	@Inject
	private MakerFacade makerFacade;
	@Inject
	private VotesFacade votesFacade;
	@Inject
	private ObjectMapper mapper;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getStatisticsPage() {
		ModelAndView mv = getModelAndView("statistics");

		return mv;
	}

	@RequestMapping(value = "/brands", method = RequestMethod.POST)
	@ResponseBody
	public String getBrandsStatistics() {
		Map<String, Integer> brandsCount = new HashMap<String, Integer>();
		for (BrandModel brand : brandFacade.findAllBrands()) {
			brandsCount.put(brand.getName(), brand.getCarCount());
		}

		return getJsonValue(brandsCount);
	}

	@RequestMapping(value = "/countries", method = RequestMethod.POST)
	@ResponseBody
	public String getCountriesStatistics() {
		Map<String, Integer> countriesCount = new HashMap<String, Integer>();
		for (Country country : Country.values()) {
			countriesCount.put(country.toString(), 0);
		}
		for (BrandModel brand : brandFacade.findAllBrands()) {
			String country = brand.getCountry();
			countriesCount.put(country, countriesCount.get(country) + brand.getCarCount());
		}

		return getJsonValue(countriesCount);
	}

	@RequestMapping(value = "/colors", method = RequestMethod.POST)
	@ResponseBody
	public String getColorsStatistics() {
		Map<String, Integer> colorsCount = new HashMap<String, Integer>();
		for (ColorModel color : colorFacade.findAllColors()) {
			colorsCount.put(color.getColor(), colorFacade.countByColor(color.getColor()));
		}

		return getJsonValue(colorsCount);
	}

	@RequestMapping(value = "/eras", method = RequestMethod.POST)
	@ResponseBody
	public String getErasStatistics() {
		Map<String, Integer> erasCount = new HashMap<String, Integer>();
		for (Era era : Era.values()) {
			erasCount.put(era.toString(), carFacade.countByEra(era));
		}

		return getJsonValue(erasCount);
	}

	@RequestMapping(value = "/makers", method = RequestMethod.POST)
	@ResponseBody
	public String getMakersStatistics() {
		Map<String, Integer> makersCount = new HashMap<String, Integer>();
		for (MakerModel maker : makerFacade.findAllMakers()) {
			makersCount.put(maker.getName(), maker.getCarCount());
		}

		return getJsonValue(makersCount);
	}

	@RequestMapping(value = "/tags", method = RequestMethod.POST)
	@ResponseBody
	public String getTagsStatistics() {
		Map<String, Integer> tagsCount = new HashMap<String, Integer>();
		for (Tags tag : Tags.values()) {
			tagsCount.put(tag.toString(), carFacade.countByTag(tag));
		}

		return getJsonValue(tagsCount);
	}

	@RequestMapping(value = "/votes", method = RequestMethod.POST)
	@ResponseBody
	public String getVotesStatistics() {
		Map<String, Integer> votesCount = new HashMap<String, Integer>();
		for (CarModel car : carFacade.findAllCars()) {
			int voteCount = votesFacade.getVotesById(car.getId());
			if (voteCount > 0) {
				votesCount.put(car.getBrand() + " " + car.getModel(), voteCount);
			}
		}

		return getJsonValue(votesCount);
	}

	private String getJsonValue(Map<String, Integer> values) {
		String response = "";
		try {
			response = mapper.writeValueAsString(values);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}
