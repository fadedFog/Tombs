package ru.fadedfog.tombs.game;


import org.springframework.beans.factory.annotation.Autowired;

import ru.fadedfog.tombs.service.ServiceStatisticsCollector;

public class ProcessorHook extends Thread {
	@Autowired
	private ServiceStatisticsCollector service;
	
	public ProcessorHook(ServiceStatisticsCollector service) {
		this.service = service;
	}

	@Override
	public void run() {
		service.saveNumberSteps();
	}
	
}
