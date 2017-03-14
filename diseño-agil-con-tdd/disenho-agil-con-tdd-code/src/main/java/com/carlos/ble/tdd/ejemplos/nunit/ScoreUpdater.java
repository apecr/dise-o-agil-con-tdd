package com.carlos.ble.tdd.ejemplos.nunit;

public class ScoreUpdater {

	public Student updateScore(Student student, float score) {
		student.setScore(score + student.getScore());
		return student;
	}

}
