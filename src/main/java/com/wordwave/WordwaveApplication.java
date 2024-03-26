package com.wordwave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class WordwaveApplication {

	public static void main(String[] args) {
		SpringApplication.run(WordwaveApplication.class, args);
	}

}
