package com.eureka.client.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SchoolServiceEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolServiceEurekaClientApplication.class, args);
	}

}
