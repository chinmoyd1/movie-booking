package com.varNcrement.dicoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@SpringBootApplication
@EnableEurekaServer
public class DicoveryServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(DicoveryServiceApplication.class, args);
	}
}
