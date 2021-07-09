package ru.fadedfog.tombs.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CustomizedStatisticsImpl implements CustomizedStatistics {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void createInitLineStatistics() {
		entityManager.createQuery("INSERT INTO steps(id, number_steps) "
				+ "VALUE (1, 0);");
	}

	@Override
	public void updateStatistics(int updateNumberSteps) {
		String query = "UPDATE steps "
				+ "SET number_steps = %s "
				+ "	WHERE id = 1;";
		entityManager.createQuery(String.format(query, updateNumberSteps));
	}
	
}
