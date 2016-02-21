package com.personal.diecastfun.conditions;

import java.util.ArrayList;
import java.util.List;

import com.personal.diecastfun.controllers.models.CarModel;

public class ConditionSet<T extends ICondition> {

	private List<T> conditions = new ArrayList<T>();
	private Class<T> type;

	public ConditionSet(Class<T> type) {
		this.type = type;
	}

	public void addCondition(T condition) {
		conditions.add(condition);
	}

	public boolean tryRemoveConditionCorrespondingTo(String value) {
		T conditionToRemove = null;

		for (T condition : conditions) {
			if (condition.getValue().equals(value)) {
				conditionToRemove = condition;
				break;
			}
		}

		if (conditionToRemove != null) {
			conditions.remove(conditionToRemove);
		}

		return conditionToRemove != null;
	}

	public boolean isValid(CarModel car) {
		boolean isSetValid = false;
		for (T condition : conditions) {
			if (condition.isValid(car)) {
				isSetValid = true;
				break;
			}
		}

		return isSetValid;
	}

	public Class<T> getType() {
		return type;
	}

	public int count() {
		return conditions.size();
	}

}
