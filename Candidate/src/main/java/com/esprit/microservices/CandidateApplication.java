package com.esprit.microservices;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CandidateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CandidateApplication.class, args);
	}

	@Bean
	ApplicationRunner init(CandidateRepository repository) {
		return args -> {
			repository.findAll().forEach(System.out::println);
		};
	}

}
