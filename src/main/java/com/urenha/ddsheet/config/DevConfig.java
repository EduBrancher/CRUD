package com.urenha.ddsheet.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.urenha.ddsheet.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	
	@Bean
	public boolean instantiateDatabase() {
		if (strategy.equals("create")) {
			this.dbService.instantiateDB();
			return true;
		}
		return false;
	}
	
}
