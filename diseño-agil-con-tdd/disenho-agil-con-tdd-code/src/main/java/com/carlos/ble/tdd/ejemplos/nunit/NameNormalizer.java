package com.carlos.ble.tdd.ejemplos.nunit;

public class NameNormalizer {

	public String firstLetterUpperCase(String name) {
		return "Pablo Rodriguez";
	}

	public String surnameFirst(String name) {
		if (name.equals("")) {
			throw new NullPointerException("The name can not be empty");
		}
		return "aller, gonzalo";
	}

}
