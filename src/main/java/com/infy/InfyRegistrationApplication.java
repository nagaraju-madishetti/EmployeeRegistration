package com.infy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@Slf4j
@SpringBootApplication
public class InfyRegistrationApplication {

	public static void main(String[] args) {

		SpringApplication.run(InfyRegistrationApplication.class, args);
		log.info("Info level log message");
		log.trace("Debug level log message");
		log.error("Error level log message");
	}

}