package com.example.sping_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.example.sping_demo.controller")
public class SpingDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpingDemoApplication.class, args);
	}

}
