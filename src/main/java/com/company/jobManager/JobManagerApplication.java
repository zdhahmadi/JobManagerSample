package com.company.jobManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobManagerApplication {
	private static final Logger logger = LoggerFactory.getLogger(JobManagerApplication.class);
	public static void main(String[] args) {
		logger.info("start job application");
		try{
			SpringApplication.run(JobManagerApplication.class, args);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}