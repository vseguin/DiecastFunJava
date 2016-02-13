package com.personal.diecastfun.utils;

public class JsonIdWrapper {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public JsonIdWrapper withId(String id) {
		setId(id);
		return this;
	}
}
