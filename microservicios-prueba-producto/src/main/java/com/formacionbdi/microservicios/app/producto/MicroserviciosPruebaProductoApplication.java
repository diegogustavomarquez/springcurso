package com.formacionbdi.microservicios.app.producto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.springcurso.entitys.entity"})
public class MicroserviciosPruebaProductoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosPruebaProductoApplication.class, args);
	}

}
