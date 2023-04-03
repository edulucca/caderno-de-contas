package com.cadernodecontas.CadernoDeContas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class CadernoDeContasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadernoDeContasApplication.class, args);
	}

}
