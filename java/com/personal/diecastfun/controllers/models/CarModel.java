package com.personal.diecastfun.controllers.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.personal.diecastfun.domain.Car;
import com.personal.diecastfun.domain.Era;
import com.personal.diecastfun.domain.Tags;
import com.personal.diecastfun.utils.ColorTranslator;

public class CarModel implements Comparable<CarModel>, Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;
    private String brand;
    private String model;
    private String maker;
    private String scale;
    private Era era;
    private String color;
    private String colorName;
    private boolean restored;
    private boolean customized;
    private boolean isNew;
    private String thumbnail;
    private List<String> pictures = new ArrayList<String>();
    private List<Tags> tags = new ArrayList<Tags>();

    public CarModel()
    {
    }

    public CarModel(Car car)
    {
        this.id = car.getId();
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.maker = car.getMaker();
        this.scale = car.getScale();
        this.setEra(car.getEra());
        this.colorName = car.getColor();
        this.color = ColorTranslator.translateColor(colorName);
        this.restored = car.getRestored();
        this.customized = car.getCustomized();
        this.tags = car.getTags();
        pictures.add(id + "-1.jpg");
        pictures.add(id + "-2.jpg");
        pictures.add(id + "-3.jpg");
        this.thumbnail = pictures.get(0);
        this.isNew = car.isNew();

        setPictures(getPictures().stream().map(p -> p.replace("'", "%27")).collect(Collectors.toList()));
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public List<String> getPictures()
    {
        return pictures;
    }

    public void setPictures(List<String> pictures)
    {
        this.pictures = pictures;
    }

    public String getMaker()
    {
        return maker;
    }

    public void setMaker(String maker)
    {
        this.maker = maker;
    }

    public String getScale()
    {
        return scale;
    }

    public void setScale(String scale)
    {
        this.scale = scale;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public boolean isRestored()
    {
        return restored;
    }

    public void setRestored(boolean restored)
    {
        this.restored = restored;
    }

    public boolean isCustomized()
    {
        return customized;
    }

    public void setCustomized(boolean customized)
    {
        this.customized = customized;
    }

    public String getColorName()
    {
        return colorName;
    }

    public void setColorName(String colorName)
    {
        this.colorName = colorName;
    }

    public boolean getIsNew()
    {
        return isNew;
    }

    public void setIsNew(boolean isNew)
    {
        this.isNew = isNew;
    }

    public List<Tags> getTags()
    {
        return tags;
    }

    public void setTags(List<Tags> tags)
    {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof CarModel) {
            CarModel model = (CarModel) obj;
            return model.getId().equals(getId());
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(CarModel car)
    {
        return getId().compareTo(car.getId());
    }

    public Era getEra()
    {
        return era;
    }

    public void setEra(Era era)
    {
        this.era = era;
    }

    public String getThumbnail()
    {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail)
    {
        this.thumbnail = thumbnail;
    }
}
