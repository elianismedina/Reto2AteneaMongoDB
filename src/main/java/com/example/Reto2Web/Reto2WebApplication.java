package com.example.Reto2Web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Reto2WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(Reto2WebApplication.class, args);
	}

}
