package com.personal.diecastfun.controllers.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;
import com.personal.diecastfun.controllers.models.CarModel;
import com.personal.diecastfun.domain.Car;
import com.personal.diecastfun.domain.Vote;
import com.personal.diecastfun.domain.repositories.CarRepository;
import com.personal.diecastfun.domain.repositories.VotesRepository;

public class MostPopularStrategy extends Strategy {

	private static final int MOST_POPULAR_SIZE = 19;

	private CarRepository carRepository;
	private VotesRepository votesRepository;

	public MostPopularStrategy(CarRepository carRepository, VotesRepository votesRepository) {
		this.carRepository = carRepository;
		this.votesRepository = votesRepository;
	}

	@Override
	public List<CarModel> findCars(List<Car> cars) {
		List<CarModel> models = new ArrayList<CarModel>();

		Vote topVote = votesRepository.findTop1ByOrderByNumberDesc();

		if (topVote != null) {
			int currentVoteValue = topVote.getNumber();
			int limitValue = 0;
			List<Vote> votes = Lists.newArrayList(votesRepository.findAll());

			while (models.size() <= MOST_POPULAR_SIZE && currentVoteValue > limitValue) {
				currentVoteValue--;
				Iterator<Vote> iterator = votes.iterator();
				while (iterator.hasNext()) {
					Vote vote = iterator.next();
					if (vote != null && vote.getNumber() > currentVoteValue) {
						addCarModel(models, carRepository.findOne(vote.getId()));
						iterator.remove();
					}
				}
			}
		}

		return models;
	}
}
