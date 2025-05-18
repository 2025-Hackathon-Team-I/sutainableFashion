package com.example.sustainableFashion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class sustainableFashionApplication {

	public static void main(String[] args) {
		SpringApplication.run(sustainableFashionApplication.class, args);
	}

}
