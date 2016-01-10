package com.personal.diecastfun.controllers.models;

import com.personal.diecastfun.domain.Maker;

public class MakerModel implements Comparable<MakerModel> {

	private String name;
	private String pictureName;
	private int carCount;

	public MakerModel() {

	}

	public MakerModel(Maker maker, String pictureName, int carCount) {
		this.name = maker.getName();
		this.pictureName = pictureName;
		this.carCount = carCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public int compareTo(MakerModel maker) {
		return this.getName().compareTo(maker.getName());
	}

}
