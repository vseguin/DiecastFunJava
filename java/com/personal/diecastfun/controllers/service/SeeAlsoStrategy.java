package com.personal.diecastfun.controllers.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import com.personal.diecastfun.domain.Car;
import com.personal.diecastfun.domain.repositories.CarRepository;

import info.debatty.java.stringsimilarity.QGram;

public class SeeAlsoStrategy extends Strategy
{
    private static final int SEE_ALSO_SIZE = 4;

    private CarRepository carRepository;
    private String id;

    public SeeAlsoStrategy(CarRepository carRepository, String id)
    {
        this.carRepository = carRepository;
        this.id = id;
    }

    @Override
    public List<Car> findCars()
    {
        List<Car> cars = carRepository.findByIdNotIn(Lists.newArrayList(id));

        QGram qgram = new QGram();

        List<SimilarityResult> similarities = cars.parallelStream()
                                                  .map(c -> new SimilarityResult(c, qgram.distance(c.getId(), id)))
                                                  .collect(Collectors.toList());

        return similarities.stream().sorted(new Comparator<SimilarityResult>()
        {
            @Override
            public int compare(SimilarityResult left, SimilarityResult right)
            {
                return left.getSimilarity().compareTo(right.getSimilarity());
            }
        }).limit(SEE_ALSO_SIZE).map(r -> r.getCar()).collect(Collectors.toList());
    }

    public class SimilarityResult
    {
        private Car car;
        private Double similarity;

        public SimilarityResult(Car car, Double similarity)
        {
            setCar(car);
            setSimilarity(similarity);
        }

        public Car getCar()
        {
            return car;
        }

        public void setCar(Car car)
        {
            this.car = car;
        }

        public Double getSimilarity()
        {
            return similarity;
        }

        public void setSimilarity(Double similarity)
        {
            this.similarity = similarity;
        }
    }
}
