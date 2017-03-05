package com.personal.diecastfun.controllers.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
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
        List<Car> cars = carRepository.findByIdNotIn(Lists.newArrayList(id));

        List<SimilarityResult> similarities = cars.parallelStream()
                                                  .map(c -> new SimilarityResult(c,
                                                                                 dice(bigram(c.getId()), bigram(id))))
                                                  .collect(Collectors.toList());

        return similarities.stream().sorted(new Comparator<SimilarityResult>()
        {
            @Override
            public int compare(SimilarityResult left, SimilarityResult right)
            {
                return right.getSimilarity().compareTo(left.getSimilarity());
            }
        }).limit(SEE_ALSO_SIZE).map(r -> r.getCar()).collect(Collectors.toList());
    }

    private List<char[]> bigram(String input)
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
