package ru.fadedfog.tombs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextKeeper {
	private static ApplicationContext context;
	
	public static ApplicationContext getContext() {
		if (context == null) {
			context = new ClassPathXmlApplicationContext("applicationContext.xml");
		}
		return context;
	}
	
}
