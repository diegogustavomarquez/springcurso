package com.formacionbdi.microservicios.app.producto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroserviciosPruebaProductoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosPruebaProductoApplication.class, args);
	}

}
