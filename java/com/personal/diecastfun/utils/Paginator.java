package com.personal.diecastfun.utils;

import java.util.List;

import com.personal.diecastfun.controllers.models.CarModel;
import com.personal.diecastfun.controllers.models.SortedList;

public class Paginator {

  private final static int DEFAULT_CAR_COUNT = 17;
  private int carCount = DEFAULT_CAR_COUNT;

  public PaginationResults paginateWithCount(int count) {
    carCount = count;

    return getResults(1, PaginatorCache.cachedCollection, count);
  }

  public PaginationResults paginate(SortedList<CarModel> collection) {
    PaginatorCache.cachedCollection = collection.getCollection();
    carCount = DEFAULT_CAR_COUNT;

    return getResults(1, PaginatorCache.cachedCollection, DEFAULT_CAR_COUNT);
  }

  public PaginationResults paginate(int pageToGo) {
    return getResults(pageToGo, PaginatorCache.cachedCollection, carCount);
  }

  public PaginationResults paginateWithCount(int count, SortedList<CarModel> collection) {
    PaginatorCache.cachedCollection = collection.getCollection();

    return getResults(1, PaginatorCache.cachedCollection, count);
  }

  private PaginationResults getResults(int pageToGo, List<CarModel> models, int carCount) {
    int firstIndex = pageToGo * carCount - carCount;
    int lastIndex = Math.min(pageToGo * carCount - 1, models.size());

    PaginationResults results = new PaginationResults(models.subList(firstIndex, lastIndex),
                                                      lastIndex < models.size() ? true : false,
                                                      pageToGo == 1 ? false : true,
                                                      pageToGo);
    return results;
  }
}
