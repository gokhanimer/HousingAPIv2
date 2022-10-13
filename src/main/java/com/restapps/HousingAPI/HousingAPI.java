package com.restapps.HousingAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class HousingAPI {

	public static void main(String[] args) {
		SpringApplication.run(HousingAPI.class, args);
	}

	
}
