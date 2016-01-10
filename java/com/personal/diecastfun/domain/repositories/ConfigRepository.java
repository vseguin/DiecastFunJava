package com.personal.diecastfun.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.personal.diecastfun.domain.ConfigEntity;

public interface ConfigRepository extends CrudRepository<ConfigEntity, String> {
}
