package com.personal.diecastfun.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Makers")
public class Maker {

	@Id
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Maker withName(String name) {
		setName(name);
		return this;
	}
}
