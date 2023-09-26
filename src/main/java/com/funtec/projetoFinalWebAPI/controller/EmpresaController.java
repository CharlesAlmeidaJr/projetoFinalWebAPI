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

import com.funtec.projetoFinalWebAPI.model.EmpresaCliente;
import com.funtec.projetoFinalWebAPI.model.Frota;
import com.funtec.projetoFinalWebAPI.model.Funcionario;
import com.funtec.projetoFinalWebAPI.model.Registro;
import com.funtec.projetoFinalWebAPI.model.form.EmpresaClienteForm;
import com.funtec.projetoFinalWebAPI.model.form.EmpresaClienteUpdateForm;
import com.funtec.projetoFinalWebAPI.service.impl.EmpresaClienteServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/empresas")
public class EmpresaController {
	
	@Autowired
	EmpresaClienteServiceImpl service;
	
	@PostMapping("/cadastro")
	public EmpresaCliente create(@RequestBody EmpresaClienteForm form) {
		return service.create(form);
	}
	
	@GetMapping("/{id}")
	public EmpresaCliente get(@PathVariable(value = "id") Long id) {
		return service.get(id);
	}
	
	@PutMapping("/{id}")
	public EmpresaCliente update(@PathVariable(value = "id") Long id, @RequestBody EmpresaClienteUpdateForm form) {
		return service.update(form, id);
	}
	
	@GetMapping
	public Set<EmpresaCliente> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/{estado}")
	public Set<EmpresaCliente> getAllByEstado(@PathVariable(value = "estado") String estado){
		return service.getAllByEstado(estado);
	}
	
	@GetMapping("/{id}/funcionarios")
	public Set<Funcionario> getFuncionarios(@PathVariable(value = "id") Long id){
		return service.getAllFuncionarios(id);
	}
	
	@GetMapping("/{id}/frotas")
	public Set<Frota> getFrotas(@PathVariable(value = "id") Long id){
		return service.getAllFrotas(id);
	}
	
	@GetMapping("/{id}/registros")
	public Set<Registro> getRegistros(@PathVariable(value = "id") Long id){
		return service.getAllResgistros(id);
	}
	
	@GetMapping("/{id}/registros/{categoria}")
	public Set<Registro> getRegistrosByCategoria(@PathVariable(value = "id") Long id,@PathVariable(value = "categoria") String categoria){
		return service.getAllResgistrosByCategoria(id, categoria);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
	}

}
