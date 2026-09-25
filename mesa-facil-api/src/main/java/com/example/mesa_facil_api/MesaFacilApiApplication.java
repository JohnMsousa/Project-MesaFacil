package com.example.mesa_facil_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MesaFacilApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MesaFacilApiApplication.class, args);
	}

}
