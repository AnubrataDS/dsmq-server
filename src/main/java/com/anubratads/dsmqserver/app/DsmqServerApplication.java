package com.anubratads.dsmqserver.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.anubratads.dsmqserver")
@SpringBootApplication
public class DsmqServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsmqServerApplication.class, args);
	}

}
