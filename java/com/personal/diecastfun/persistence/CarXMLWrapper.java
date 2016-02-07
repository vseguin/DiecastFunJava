package com.personal.diecastfun.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.personal.diecastfun.domain.Car;

@XmlRootElement(name = "cars")
public class CarXMLWrapper {

	private List<Car> cars = new ArrayList<Car>();

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public CarXMLWrapper withCars(List<Car> cars) {
		setCars(cars);
		return this;
	}
}