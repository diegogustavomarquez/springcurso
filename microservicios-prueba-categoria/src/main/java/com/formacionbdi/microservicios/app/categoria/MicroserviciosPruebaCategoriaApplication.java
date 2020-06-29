package com.formacionbdi.microservicios.app.categoria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EntityScan({"com.springcurso.entitys.entity"})
public class MicroserviciosPruebaCategoriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosPruebaCategoriaApplication.class, args);
	}

}
