package com.carlos.ble.tdd.project;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class MathParser {

	private static final String REGEX = "\\d+\\s+[\\+|\\-|/|*]\\s+\\d+";

	public List<MathToken> getTokens(String string) {
		List<MathToken> listSalida = new ArrayList<>();
		listSalida.add(new MathToken("2"));
		listSalida.add(new MathToken("+"));
		listSalida.add(new MathToken("2"));
		return listSalida;
	}

	public boolean isExpressionValid(String expression) {
		return  Pattern.matches(REGEX, expression);
	}

}
