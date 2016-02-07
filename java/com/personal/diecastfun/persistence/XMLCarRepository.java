package com.personal.diecastfun.persistence;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.google.common.collect.Lists;
import com.personal.diecastfun.domain.Car;
import com.personal.diecastfun.domain.CarRepository;
import com.personal.diecastfun.domain.Era;
import com.personal.diecastfun.domain.Tags;
import com.personal.diecastfun.utils.ConfigManager;

public class XMLCarRepository implements CarRepository {

	private Map<String, Car> cars = new HashMap<String, Car>();
	private XMLSerializer<CarXMLWrapper> serializer;

	public XMLCarRepository() throws Exception {
		serializer = new XMLSerializer<CarXMLWrapper>(CarXMLWrapper.class);
		parseXML();
	}

	@Override
	public int countAll() {
		return cars.values().size();
	}

	@Override
	public int countByBrand(String brand) {
		int count = 0;
		for (Car car : cars.values()) {
			if (car.getBrand().equals(brand)) {
				count++;
			}
		}
		return count;
	}

	@Override
	public int countByColor(String color) {
		int count = 0;
		for (Car car : cars.values()) {
			if (car.getColor().equals(color)) {
				count++;
			}
		}
		return count;
	}

	@Override
	public int countByEra(Era era) {
		int count = 0;
		for (Car car : cars.values()) {
			if (car.getEra().equals(era)) {
				count++;
			}
		}
		return count;
	}

	@Override
	public int countByMaker(String maker) {
		int count = 0;
		for (Car car : cars.values()) {
			if (car.getMaker().equals(maker)) {
				count++;
			}
		}
		return count;
	}

	@Override
	public int countByTag(Tags tag) {
		int count = 0;
		for (Car car : cars.values()) {
			if (car.getTags().contains(tag)) {
				count++;
			}
		}
		return count;
	}

	@Override
	public Collection<Car> findAll() {
		return cars.values();
	}

	@Override
	public List<Car> findByBrand(String brand) {
		List<Car> foundCars = new ArrayList<Car>();
		for (Car car : cars.values()) {
			if (car.getBrand().equals(brand)) {
				foundCars.add(car);
			}
		}
		return foundCars;
	}

	@Override
	public List<Car> findByCategory(String category) {
		List<Car> foundCars = new ArrayList<Car>();
		for (Car car : cars.values()) {
			if (car.getTags().contains(Tags.valueOf(category))) {
				foundCars.add(car);
			}
		}
		return foundCars;
	}

	@Override
	public List<Car> findByEra(Era era) {
		List<Car> foundCars = new ArrayList<Car>();
		for (Car car : cars.values()) {
			if (car.getEra().equals(era)) {
				foundCars.add(car);
			}
		}
		return foundCars;
	}

	@Override
	public List<Car> findByMaker(String maker) {
		List<Car> foundCars = new ArrayList<Car>();
		for (Car car : cars.values()) {
			if (car.getMaker().equals(maker)) {
				foundCars.add(car);
			}
		}
		return foundCars;
	}

	@Override
	public Car findById(String id) {
		return cars.get(id);
	}

	@Override
	public Calendar findMostRecentInsertionDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -10);
		for (Car car : cars.values()) {
			Calendar carCalendar = car.getInsertionDateAsCalendar();
			if (carCalendar.after(calendar)) {
				calendar = carCalendar;
			}
		}

		return calendar;
	}

	@Override
	public String findRandomId() {
		Random generator = new Random();
		Object[] values = cars.keySet().toArray();
		return (String) values[generator.nextInt(values.length)];
	}

	@Override
	public List<Car> findCustomizations() {
		List<Car> foundCars = new ArrayList<Car>();
		for (Car car : cars.values()) {
			if (car.isCustomized()) {
				foundCars.add(car);
			}
		}
		return foundCars;
	}

	@Override
	public List<Car> findRestorations() {
		List<Car> foundCars = new ArrayList<Car>();
		for (Car car : cars.values()) {
			if (car.isRestaured()) {
				foundCars.add(car);
			}
		}
		return foundCars;
	}

	@Override
	public boolean exists(String carId) {
		return cars.containsKey(carId);
	}

	@Override
	public void save(Car car) {
		cars.put(car.getCompleteId(), car);

		try {
			serializer.serialize(new CarXMLWrapper().withCars(Lists.newArrayList(cars.values())), getResourceName());
		} catch (Exception e) {
			// TODO vseguin : this will disappear
			System.out.println("Unable to save car :" + e.getMessage());
		}
	}

	private void parseXML() throws Exception {
		List<Car> deserializedCars = serializer.deserialize(getResourceName()).getCars();
		for (Car car : deserializedCars) {
			cars.put(car.getCompleteId(), car);
		}
	}

	private String getResourceName() {
		return ConfigManager.getConfigManager().getCarsFilePath();
	}

}
