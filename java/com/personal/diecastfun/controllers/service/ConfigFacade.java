package com.personal.diecastfun.controllers.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.base.Strings;
import com.personal.diecastfun.domain.repositories.ConfigRepository;

public class ConfigFacade
{
    private static final String CONFIG_BUCKET_NAME = "S3BucketName";
    private static final String CONFIG_PICTURES_URL = "S3BucketUrl";
    private static final String CONFIG_RESOURCES_URL = "resourcesUrl";

    private String picturesUrl;
    private String resourcesUrl;

    @Autowired
    private ConfigRepository configRepository;

    public String getBucketName()
    {
        return configRepository.findOne(CONFIG_BUCKET_NAME).getValue();
    }

    public String getPicturesUrl()
    {
        if (Strings.isNullOrEmpty(picturesUrl)) {
            picturesUrl = configRepository.findOne(CONFIG_PICTURES_URL).getValue();
        }

        return picturesUrl;
    }

    public String getResourcesUrl()
    {
        if (Strings.isNullOrEmpty(resourcesUrl)) {
            resourcesUrl = configRepository.findOne(CONFIG_RESOURCES_URL).getValue();
        }

        return resourcesUrl;
    }
}
