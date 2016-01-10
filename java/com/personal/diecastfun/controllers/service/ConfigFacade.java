package com.personal.diecastfun.controllers.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.base.Strings;
import com.personal.diecastfun.domain.repositories.ConfigRepository;

public class ConfigFacade {

	private static final String CONFIG_PICTURES_URL = "S3BucketUrl";

	private String picturesUrl;

	@Autowired
	private ConfigRepository configRepository;

	public String getPicturesUrl() {
		if (Strings.isNullOrEmpty(picturesUrl)) {
			picturesUrl = configRepository.findOne(CONFIG_PICTURES_URL).getValue();
		}

		return picturesUrl;
	}
}
