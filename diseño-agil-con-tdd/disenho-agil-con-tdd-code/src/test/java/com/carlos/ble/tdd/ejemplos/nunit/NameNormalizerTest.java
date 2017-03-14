package com.carlos.ble.tdd.ejemplos.nunit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class NameNormalizerTest {
	
	private NameNormalizer normalizer;

	@Before
	public void setUp(){
		this.normalizer = new NameNormalizer();
	}
	
	@Test
	public void firstLetterUpperCase() {
		// Arrange
		String name = "pablo rodriguez";
		// Act
		String result = this.normalizer.firstLetterUpperCase(name);
		// Assert
		assertEquals("Pablo Rodriguez", result);
	}
	
	@Test
	public void surnameFirst() {
		// Arrange
		String name = "gonzalo aller";
		// Act
		String result = this.normalizer.surnameFirst(name);
		// Assert
		assertEquals("aller, gonzalo", result);
	}
}
