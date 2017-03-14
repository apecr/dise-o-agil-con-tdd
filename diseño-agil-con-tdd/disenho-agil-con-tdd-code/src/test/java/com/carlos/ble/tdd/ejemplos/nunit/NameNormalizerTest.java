package com.carlos.ble.tdd.ejemplos.nunit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NameNormalizerTest {
	@Test
	public void FirstLetterUpperCase() {
		// Arrange
		String name = "pablo rodriguez";
		NameNormalizer normalizer = new NameNormalizer();
		// Act
		String result = normalizer.FirstLetterUpperCase(name);
		// Assert
		assertEquals("Pablo Rodriguez", result);
	}
}
