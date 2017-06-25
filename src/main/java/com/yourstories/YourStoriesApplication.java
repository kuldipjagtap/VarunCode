package com.yourstories;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@ComponentScan(basePackages={"com.yourstories"})
@EnableMongoRepositories(basePackages={"com.yourstories.repositories"})
@SpringBootApplication
public class YourStoriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(YourStoriesApplication.class, args);
	}
}
