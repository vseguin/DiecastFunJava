package com.personal.diecastfun.controllers.service;

import java.util.List;

import com.personal.diecastfun.domain.Car;

public abstract class Strategy
{
    public abstract List<Car> findCars();
}
