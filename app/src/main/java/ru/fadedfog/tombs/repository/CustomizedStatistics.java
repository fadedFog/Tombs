package ru.fadedfog.tombs.repository;

public interface CustomizedStatistics<T> {

	void createInitLineStatistics();
	
	void updateStatistics(int updateNumberSteps);
	
}
