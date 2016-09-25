package com.personal.diecastfun.domain;

public enum Tags {
	Military, MuscleCar, Offroad, Cabriolet, Exotic, Sports, GranTurismo, Coupe, Police, SUV, Wagon, FiveDoorsHatchback, ThreeDoorsHatchback, Van, LargeSedan, Racing, PickUp, MediumSedan, Minivan, Luxury, SmallSedan, Fire, Boat, Ambulance, Bus, Others;

	private final String displayName;

	private Tags(final String displayName) {
		this.displayName = displayName;
	}

	private Tags() {
		this.displayName = this.name().replaceAll("(\\p{Ll})(\\p{Lu})", "$1 $2");
	}

	public String getDisplayName() {
		return this.displayName;
	}
}
