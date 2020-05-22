package com.tmassalski.warsawpublictransporttracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WarsawPublicTransportTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WarsawPublicTransportTrackerApplication.class, args);
	}
}
