package com.personal.diecastfun.controllers.models;

import com.personal.diecastfun.domain.Era;

public class CarQueryModel
{
    private Integer page;
    private Integer perPage;

    private String brand;
    private String category;
    private Era era;
    private String maker;

    public Integer getPage()
    {
        return page;
    }

    public void setPage(Integer page)
    {
        this.page = page;
    }

    public Integer getPerPage()
    {
        return perPage;
    }

    public void setPerPage(Integer perPage)
    {
        this.perPage = perPage;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public CarQueryModel withPerPage(Integer perPage)
    {
        setPerPage(perPage);
        return this;
    }

    public CarQueryModel withPage(Integer page)
    {
        setPage(page);
        return this;
    }

    public CarQueryModel withBrand(String brand)
    {
        setBrand(brand);
        return this;
    }

    public Era getEra()
    {
        return era;
    }

    public void setEra(Era era)
    {
        this.era = era;
    }

    public CarQueryModel withEra(Era era)
    {
        setEra(era);
        return this;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public CarQueryModel withCategory(String category)
    {
        setCategory(category);
        return this;
    }

    public String getMaker()
    {
        return maker;
    }

    public void setMaker(String maker)
    {
        this.maker = maker;
    }

    public CarQueryModel withMaker(String maker)
    {
        setMaker(maker);
        return this;
    }
}
