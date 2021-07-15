package ru.fadedfog.tombs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import ru.fadedfog.tombs.model.Statistics;
import ru.fadedfog.tombs.repository.StatisticsRepository;


@Service
@Component 
public class ServiceStatisticsCollector {
	@Autowired
	private StatisticsRepository dao;
	private int numberSteps;

	public void saveNumberSteps() {
		System.out.println("dao " + (dao == null));
		
		Statistics newStatistic = new Statistics(getNumberSteps());
		long id = newStatistic.getId();
		System.out.println(Optional.of(dao.findById(id)) == null);
//		Optional<Statistics> optionalStatistic = Optional.of(dao.findById(id));
		dao.save(newStatistic);
//		if (optionalStatistic.isEmpty()) {
//			Statistics addStatistic = dao.save(newStatistic);
//		} else {
//			optionalStatistic.get().setNumberStepsUser(newStatistic.getNumberStepsUser());
//			Statistics updateStatistic = dao.save(optionalStatistic.get());
//      }
	}
	
	public int getNumberSteps() {
		return numberSteps;
	}

	public void setNumberSteps(int numberSteps) {
		this.numberSteps = numberSteps;
	}
	
}
