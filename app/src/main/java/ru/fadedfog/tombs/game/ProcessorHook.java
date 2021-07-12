package ru.fadedfog.tombs.game;


import ru.fadedfog.tombs.service.ServiceStatisticsCollector;

public class ProcessorHook extends Thread {
	private ServiceStatisticsCollector service;
	
	public ProcessorHook(ServiceStatisticsCollector service) {
		this.service = service;
	}

	@Override
	public void run() {
		System.out.println(service == null);
		service.saveNumberSteps();
	}
	
}
