package com.carlos.ble.tdd.ejemplos.nunit;

import org.junit.Before;
import org.junit.Test;

public class ScoreManagerTest {

	private ScoreManager scoreManager;
	private IDataManager dataManager;

	@Before
	public void setUp() {
		this.scoreManager = new ScoreManager(this.dataManager);
	}

	@Test
	public void addStudentScore() {
		//Act
		this.scoreManager.addScore("23145",8.5);
		//Assert
	}
}
