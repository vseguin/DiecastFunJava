package com.personal.diecastfun.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.personal.diecastfun.domain.QueuedCar;

public interface QueuedCarsRepository extends CrudRepository<QueuedCar, String> {

}
