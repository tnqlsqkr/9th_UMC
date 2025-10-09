package com.example.umc9th;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Umc9thApplication {

	public static void main(String[] args) {
		SpringApplication.run(Umc9thApplication.class, args);
	}

}
