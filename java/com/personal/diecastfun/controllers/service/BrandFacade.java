package com.personal.diecastfun.controllers.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.personal.diecastfun.controllers.models.BrandModel;
import com.personal.diecastfun.controllers.models.CountryModel;
import com.personal.diecastfun.domain.Brand;
import com.personal.diecastfun.domain.Country;
import com.personal.diecastfun.domain.repositories.BrandsRepository;
import com.personal.diecastfun.domain.repositories.CarRepository;
import com.personal.diecastfun.utils.PicturesHelper;

@Component
@DependsOn("brandsRepository")
public class BrandFacade {

	@Autowired
	private BrandsRepository brandsRepository;
	@Autowired
	private CarRepository carRepository;

	private Map<String, Integer> brandCounts = Maps.newHashMap();

	public void addBrand(String brandName, String country) {
		Brand brand = new Brand().withName(brandName).withCountry(Country.valueOf(country));

		brandsRepository.save(brand);
		brandCounts.put(brandName, 0);
	}

	public List<BrandModel> findAllBrands() {
		return getModels(brandsRepository.findAll());
	}

	public List<CountryModel> findCountries() {
		List<CountryModel> countries = new ArrayList<CountryModel>();
		for (Country countryEnum : Country.values()) {
			if (countryEnum != Country.Unknown) {
				int totalCarCount = 0;
				for (BrandModel brand : findBrandsByCountry(countryEnum)) {
					totalCarCount += brand.getCarCount();
				}
				countries.add(new CountryModel(countryEnum, totalCarCount));
			}
		}
		Collections.sort(countries);
		return countries;
	}

	public List<BrandModel> findBrandsByCountry(Country country) {
		return getModels(brandsRepository.findByCountry(country));
	}

	public BrandModel findBrand(String brandName) {
		Brand brand = brandsRepository.findOne(brandName);
		return new BrandModel(brand, PicturesHelper.getPictureName(brandName), brandCounts.get(brandName));
	}

	public void updateBrand(String brandName) {
		Integer brandCount = brandCounts.get(brandName);
		brandCount++;

		brandCounts.put(brandName, brandCount);
	}

	private List<BrandModel> getModels(Iterable<Brand> brands) {
		List<BrandModel> models = new ArrayList<BrandModel>();
		for (Brand brand : brands) {
			BrandModel model = new BrandModel(brand, PicturesHelper.getPictureName(brand.getName()),
					brandCounts.get(brand.getName()));
			models.add(model);
		}

		return models;
	}

	@PostConstruct
	private void init() {
		List<Brand> brands = Lists.newArrayList(brandsRepository.findAll());
		brands.forEach(b -> {
			brandCounts.put(b.getName(), carRepository.countByBrand(b.getName()));
		});
	}

}
