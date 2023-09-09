package com.FxTradingAssignment.FxTradingMicroService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.FxTradingAssignment.FxTradingMicroService.controller")
public class FxTradingMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FxTradingMicroServiceApplication.class, args);
	}

}
