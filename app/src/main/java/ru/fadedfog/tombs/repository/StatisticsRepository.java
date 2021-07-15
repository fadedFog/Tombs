package ru.fadedfog.tombs.repository;

import org.springframework.data.repository.CrudRepository;

import ru.fadedfog.tombs.model.Statistics;

public interface StatisticsRepository extends CrudRepository<Statistics, Long>  {

	Statistics findById(long id);
	
}
