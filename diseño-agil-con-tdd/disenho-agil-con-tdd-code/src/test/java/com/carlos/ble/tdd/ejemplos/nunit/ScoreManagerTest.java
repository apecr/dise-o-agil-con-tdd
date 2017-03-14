package com.carlos.ble.tdd.ejemplos.nunit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ScoreManagerTest {

	private ScoreManager scoreManager;
	@Mock
	private IDataManager dataManager;
	@Mock
	private IScoreUpdater scoreUpdaterMock;

	@Before
	public void setUp() {
		this.scoreManager = new ScoreManager(this.dataManager, this.scoreUpdaterMock);
	}

	@Test
	public void addStudentScore() {
		// Arrange
		float score = 8.5f;
		Student dummyStudent = new Student();
		// Act
		when(this.scoreUpdaterMock.updateScore(dummyStudent, score)).thenReturn(dummyStudent);
		this.scoreManager.addScore(dummyStudent, score);
		// Assert
		verify(this.dataManager).save(dummyStudent);
		verify(this.scoreUpdaterMock).updateScore(dummyStudent, score);
	}

	@Test
	public void scoreUpdateWorks() {
		ScoreUpdater updater = new ScoreUpdater();
		Student student = updater.updateScore(new Student(), 5f);
		//Assert
		assertEquals(5f, student.getScore(),0);
	}
}
