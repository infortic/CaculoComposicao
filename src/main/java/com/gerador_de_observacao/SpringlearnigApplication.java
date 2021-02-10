package com.gerador_de_observacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gerador_de_observacao.service.Service;


@SpringBootApplication
public class SpringlearnigApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringlearnigApplication.class, args);
		Service.run();	
	}

}
