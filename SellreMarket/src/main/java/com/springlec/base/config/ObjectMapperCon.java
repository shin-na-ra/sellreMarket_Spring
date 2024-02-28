package com.springlec.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class ObjectMapperCon {

	
	@Bean
	ObjectMapper objectMapper() throws Exception {
		return new ObjectMapper();
	} 
}
