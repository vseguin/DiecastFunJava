package com.personal.diecastfun.domain.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.personal.diecastfun.domain.Vote;

public interface VotesRepository extends CrudRepository<Vote, String>
{
    List<Vote> findAllByOrderByNumberDesc();
}
