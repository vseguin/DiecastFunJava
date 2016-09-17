package com.personal.diecastfun.domain;

public enum Country {
	Japan("jp"), UnitedStates("us"), Italy("it"), France("fr"), Germany("de"), UnitedKingdom("uk"), Romania(
			"ro"), Spain("es"), SouthKorea("kr"), Australia("au"), Unknown("unknown"), Russia("ru"), Switzerland(
					"ch"), Sweden("se"), CzechRepublic("cz"), China("cn"), Mexico("mx"), Austria("at"), Netherlands(
							"nl");

	private final String code;

	private Country(final String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}
}
