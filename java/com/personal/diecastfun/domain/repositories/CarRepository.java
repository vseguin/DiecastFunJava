package com.personal.diecastfun.domain.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.personal.diecastfun.domain.Car;
import com.personal.diecastfun.domain.Era;
import com.personal.diecastfun.domain.Tags;

public interface CarRepository extends PagingAndSortingRepository<Car, String>
{
    int countByBrand(String brand);

    int countByColor(String color);

    int countByEra(Era era);

    int countByMaker(String maker);

    int countByTags(Tags tags);

    List<Car> findByInsertionDateAfter(Date date);

    List<Car> findByBrand(String brand);

    List<Car> findByCustomized(Boolean customized);

    List<Car> findByEra(Era era);

    List<Car> findByMaker(String maker);

    List<Car> findByRestored(Boolean restored);

    List<Car> findByTags(Tags tags);

    Page<Car> findByTagsIn(Tags tags, Pageable pageable);

    Page<Car> findByModelContainingIgnoreCaseOrBrandContainingIgnoreCaseOrMakerContainingIgnoreCaseOrColorContainingIgnoreCase(String model,
                                                                                                                               String brand,
                                                                                                                               String maker,
                                                                                                                               String color,
                                                                                                                               Pageable pageable);

}
