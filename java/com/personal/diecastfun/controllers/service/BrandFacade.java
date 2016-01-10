package com.personal.diecastfun.controllers.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;

import com.personal.diecastfun.controllers.models.BrandModel;
import com.personal.diecastfun.controllers.models.CountryModel;
import com.personal.diecastfun.domain.Brand;
import com.personal.diecastfun.domain.CarRepository;
import com.personal.diecastfun.domain.Country;
import com.personal.diecastfun.domain.repositories.BrandsRepository;
import com.personal.diecastfun.utils.PicturesHelper;

public class BrandFacade {

	@Autowired
	private BrandsRepository brandsRepository;

	@Inject
	private CarRepository carRepository;

	public List<BrandModel> findAllBrands() {
		return getModels(brandsRepository.findAll());
	}

	public List<CountryModel> findCountries() {
		List<CountryModel> countries = new ArrayList<CountryModel>();
		for (Country countryEnum : Country.values()) {
			if (countryEnum != Country.Unknown) {
				int totalCarCount = 0;
				for (BrandModel brand : findBrandsByCountry(String.valueOf(countryEnum))) {
					totalCarCount += brand.getCarCount();
				}
				countries.add(new CountryModel(countryEnum, totalCarCount));
			}
		}
		Collections.sort(countries);
		return countries;
	}

	public List<BrandModel> findBrandsByCountry(String country) {
		return getModels(brandsRepository.findByCountry(Country.valueOf(country)));
	}

	public BrandModel findBrand(String brandName) {
		Brand brand = brandsRepository.findOne(brandName);
		return new BrandModel(brand, PicturesHelper.getPictureName(brandName),
				carRepository.countByBrand(brand.getName()));
	}

	private List<BrandModel> getModels(Iterable<Brand> brands) {
		List<BrandModel> models = new ArrayList<BrandModel>();
		for (Brand brand : brands) {
			BrandModel model = new BrandModel(brand, PicturesHelper.getPictureName(brand.getName()),
					carRepository.countByBrand(brand.getName()));
			models.add(model);
		}

		return models;
	}
}
