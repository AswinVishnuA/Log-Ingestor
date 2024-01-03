package com.ava.logmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@SpringBootApplication
public class LogmanagerApplication {

	public static void main(String[] args) {
		System.out.println("LogmanagerApplication.main");
		SpringApplication.run(LogmanagerApplication.class, args);
	}

}
