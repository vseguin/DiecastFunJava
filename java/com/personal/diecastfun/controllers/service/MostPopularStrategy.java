package com.personal.diecastfun.controllers.service;

import java.util.ArrayList;
import java.util.List;

import com.personal.diecastfun.domain.Car;
import com.personal.diecastfun.domain.Vote;
import com.personal.diecastfun.domain.repositories.CarRepository;
import com.personal.diecastfun.domain.repositories.VotesRepository;

public class MostPopularStrategy extends Strategy
{
    private static final int MOST_POPULAR_SIZE = 20;

    private CarRepository carRepository;
    private VotesRepository votesRepository;

    public MostPopularStrategy(CarRepository carRepository, VotesRepository votesRepository)
    {
        this.carRepository = carRepository;
        this.votesRepository = votesRepository;
    }

    @Override
    public List<Car> findCars()
    {
        List<Car> cars = new ArrayList<>();
        List<Vote> votes = votesRepository.findAllByOrderByNumberDesc();

        votes = votes.subList(0, MOST_POPULAR_SIZE > votes.size() ? votes.size() : MOST_POPULAR_SIZE);

        votes.forEach(v -> {
            cars.add(carRepository.findOne(v.getId()));
        });

        return cars;
    }
}
