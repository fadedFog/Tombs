package ru.fadedfog.tombs;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import ru.fadedfog.tombs.repository.StatisticsRepository;

public class SpringDataTest {

	private StatisticsRepository statisticsRepository;
	
	@Test
	@Transactional
	public void testCreateInitLineStatistics() {
		statisticsRepository.createInitLineStatistic();
	}
	
}
