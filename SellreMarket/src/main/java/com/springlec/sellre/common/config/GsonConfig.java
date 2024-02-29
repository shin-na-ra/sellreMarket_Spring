package com.springlec.sellre.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Configuration
public class GsonConfig {
	@Bean
	public Gson gson() {
		return new GsonBuilder()
				// 추가적인 설정을 적용할 수 있음. (날짜 형식이나 null 값을 직렬화할지 여부 등)
				.create();
	}
}
