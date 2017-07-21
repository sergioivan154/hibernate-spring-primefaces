package com.sergio.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	public Mundo mundoBeanAppConfig() {
		return new Mundo();
	}

}
