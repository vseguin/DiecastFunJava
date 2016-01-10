package com.personal.diecastfun.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Views")
public class View implements Comparable<View> {

	@Id
	private String carId;
	private Integer number = 0;

	public View() {
	}

	public View(String carId, int number) {
		this.carId = carId;
		this.number = number;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public void incrementNumber() {
		number++;
	}

	@Override
	public int compareTo(View otherView) {
		return otherView.getNumber().compareTo(getNumber());
	}

	public void increment() {
		this.number++;
	}
}
