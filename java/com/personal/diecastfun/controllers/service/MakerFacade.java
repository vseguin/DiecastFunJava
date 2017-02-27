package com.personal.diecastfun.controllers.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.personal.diecastfun.controllers.models.MakerModel;
import com.personal.diecastfun.domain.Maker;
import com.personal.diecastfun.domain.repositories.CarRepository;
import com.personal.diecastfun.domain.repositories.MakersRepository;
import com.personal.diecastfun.utils.PicturesHelper;

public class MakerFacade
{
    @Autowired
    private MakersRepository makerRepository;

    @Autowired
    private CarRepository carRepository;

    public void addMaker(String maker)
    {
        makerRepository.save(new Maker().withName(maker));
    }

    public List<MakerModel> findAllMakers()
    {
        return getModels(Lists.newArrayList(makerRepository.findAll()));
    }

    public long getTotalCount()
    {
        return makerRepository.count();
    }

    private List<MakerModel> getModels(List<Maker> makers)
    {
        List<MakerModel> models = new ArrayList<MakerModel>();
        for (Maker maker : makers) {
            MakerModel model = new MakerModel(maker,
                                              PicturesHelper.getPictureName(maker.getName()),
                                              carRepository.countByMaker(maker.getName()));
            models.add(model);
        }

        return models;
    }
}
