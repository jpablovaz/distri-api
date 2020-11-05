package com.wopiro.distri;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DistriApplication {

	@Value("${disti.migrate}")
	static boolean isMigrate;
	@Value("${disti.logable}")
	static boolean isLog;

	public static void main(String[] args) {
		SpringApplication.run(DistriApplication.class, args);		
	}

	@PostConstruct
	private void init() {
		
	}
}