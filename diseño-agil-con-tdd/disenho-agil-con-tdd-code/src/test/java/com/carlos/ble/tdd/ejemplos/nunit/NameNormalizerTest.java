package com.carlos.ble.tdd.ejemplos.nunit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NameNormalizerTest {
	@Test
	public void FirstLetterUpperCase() {
		// Arrange 13
		String name = "pablo rodriguez";
		NameNormalizer normalizer = new NameNormalizer();
		// Act 17 S
		String result = normalizer.FirstLetterUpperCase(name);
		// Assert 21
		assertEquals("Pablo Rodriguez", result);
	}
}
