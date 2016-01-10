package com.personal.diecastfun.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.personal.diecastfun.domain.Maker;

public interface MakersRepository extends CrudRepository<Maker, String> {
}
