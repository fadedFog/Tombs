package ru.fadedfog.tombs.repository;

import org.springframework.data.repository.CrudRepository;

import ru.fadedfog.tombs.model.Statistics;

public interface StatisticsRepository extends CrudRepository<Statistics, Long>  {

//		void save();
	
//	void updateById(long id, int stepsUser);

	Statistics findById(long id);
	
}
