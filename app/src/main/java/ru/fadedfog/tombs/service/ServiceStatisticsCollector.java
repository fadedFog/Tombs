package ru.fadedfog.tombs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.fadedfog.tombs.model.Statistics;
import ru.fadedfog.tombs.repository.StatisticsRepository;


@Service
public class ServiceStatisticsCollector {
	@Autowired
	private StatisticsRepository dao;
	private int numberSteps;

	public Statistics saveNumberSteps() {
		Statistics newStatistic = new Statistics(getNumberSteps());
		
		List<Statistics> statisticsDB = (List<Statistics>) dao.findAll(); 
		
		if (statisticsDB.isEmpty()) {
			return dao.save(newStatistic);
		} else {
			Statistics statistics =  statisticsDB.get(0);
			Long id = statistics.getId();
			Optional<Statistics> optionalStatistic = dao.findById(id);			
			optionalStatistic.get().setNumberStepsUser(newStatistic.getNumberStepsUser());
			return dao.save(optionalStatistic.get());
      }
	}
	
	public int getNumberSteps() {
		return numberSteps;
	}

	public void setNumberSteps(int numberSteps) {
		this.numberSteps = numberSteps;
	}
	
}
