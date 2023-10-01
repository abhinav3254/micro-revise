package com.abhinav.book_registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BookRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookRegistryApplication.class, args);
	}

}
