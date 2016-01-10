package com.personal.diecastfun.domain.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.personal.diecastfun.domain.View;

public interface ViewsRepository extends CrudRepository<View, String> {
	public List<View> findAllByOrderByNumberDesc();
}