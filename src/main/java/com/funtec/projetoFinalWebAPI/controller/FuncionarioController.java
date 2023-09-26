package com.funtec.projetoFinalWebAPI.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.funtec.projetoFinalWebAPI.model.Funcionario;
import com.funtec.projetoFinalWebAPI.model.Registro;
import com.funtec.projetoFinalWebAPI.model.form.FuncionarioClienteForm;
import com.funtec.projetoFinalWebAPI.model.form.FuncionarioClienteUpdateForm;
import com.funtec.projetoFinalWebAPI.model.form.FuncionarioInternoForm;
import com.funtec.projetoFinalWebAPI.model.form.FuncionarioInternoUpdateForm;
import com.funtec.projetoFinalWebAPI.model.form.LoginForm;
import com.funtec.projetoFinalWebAPI.service.impl.FuncionarioClienteServiceImpl;
import com.funtec.projetoFinalWebAPI.service.impl.FuncionarioInternoServiceImpl;
import com.funtec.projetoFinalWebAPI.service.impl.FuncionarioServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	FuncionarioServiceImpl service;
	@Autowired
	FuncionarioClienteServiceImpl serviceCliente;
	@Autowired
	FuncionarioInternoServiceImpl serviceInterno;
	
	@PostMapping("/cadastro/interno")
	public Funcionario createInterno(@RequestBody FuncionarioInternoForm form) {
		
		return serviceInterno.create(form);
		
	}
	
	@PostMapping("/cadastro/cliente")
	public Funcionario createCliente(@RequestBody FuncionarioClienteForm form) {
		
		return serviceCliente.create(form);
		
	}
	
	@GetMapping("/{id}")
	public Funcionario get(@PathVariable(value = "id") Long id) {
		return service.get(id);
	}
	
	@PutMapping("/cliente/{id}")
	public Funcionario updateCliente(@PathVariable(value = "id") Long id, @RequestBody FuncionarioClienteUpdateForm form) {
		return serviceCliente.update(form, id);
	}
	
	@PutMapping("/interno/{id}")
	public Funcionario updateCliente(@PathVariable(value = "id") Long id, @RequestBody FuncionarioInternoUpdateForm form) {
		return serviceInterno.update(form, id);
	}
	
	@GetMapping
	public Set<Funcionario> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/clientes")
	public Set<Funcionario> getAllClientes() {
		return serviceCliente.getAll();
	}
	
	@GetMapping("/internos")
	public Set<Funcionario> getAllInternos() {
		return serviceInterno.getAll();
	}
	
	@GetMapping("/internos/{cargo}")
	public Set<Funcionario> getAllInternosByCargo(@PathVariable(value = "cargo") String cargo) {
		return serviceInterno.getAllByCargo(cargo);
	}
	
	@GetMapping("/{id}/registros")
	public Set<Registro> getRegistros(@PathVariable(value = "id") Long id){
		return service.getRegistrosById(id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
	}
	
	@PostMapping("/login")
	public Funcionario login(@RequestBody LoginForm login) {
		return service.login(login);
	}

}
