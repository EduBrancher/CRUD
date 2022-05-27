package com.urenha.ddsheet.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.urenha.ddsheet.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	DBService dbService;
	
	//bean annotation makes this run when profile is active and application is ran
	@Bean
	public void instantiate() {
		this.dbService.instantiateDB();
	}
	
}
