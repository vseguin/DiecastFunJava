package com.personal.diecastfun.domain;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;

public interface CarRepository {

  public int countAll();

  public int countByBrand(String brand);

  public int countByColor(String color);

  public int countByEra(Era era);

  public int countByMaker(String maker);

  public int countByTag(Tags tag);

  public boolean exists(String carId);

  public Collection<Car> findAll();

  public Calendar findMostRecentInsertionDate();

  public List<Car> findByBrand(String brand);

  public List<Car> findByCategory(String category);

  public List<Car> findByEra(Era era);

  public List<Car> findByMaker(String maker);

  public List<Car> findCustomizations();

  public List<Car> findRestorations();

  public String findRandomId();

  public Car findById(String id);
}
