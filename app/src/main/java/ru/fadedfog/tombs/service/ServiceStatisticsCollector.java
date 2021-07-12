package ru.fadedfog.tombs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@Component 
public class ServiceStatisticsCollector {
	private int numberSteps;

	public void saveNumberSteps() {
	}
	
	public int getNumberSteps() {
		return numberSteps;
	}

	public void setNumberSteps(int numberSteps) {
		this.numberSteps = numberSteps;
	}
	
}
