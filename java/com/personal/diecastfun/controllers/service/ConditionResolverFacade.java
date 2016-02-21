package com.personal.diecastfun.controllers.service;

import java.util.List;

import com.google.common.collect.Lists;
import com.personal.diecastfun.conditions.ConditionResolver;
import com.personal.diecastfun.conditions.ICondition;
import com.personal.diecastfun.controllers.models.CarModel;

public class ConditionResolverFacade {

	private ConditionResolver conditionResolver;

	public ConditionResolverFacade(ConditionResolver conditionResolver) {
		this.conditionResolver = conditionResolver;
	}

	public void addCondition(ICondition condition) {
		conditionResolver.addCondition(condition);
	}

	public void removeCondition(String value) {
		conditionResolver.removeConditionCorrespondingTo(value);
	}

	public void removeConditions(Class classToRemove) {
		conditionResolver.removeConditionsCorrespondingTo(classToRemove);
	}

	public void clearAll() {
		conditionResolver.initialize();
	}

	public List<CarModel> resolveConditions() {
		return Lists.newArrayList(conditionResolver.resolveConditions());
	}
}
