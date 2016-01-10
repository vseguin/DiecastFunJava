package com.personal.diecastfun.controllers.models;

public class ViewModel {

	private String id;
	private String brandName;
	private String carName;
	private int number;

	public ViewModel() {
	}

	public ViewModel(String id, String carName, String brandName, int number) {
		this.id = id;
		this.carName = carName;
		this.number = number;
		this.brandName = brandName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
}
