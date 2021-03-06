package com.personal.diecastfun.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "QueuedCars")
public class QueuedCar {

	@Id
	private String id;

	private int count = 0;
	private String model;
	private String brand;
	private String maker;
	private String scale = "1:64";
	private String color;
	private Date insertionDate;

	@Enumerated(EnumType.STRING)
	private Era era = Era.Unknown;
	private Boolean restored = false;
	private Boolean customized = false;

	@ElementCollection(targetClass = Tags.class, fetch = FetchType.EAGER)
	@CollectionTable(name = "QueuedTags", joinColumns = @JoinColumn(name = "id") )
	@Column(name = "tags", nullable = false)
	@Enumerated(EnumType.STRING)
	private List<Tags> tags = new ArrayList<Tags>();

	public Era getEra() {
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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

	public Date getInsertionDate() {
		return insertionDate;
	}

	public void setInsertionDate(Date insertionDate) {
		this.insertionDate = insertionDate;
	}

	public List<Tags> getTags() {
		return tags;
	}

	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}

	public QueuedCar withBrand(String brand) {
		setBrand(brand);
		return this;
	}

	public QueuedCar withColor(String color) {
		setColor(color);
		return this;
	}

	public QueuedCar withCustomized(Boolean customized) {
		setCustomized(customized);
		return this;
	}

	public QueuedCar withEra(Era era) {
		setEra(era);
		return this;
	}

	public QueuedCar withCount(int count) {
		setCount(count);
		return this;
	}

	public QueuedCar withInsertionDate(Date insertionDate) {
		setInsertionDate(insertionDate);
		return this;
	}

	public QueuedCar withMaker(String maker) {
		setMaker(maker);
		return this;
	}

	public QueuedCar withModel(String model) {
		setModel(model);
		return this;
	}

	public QueuedCar withRestored(Boolean restaured) {
		setRestored(restaured);
		return this;
	}

	public QueuedCar withScale(String scale) {
		setScale(scale);
		return this;
	}

	public QueuedCar withTags(List<Tags> tags) {
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

		return getCompleteName().toLowerCase().contains(word) || maker.toLowerCase().contains(word)
				|| color.toLowerCase().contains(word);
	}

	public Calendar getInsertionDateAsCalendar() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getInsertionDate());

		return calendar;
	}

	public String getCompleteName() {
		return brand + " " + model;
	}

	public Boolean getRestored() {
		return restored;
	}

	public void setRestored(Boolean restored) {
		this.restored = restored;
	}

	public Boolean getCustomized() {
		return customized;
	}

	public void setCustomized(Boolean customized) {
		this.customized = customized;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public QueuedCar withId(String id) {
		setId(id);
		return this;
	}

	public String generateId() {
		String basicId = getBrand().toLowerCase() + getModel().toLowerCase();
		String completeId = count == 0 ? basicId : basicId + count;
		return trimId(completeId);
	}

	private String trimId(String id) {
		return id.replace(" ", "").replace(".", "").replace("/", "");
	}
}
