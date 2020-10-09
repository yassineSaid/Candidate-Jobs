package com.esprit.microservices;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JobsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobsApplication.class, args);
	}

	@Bean
	ApplicationRunner init(JobRepository repository) {
		return args -> {
			repository.findAll().forEach(System.out::println);
		};
	}
}
