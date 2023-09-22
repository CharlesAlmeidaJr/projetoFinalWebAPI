package com.funtec.projetoFinalWebAPI;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.funtec.projetoFinalWebAPI.model.FuncionarioInternoCargo;
import com.funtec.projetoFinalWebAPI.model.form.FuncionarioInternoForm;
import com.funtec.projetoFinalWebAPI.service.impl.FuncionarioInternoServiceImpl;

@SpringBootApplication
public class ProjetoFinalWebApiApplication { 

	public static void main(String[] args) {
		SpringApplication.run(ProjetoFinalWebApiApplication.class, args);
		
		
	}
	
	@Bean
	CommandLineRunner init (FuncionarioInternoServiceImpl service) {
		return args -> {
			if(service.getAll().size() == 0) {
				FuncionarioInternoForm funcionario = new FuncionarioInternoForm();
				funcionario.setNome("Admin");
				funcionario.setLogin("admin");
				funcionario.setSenha("admin");
				funcionario.setCargo(FuncionarioInternoCargo.GERENCIA);
				service.create(funcionario);
			}
				
		};
	}
}
