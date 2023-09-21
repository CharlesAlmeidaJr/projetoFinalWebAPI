package com.funtec.projetoFinalWebAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.funtec.projetoFinalWebAPI.model.Funcionario;
import com.funtec.projetoFinalWebAPI.model.form.LoginForm;
import com.funtec.projetoFinalWebAPI.service.impl.FuncionarioServiceImpl;

@RestController
public class HomeController {
	
	@Autowired
	FuncionarioServiceImpl serviceFuncionario;
	
	@GetMapping("/login")
	public Funcionario login(@RequestBody LoginForm login) {
		return serviceFuncionario.login(login);
	}

}
