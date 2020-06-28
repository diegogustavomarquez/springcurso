package com.formacionbdi.microservicios.app.getway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviciosGetwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosGetwayApplication.class, args);
	}

}
