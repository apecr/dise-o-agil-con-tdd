package com.carlos.ble.tdd.ejemplos.nunit;

public class ScoreManager {
	
	private IDataManager dataManager;
	private IScoreUpdater scoreUpdater;

	public ScoreManager(IDataManager dataManager, IScoreUpdater scoreUpdater) {
		this.dataManager = dataManager;
		this.scoreUpdater = scoreUpdater;
	}

	public void addScore(Student student, float score) {
		Student studentUpdated = this.scoreUpdater.updateScore(student, score);
		this.dataManager.save(studentUpdated);
	}

}
