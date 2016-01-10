package com.personal.diecastfun.conditions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.personal.diecastfun.domain.Car;

public class ConditionResolver {

  private Collection<Car> cars;
  private List<ConditionSet> conditionSets;

  public ConditionResolver(Collection<Car> cars) {
    this.cars = cars;

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

  public Collection<Car> resolveConditions() {
    Collection<Car> results = new ArrayList<Car>();

    for (Car car : cars) {
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
