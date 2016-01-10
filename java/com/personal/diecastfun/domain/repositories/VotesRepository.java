package com.personal.diecastfun.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.personal.diecastfun.domain.Vote;

public interface VotesRepository extends CrudRepository<Vote, String> {
	Vote findTop1ByOrderByNumberDesc();
}
