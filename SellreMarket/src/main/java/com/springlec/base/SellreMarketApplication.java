package com.springlec.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.springlec")
public class SellreMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellreMarketApplication.class, args);
	}

}
