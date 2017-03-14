package com.carlos.ble.tdd.ejemplos.nunit;

public class Orchestrator {
	
	private IServices services;

	public Orchestrator(IServices services) {
		this.services = services;
	} 
	
	public void orchestrate(){
		this.services.methodA();
		this.services.methodB();
	}

}
