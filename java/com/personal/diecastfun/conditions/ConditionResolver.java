package com.personal.diecastfun.conditions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import com.personal.diecastfun.controllers.models.CarModel;
import com.personal.diecastfun.controllers.service.CarFacade;

@Component
@DependsOn("carFacade")
public class ConditionResolver {

	@Autowired
	private CarFacade carFacade;

	private List<ConditionSet> conditionSets;

	public ConditionResolver() {
		initialize();
	}

	public void addCondition(ICondition condition) {
		for (ConditionSet set : conditionSets) {
			if (set.getType().equals(condition.getClass())) {
				set.addCondition(condition);
				break;
			}
		}
	}

	public void removeConditionCorrespondingTo(String value) {
		for (ConditionSet set : conditionSets) {
			if (set.tryRemoveConditionCorrespondingTo(value)) {
				break;
			}
		}
	}

	public void removeConditionsCorrespondingTo(Class classValue) {
		ConditionSet setToRemove = null;
		for (ConditionSet set : conditionSets) {
			if (set.getType().equals(classValue)) {
				setToRemove = set;
				break;
			}
		}

		if (setToRemove != null) {
			conditionSets.remove(setToRemove);
			conditionSets.add(new ConditionSet<ICondition>(classValue));
		}
	}

	public void initialize() {
		conditionSets = new ArrayList<ConditionSet>();
		conditionSets.add(new ConditionSet<BrandCondition>(BrandCondition.class));
		conditionSets.add(new ConditionSet<CategoryCondition>(CategoryCondition.class));
		conditionSets.add(new ConditionSet<ColorCondition>(ColorCondition.class));
		conditionSets.add(new ConditionSet<EraCondition>(EraCondition.class));
		conditionSets.add(new ConditionSet<MakerCondition>(MakerCondition.class));
		conditionSets.add(new ConditionSet<CountryCondition>(CountryCondition.class));
	}

	public Collection<CarModel> resolveConditions() {
		Collection<CarModel> results = new ArrayList<CarModel>();

		for (CarModel car : carFacade.findAllCars()) {
			boolean isCarValid = true;
			for (ConditionSet set : conditionSets) {
				if (set.count() > 0 && !set.isValid(car)) {
					isCarValid = false;
					break;
				}
			}

			if (isCarValid) {
				results.add(car);
			}
		}

		return results;
	}

}
