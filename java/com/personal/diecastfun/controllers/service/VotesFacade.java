package com.personal.diecastfun.controllers.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.personal.diecastfun.domain.Vote;
import com.personal.diecastfun.domain.repositories.VotesRepository;

public class VotesFacade {

	@Autowired
	private VotesRepository votesRepository;

	public int getVotesById(String id) {
		return findVote(id).getNumber();
	}

	public void decreaseVote(String id) {
		Vote vote = findVote(id);
		vote.decreaseNumber();
		votesRepository.save(vote);
	}

	public void increaseVote(String id) {
		Vote vote = findVote(id);
		vote.increaseNumber();
		votesRepository.save(vote);
	}

	private Vote findVote(String id) {
		Vote vote = votesRepository.findOne(id);
		if (vote == null) {
			vote = new Vote(id, 0);
		}

		return vote;
	}
}
