package ru.fadedfog.tombs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.fadedfog.tombs.model.Statistics;

@Repository
public interface StatisticsRepository extends CrudRepository<Statistics, Long>, CustomizedStatistics<Statistics> {
	
	public void createInitLineStatistic();
	
	public void updateStatistics(int updateNumberSteps);
	
}
