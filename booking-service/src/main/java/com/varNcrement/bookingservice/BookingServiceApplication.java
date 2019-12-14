package com.varNcrement.bookingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.*;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class BookingServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(BookingServiceApplication.class, args);
	}
}

