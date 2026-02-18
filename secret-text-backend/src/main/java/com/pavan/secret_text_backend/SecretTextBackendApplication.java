package com.pavan.secret_text_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing

public class SecretTextBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecretTextBackendApplication.class, args);
	}

}
