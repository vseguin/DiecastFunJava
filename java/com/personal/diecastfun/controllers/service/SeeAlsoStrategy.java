package com.personal.diecastfun.controllers.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.personal.diecastfun.domain.Car;
import com.personal.diecastfun.domain.repositories.CarRepository;

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
        Iterable<Car> cars = carRepository.findAll();
        List<Car> results = new ArrayList<>();

        double currentSimilarity = 1;
        double limitValue = 0;

        while (results.size() < SEE_ALSO_SIZE && currentSimilarity > limitValue) {
            currentSimilarity -= 0.1;
            Iterator<Car> iterator = cars.iterator();
            while (iterator.hasNext()) {
                Car car = iterator.next();
                if (car.getId().equals(id)) {
                    iterator.remove();
                } else if (results.size() < SEE_ALSO_SIZE) {
                    double dice = dice(bigram(car.getId()), bigram(id));
                    if (dice > currentSimilarity || dice < (currentSimilarity * -1)) {
                        results.add(car);
                        iterator.remove();
                    }
                }
            }
        }

        return results;
    }

    public List<char[]> bigram(String input)
    {
        ArrayList<char[]> bigram = new ArrayList<char[]>();
        for (int i = 0; i < input.length() - 1; i++) {
            char[] chars = new char[2];
            chars[0] = input.charAt(i);
            chars[1] = input.charAt(i + 1);
            bigram.add(chars);
        }
        return bigram;
    }

    private double dice(List<char[]> bigram1, List<char[]> bigram2)
    {
        List<char[]> copy = new ArrayList<char[]>(bigram2);
        int matches = 0;
        for (int i = bigram1.size(); --i >= 0;) {
            char[] bigram = bigram1.get(i);
            for (int j = copy.size(); --j >= 0;) {
                char[] toMatch = copy.get(j);
                if (bigram[0] == toMatch[0] && bigram[1] == toMatch[1]) {
                    copy.remove(j);
                    matches += 2;
                    break;
                }
            }
        }
        return (double) matches / (bigram1.size() + bigram2.size());
    }
}
