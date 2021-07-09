package ru.fadedfog.tombs.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import ru.fadedfog.tombs.repository.StatisticsRepository;

@Service
@Component
public class ServiceStatisticsCollector {
	@Autowired
	private StatisticsRepository statisticsRepository;
	private int numberSteps;

	public void saveNumberSteps() {
		statisticsRepository.updateStatistics(numberSteps);
	}
	
	public int getNumberSteps() {
		return numberSteps;
	}

	public void setNumberSteps(int numberSteps) {
		this.numberSteps = numberSteps;
	}
	
}
