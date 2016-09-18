package com.personal.diecastfun.controllers.models;

import com.personal.diecastfun.domain.Country;
import com.personal.diecastfun.utils.PicturesHelper;

public class CountryModel implements Comparable<CountryModel> {

	private String code;
	private String country;
	private String picture;
	private int carCount;

	public CountryModel(Country country) {
		this(country, 0);
	}

	public CountryModel(Country country, int carCount) {
		this.code = country.getCode();
		this.country = String.valueOf(country);
		this.picture = PicturesHelper.getPictureName(this.country.toLowerCase());
		this.carCount = carCount;

		if (country == Country.UnitedKingdom) {
			this.country = "United Kingdom";
		} else if (country == Country.UnitedStates) {
			this.country = "United States";
		} else if (country == Country.SouthKorea) {
			this.country = "South Korea";
		} else if (country == Country.CzechRepublic) {
			this.country = "Czech Republic";
		}
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getCarCount() {
		return carCount;
	}

	public void setCarCount(int carCount) {
		this.carCount = carCount;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public int compareTo(CountryModel model) {
		return this.getCountry().compareTo(model.getCountry());
	}
}
