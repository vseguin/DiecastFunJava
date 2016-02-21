package com.personal.diecastfun.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Brands")
public class Brand {

	@Id
	private String name;

	@Enumerated(EnumType.STRING)
	private Country country;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Brand withCountry(Country country) {
		setCountry(country);
		return this;
	}

	public Brand withName(String name) {
		setName(name);
		return this;
	}
}
