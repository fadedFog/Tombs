package ru.fadedfog.tombs.service;


import org.springframework.stereotype.Component;

@Component
public class ServiceStatisticsCollector {
	private int numberSteps;

	public int getNumberSteps() {
		return numberSteps;
	}

	public void setNumberSteps(int numberSteps) {
		this.numberSteps = numberSteps;
	}
	
}
