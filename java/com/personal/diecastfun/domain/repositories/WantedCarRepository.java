package com.personal.diecastfun.domain.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.personal.diecastfun.domain.WantedCar;

public interface WantedCarRepository extends CrudRepository<WantedCar, String> {
	List<WantedCar> findAllByOrderByMakerAsc();
}
