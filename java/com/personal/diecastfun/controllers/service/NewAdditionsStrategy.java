package com.personal.diecastfun.controllers.service;

import java.sql.Date;
import java.util.List;

import org.joda.time.DateTime;

import com.personal.diecastfun.domain.Car;
import com.personal.diecastfun.domain.repositories.CarRepository;

public class NewAdditionsStrategy extends Strategy
{
    private static final int NEW_ADDITIONS_SIZE = 15;
    private static final int NEW_ADDITIONS_DAYS = 15;

    private CarRepository carRepository;

    public NewAdditionsStrategy(CarRepository carRepository)
    {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> findCars()
    {
        DateTime date = DateTime.now().minusDays(NEW_ADDITIONS_DAYS);
        List<Car> cars = carRepository.findByInsertionDateAfter(new Date(date.getMillis()));

        return cars.subList(0, NEW_ADDITIONS_SIZE > cars.size() ? cars.size() : NEW_ADDITIONS_SIZE);
    }
}
