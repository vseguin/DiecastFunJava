package com.personal.diecastfun.controllers.models;

import com.personal.diecastfun.domain.Brand;

public class BrandModel implements Comparable<BrandModel> {

	private String name;
	private String country;
	private String countryCode;
	private String pictureName;
	private int carCount;

	public BrandModel() {

	}

	public BrandModel(Brand brand, String pictureName, int carCount) {
		this.name = brand.getName();
		this.country = String.valueOf(brand.getCountry());
		this.setCountryCode(brand.getCountry().getCode());
		this.pictureName = pictureName;
		this.carCount = carCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPictureName() {
		return pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	public int getCarCount() {
		return carCount;
	}

	public void setCarCount(int carCount) {
		this.carCount = carCount;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	@Override
	public int compareTo(BrandModel brand) {
		return this.getName().compareTo(brand.getName());
	}
}