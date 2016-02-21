package com.personal.diecastfun.conditions;

import com.personal.diecastfun.controllers.models.CarModel;
import com.personal.diecastfun.controllers.service.BrandFacade;

public class CountryCondition implements ICondition {

	private BrandFacade brandFacade;

	private String country;

	public CountryCondition(String country, BrandFacade brandFacade) {
		this.country = country;
		this.brandFacade = brandFacade;
	}

	@Override
	public boolean isValid(CarModel car) {
		return brandFacade.findBrand(car.getBrand()).getCountry().equalsIgnoreCase(country);
	}

	@Override
	public String getValue() {
		return country;
	}
}
