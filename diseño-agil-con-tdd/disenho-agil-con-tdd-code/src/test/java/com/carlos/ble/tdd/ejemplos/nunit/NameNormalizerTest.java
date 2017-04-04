package com.carlos.ble.tdd.ejemplos.nunit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class NameNormalizerTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	private NameNormalizer normalizer;

	@Before
	public void setUp() {
		this.normalizer = new NameNormalizer();
	}

	@Test
	public void firstLetterUpperCase() {
		// Arrange
		// Act
		String result = this.normalizer.firstLetterUpperCase("pablo rodriguez");
		// Assert
		assertEquals("Pablo Rodriguez", result);
	}

	@Test
	public void surnameFirst() {
		// Arrange
		// Act
		String result = this.normalizer.surnameFirst("gonzalo aller");
		// Assert
		assertEquals("aller, gonzalo", result);
	}

	@Test
	public void throwOnEmptyName() {
		// Arrange
		this.thrown.expect(NullPointerException.class);
		this.thrown.expectMessage(containsString("The name can not be empty"));
		// Act
		this.normalizer.surnameFirst("");
		// Assert
		fail();
	}
}
