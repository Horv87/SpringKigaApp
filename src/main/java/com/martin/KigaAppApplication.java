package com.martin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class KigaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(KigaAppApplication.class, args);
	}
}
