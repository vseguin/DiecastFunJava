package com.personal.diecastfun.persistence;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.personal.diecastfun.domain.XMLCar;
import com.personal.diecastfun.utils.ConfigManager;

public class XMLCarRepository {

	private Map<String, XMLCar> cars = new HashMap<String, XMLCar>();
	private XMLSerializer<CarXMLWrapper> serializer;

	public XMLCarRepository() throws Exception {
		serializer = new XMLSerializer<CarXMLWrapper>(CarXMLWrapper.class);
		parseXML();
	}

	public Collection<XMLCar> findAll() {
		return cars.values();
	}

	private void parseXML() throws Exception {
		List<XMLCar> deserializedCars = serializer.deserialize(getResourceName()).getCars();
		for (XMLCar car : deserializedCars) {
			cars.put(car.getCompleteId(), car);
		}
	}

	private String getResourceName() {
		return ConfigManager.getConfigManager().getCarsFilePath();
	}

}
