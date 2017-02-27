package com.personal.diecastfun.domain.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.personal.diecastfun.domain.Car;
import com.personal.diecastfun.domain.Era;
import com.personal.diecastfun.domain.Tags;

public interface CarRepository extends PagingAndSortingRepository<Car, String>
{
    int countByBrand(String brand);

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

    @Query("SELECT COUNT(*), brand FROM Car GROUP BY brand ORDER BY COUNT(*) DESC")
    List<Object[]> findBrandsCount();

    @Query("SELECT COUNT(*), color FROM Car GROUP BY color ORDER BY COUNT(*) DESC")
    List<Object[]> findColorsCount();

    @Query("SELECT COUNT(*), b.country FROM Car c, Brand b WHERE c.brand = b.name GROUP by b.country ORDER BY COUNT(*) DESC")
    List<Object[]> findCountriesCount();

    @Query("SELECT COUNT(*), era FROM Car GROUP BY era ORDER BY COUNT(*) DESC")
    List<Object[]> findErasCount();

    @Query("SELECT COUNT(*), maker FROM Car GROUP BY maker ORDER BY COUNT(*) DESC")
    List<Object[]> findMakersCount();

    @Query("SELECT COUNT(*), t FROM Car c INNER JOIN c.tags t GROUP BY t ORDER BY COUNT(*) DESC")
    List<Object[]> findTagsCount();

    @Query("SELECT c.brand, c.model, v.number FROM Car c, Vote v WHERE v.id=c.id ORDER BY v.number DESC")
    List<Object[]> findVotesCount();
}
