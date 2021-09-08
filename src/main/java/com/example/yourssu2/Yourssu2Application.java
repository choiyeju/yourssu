package com.example.yourssu2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Yourssu2Application {

	public static void main(String[] args) {
		SpringApplication.run(Yourssu2Application.class, args);
	}

}
