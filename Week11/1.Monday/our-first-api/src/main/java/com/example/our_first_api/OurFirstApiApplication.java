package com.example.our_first_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OurFirstApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OurFirstApiApplication.class, args);
	}

}
