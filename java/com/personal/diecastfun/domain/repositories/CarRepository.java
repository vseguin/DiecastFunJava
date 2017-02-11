package com.personal.diecastfun.domain.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.personal.diecastfun.domain.Car;
import com.personal.diecastfun.domain.Era;
import com.personal.diecastfun.domain.Tags;

public interface CarRepository extends PagingAndSortingRepository<Car, String>
{
    public int countByBrand(String brand);

    public int countByColor(String color);

    public int countByEra(Era era);

    public int countByMaker(String maker);

    public int countByTags(Tags tags);

    public List<Car> findByBrand(String brand);

    public List<Car> findByCustomized(Boolean customized);

    public List<Car> findByEra(Era era);

    public List<Car> findByMaker(String maker);

    public List<Car> findByRestored(Boolean restored);

    public List<Car> findByTags(Tags tags);

    Page<Car> findByTagsIn(Tags tags, Pageable pageable);

    Page<Car> findByModelContainingIgnoreCaseOrBrandContainingIgnoreCaseOrMakerContainingIgnoreCaseOrColorContainingIgnoreCase(String model,
                                                                                                                               String brand,
                                                                                                                               String maker,
                                                                                                                               String color,
                                                                                                                               Pageable pageable);
}
