package com.personal.diecastfun.utils;

public final class PicturesHelper {
	private static final String EXTENSION = ".png";

	public static final String getPictureName(String name) {
		return name.toLowerCase().replace(".", "").replace("-", "").replace(" ", "") + EXTENSION;
	}
}
