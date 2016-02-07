package com.personal.diecastfun.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.google.common.base.Strings;

public class Car {

	public static final String INSERTION_DATE_FORMAT = "dd/MM/yyyy";

	private int id = 0;
	private String model;
	private String brand;
	private String maker;
	private String scale = "1:64";
	private String color;
	private String insertionDate = "01/01/2012";
	private Era era = Era.Unknown;
	private int restaured = 0;
	private int customized = 0;
	private List<Tags> tags = new ArrayList<Tags>();

	public Era getEra() {
		if (era == null) {
			era = Era.Unknown;
		}

		return era;
	}

	public void setEra(Era era) {
		this.era = era;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isRestaured() {
		return restaured == 1;
	}

	public boolean isCustomized() {
		return customized == 1;
	}

	public int getRestaured() {
		return restaured;
	}

	public void setRestaured(int isRestaured) {
		this.restaured = isRestaured;
	}

	public int getCustomized() {
		return customized;
	}

	public void setCustomized(int isCustomized) {
		this.customized = isCustomized;
	}

	public String getInsertionDate() {
		return insertionDate;
	}

	public void setInsertionDate(String insertionDate) {
		this.insertionDate = insertionDate;
	}

	public List<Tags> getTags() {
		return tags;
	}

	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}

	public Car withBrand(String brand) {
		setBrand(brand);
		return this;
	}

	public Car withColor(String color) {
		setColor(color);
		return this;
	}

	public Car withCustomized(int customized) {
		setCustomized(customized);
		return this;
	}

	public Car withEra(Era era) {
		setEra(era);
		return this;
	}

	public Car withId(int id) {
		setId(id);
		return this;
	}

	public Car withInsertionDate(String insertionDate) {
		setInsertionDate(insertionDate);
		return this;
	}

	public Car withMaker(String maker) {
		setMaker(maker);
		return this;
	}

	public Car withModel(String model) {
		setModel(model);
		return this;
	}

	public Car withRestaured(int restaured) {
		setRestaured(restaured);
		return this;
	}

	public Car withScale(String scale) {
		setScale(scale);
		return this;
	}

	public Car withTags(List<Tags> tags) {
		setTags(tags);
		return this;
	}

	public boolean isNew() {
		Calendar limitDate = Calendar.getInstance();
		limitDate.add(Calendar.DAY_OF_WEEK, -15);

		return getInsertionDateAsCalendar().after(limitDate);
	}

	public boolean containsWord(String word) {
		word = word.toLowerCase();

		boolean result = getCompleteName().toLowerCase().contains(word);
		if (!result) {
			result = maker.toLowerCase().contains(word);
		}

		if (!result && !Strings.isNullOrEmpty(color)) {
			result = color.toLowerCase().contains(word);
		}

		return result;
	}

	public Calendar getInsertionDateAsCalendar() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat(INSERTION_DATE_FORMAT);
		try {
			calendar.setTime(dateFormat.parse(getInsertionDate()));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return calendar;
	}

	public String getCompleteId() {
		String basicId = getBrand().toLowerCase() + getModel().toLowerCase();
		String completeId = id == 0 ? basicId : basicId + id;
		return trimId(completeId);
	}

	public String getCompleteName() {
		return brand + " " + model;
	}

	private String trimId(String id) {
		return id.replace(" ", "").replace(".", "").replace("/", "");
	}
}
