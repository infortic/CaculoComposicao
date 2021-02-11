package com.calculocomposicoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.calculocomposicoes.service.Service;


@SpringBootApplication
public class SpringlearnigApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringlearnigApplication.class, args);
		Service.run();	
	}

}
