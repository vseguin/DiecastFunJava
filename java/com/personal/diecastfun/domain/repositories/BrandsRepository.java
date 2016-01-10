package com.personal.diecastfun.domain.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.personal.diecastfun.domain.Brand;
import com.personal.diecastfun.domain.Country;

public interface BrandsRepository extends CrudRepository<Brand, String> {

	public List<Brand> findByCountry(Country country);
}
