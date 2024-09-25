package com.webcrudsecurityboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"com.webcrudsecurityboot.model"})
@SpringBootApplication
public class WebCRUDSecurityBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebCRUDSecurityBootApplication.class, args);
	}

}
