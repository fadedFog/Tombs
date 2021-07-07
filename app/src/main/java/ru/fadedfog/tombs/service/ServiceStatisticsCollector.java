package ru.fadedfog.tombs.service;


import org.springframework.stereotype.Component;

import ru.fadedfog.tombs.model.CallerQueriesDB;

@Component
public class ServiceStatisticsCollector {
	private CallerQueriesDB callerQueriesDB;
	private int numberSteps;

	public ServiceStatisticsCollector() {
		callerQueriesDB = new CallerQueriesDB();
	}
	
	public void saveNumberSteps() {
		callerQueriesDB.saveNumberSteps(getNumberSteps());
	}
	
	public int getNumberSteps() {
		return numberSteps;
	}

	public void setNumberSteps(int numberSteps) {
		this.numberSteps = numberSteps;
	}
	
}
