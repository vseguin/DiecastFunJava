package com.personal.diecastfun.controllers.models;

public class CarQueryResultModel
{
    private SortedList<CarModel> cars;
    private Integer totalCount;

    public SortedList<CarModel> getCars()
    {
        return cars;
    }

    public void setCars(SortedList<CarModel> cars)
    {
        this.cars = cars;
    }

    public Integer getTotalCount()
    {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount)
    {
        this.totalCount = totalCount;
    }

    public CarQueryResultModel withCars(SortedList<CarModel> cars)
    {
        setCars(cars);
        return this;
    }

    public CarQueryResultModel withTotalCount(Integer totalCount)
    {
        setTotalCount(totalCount);
        return this;
    }
}
