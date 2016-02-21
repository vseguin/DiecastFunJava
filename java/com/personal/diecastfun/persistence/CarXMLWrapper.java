package com.personal.diecastfun.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.personal.diecastfun.domain.XMLCar;

@XmlRootElement(name = "cars")
public class CarXMLWrapper {

	private List<XMLCar> cars = new ArrayList<XMLCar>();

	public List<XMLCar> getCars() {
		return cars;
	}

	public void setCars(List<XMLCar> cars) {
		this.cars = cars;
	}

	public CarXMLWrapper withCars(List<XMLCar> cars) {
		setCars(cars);
		return this;
	}
}