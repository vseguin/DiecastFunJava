package com.personal.diecastfun.controllers.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SortedList<T extends Comparable> implements Iterable<T> {

	private List<T> collection = new ArrayList<T>();

	public SortedList(List<T> collection) {
		Collections.sort(collection);
		this.collection = collection;
	}

	public List<T> getCollection() {
		return collection;
	}

	public void setCollection(List<T> collection) {
		this.collection = collection;
	}

	public int size() {
		return collection.size();
	}

	public Iterator<T> iterator() {
		return collection.iterator();
	}
}
