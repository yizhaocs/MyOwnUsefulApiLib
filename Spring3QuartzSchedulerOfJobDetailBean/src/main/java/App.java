package main.java;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/* Reference: http://www.mkyong.com/spring/spring-quartz-scheduler-example/*/
public class App {
	public static void main(String[] args) throws Exception {
		new ClassPathXmlApplicationContext("Spring-Quartz.xml");

	}
}