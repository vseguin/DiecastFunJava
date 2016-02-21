package com.personal.diecastfun.controllers.models;

public class AddBrandModel {

	private String name;
	private String country;

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

	public AddBrandModel withCountry(String country) {
		setCountry(country);
		return this;
	}

	public AddBrandModel withName(String name) {
		setName(name);
		return this;
	}
}
