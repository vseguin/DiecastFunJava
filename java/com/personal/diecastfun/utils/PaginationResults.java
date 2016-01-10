package com.personal.diecastfun.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.personal.diecastfun.controllers.models.CarModel;

public class PaginationResults {

	private Collection<CarModel> paginationResults;
	private boolean hasNext;
	private boolean hasPrevious;
	private int currentPage;
	private List<String> completeResults = new ArrayList<String>();

	public PaginationResults(Collection<CarModel> paginationResults,
			boolean hasNext, boolean hasPrevious, int currentPage) {
		this.paginationResults = paginationResults;
		this.hasNext = hasNext;
		this.hasPrevious = hasPrevious;
		this.currentPage = currentPage;
		for (CarModel car : PaginatorCache.cachedCollection) {
			this.completeResults.add(car.getId());
		}
	}

	public Collection<CarModel> getPaginationResults() {
		return paginationResults;
	}

	public void setPaginationResults(Collection<CarModel> paginationResults) {
		this.paginationResults = paginationResults;
	}

	public boolean hasNext() {
		return hasNext;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	public boolean hasPrevious() {
		return hasPrevious;
	}

	public void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<String> getCompleteResults() {
		return completeResults;
	}

	public void setCompleteResults(List<String> completeResults) {
		this.completeResults = completeResults;
	}
}
