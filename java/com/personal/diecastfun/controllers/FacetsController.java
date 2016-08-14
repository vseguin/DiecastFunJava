package com.personal.diecastfun.controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.personal.diecastfun.conditions.BrandCondition;
import com.personal.diecastfun.conditions.CategoryCondition;
import com.personal.diecastfun.conditions.ColorCondition;
import com.personal.diecastfun.conditions.CountryCondition;
import com.personal.diecastfun.conditions.EraCondition;
import com.personal.diecastfun.conditions.MakerCondition;
import com.personal.diecastfun.controllers.models.BrandModel;
import com.personal.diecastfun.controllers.models.CarModel;
import com.personal.diecastfun.controllers.models.ColorModel;
import com.personal.diecastfun.controllers.models.CountryModel;
import com.personal.diecastfun.controllers.models.EraModel;
import com.personal.diecastfun.controllers.models.MakerModel;
import com.personal.diecastfun.controllers.models.SortedList;
import com.personal.diecastfun.controllers.models.TagModel;
import com.personal.diecastfun.controllers.service.BrandFacade;
import com.personal.diecastfun.controllers.service.ColorFacade;
import com.personal.diecastfun.controllers.service.ConditionResolverFacade;
import com.personal.diecastfun.controllers.service.EraFacade;
import com.personal.diecastfun.controllers.service.MakerFacade;
import com.personal.diecastfun.controllers.service.TagsFacade;
import com.personal.diecastfun.domain.Era;
import com.personal.diecastfun.domain.Tags;
import com.personal.diecastfun.utils.Paginator;

@Controller
@RequestMapping(value = "/facets")
public class FacetsController extends BasicController {

	@Inject
	private BrandFacade brandFacade;
	@Inject
	private ColorFacade colorFacade;
	@Inject
	private ConditionResolverFacade conditionResolverFacade;
	@Inject
	private EraFacade eraFacade;
	@Inject
	private MakerFacade makerFacade;
	@Inject
	private Paginator paginator;
	@Inject
	private TagsFacade tagsFacade;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getFacets() {
		ModelAndView mv = getModelAndView("facets");

		conditionResolverFacade.clearAll();
		addCarsToView(mv);
		mv.addObject("brands", new SortedList<BrandModel>(brandFacade.findAllBrands()).getCollection());
		mv.addObject("eras", new SortedList<EraModel>(eraFacade.findAllEras()).getCollection());
		mv.addObject("makers", new SortedList<MakerModel>(makerFacade.findAllMakers()).getCollection());
		mv.addObject("categories", new SortedList<TagModel>(tagsFacade.findAllTags()).getCollection());
		mv.addObject("colors", new SortedList<ColorModel>(colorFacade.findAllColors()).getCollection());
		mv.addObject("countries", new SortedList<CountryModel>(brandFacade.findCountries()).getCollection());

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addbrand")
	public ModelAndView addBrandCondition(String brand, int carCount) {
		conditionResolverFacade.addCondition(new BrandCondition(brand));

		return computeResults(carCount);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/removebrand")
	public ModelAndView removeBrandCondition(String brand, int carCount) {
		conditionResolverFacade.removeCondition(brand);

		return computeResults(carCount);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/removebrands")
	public ModelAndView removeBrandConditions(int carCount) {
		conditionResolverFacade.removeConditions(BrandCondition.class);

		return computeResults(carCount);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addmaker")
	public ModelAndView addMakerCondition(String maker, int carCount) {
		conditionResolverFacade.addCondition(new MakerCondition(maker));

		return computeResults(carCount);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/removemaker")
	public ModelAndView removeMakerCondition(String maker, int carCount) {
		conditionResolverFacade.removeCondition(maker);

		return computeResults(carCount);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/removemakers")
	public ModelAndView removeMakerConditions(int carCount) {
		conditionResolverFacade.removeConditions(MakerCondition.class);

		return computeResults(carCount);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addera")
	public ModelAndView addEraCondition(String era, int carCount) {
		conditionResolverFacade.addCondition(new EraCondition(Era.valueOf(era)));

		return computeResults(carCount);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/removeera")
	public ModelAndView removeEraCondition(String era, int carCount) {
		conditionResolverFacade.removeCondition(era);

		return computeResults(carCount);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/removeeras")
	public ModelAndView removeEraConditions(int carCount) {
		conditionResolverFacade.removeConditions(EraCondition.class);

		return computeResults(carCount);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addcategory")
	public ModelAndView addCategoryCondition(String category, int carCount) {
		conditionResolverFacade.addCondition(new CategoryCondition(Tags.valueOf(category)));

		return computeResults(carCount);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/removecategory")
	public ModelAndView removeCategoryCondition(String category, int carCount) {
		conditionResolverFacade.removeCondition(category);

		return computeResults(carCount);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/removecategories")
	public ModelAndView removeCategoriesConditions(int carCount) {
		conditionResolverFacade.removeConditions(CategoryCondition.class);

		return computeResults(carCount);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addcolor")
	public ModelAndView addColorCondition(String color, int carCount) {
		conditionResolverFacade.addCondition(new ColorCondition(color));

		return computeResults(carCount);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/removecolor")
	public ModelAndView removeColorCondition(String color, int carCount) {
		conditionResolverFacade.removeCondition(color);

		return computeResults(carCount);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/removecolors")
	public ModelAndView removeColorsConditions(int carCount) {
		conditionResolverFacade.removeConditions(ColorCondition.class);

		return computeResults(carCount);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addcountry")
	public ModelAndView addCountryCondition(String country, int carCount) {
		conditionResolverFacade.addCondition(new CountryCondition(country, brandFacade));

		return computeResults(carCount);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/removecountry")
	public ModelAndView removeCountryCondition(String country, int carCount) {
		conditionResolverFacade.removeCondition(country);

		return computeResults(carCount);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/removecountries")
	public ModelAndView removeCountriesConditions(int carCount) {
		conditionResolverFacade.removeConditions(CountryCondition.class);

		return computeResults(carCount);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/clearall")
	public ModelAndView clearAll(int carCount) {
		conditionResolverFacade.clearAll();

		return computeResults(carCount);
	}

	private ModelAndView computeResults(int carCount) {
		ModelAndView mv = getModelAndView("facetsresults");

		addCarsToView(mv, ++carCount);

		return mv;
	}

	private void addCarsToView(ModelAndView mv) {
		List<CarModel> cars = conditionResolverFacade.resolveConditions();
		SortedList<CarModel> sortedCars = new SortedList<CarModel>(cars);

		addPaginationInformation(mv, paginator.paginate(sortedCars));
	}

	private void addCarsToView(ModelAndView mv, int carCount) {
		List<CarModel> cars = conditionResolverFacade.resolveConditions();
		SortedList<CarModel> sortedCars = new SortedList<CarModel>(cars);

		addPaginationInformation(mv, paginator.paginateWithCount(carCount, sortedCars));
	}
}
