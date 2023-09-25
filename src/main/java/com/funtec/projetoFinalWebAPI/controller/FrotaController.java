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

import com.funtec.projetoFinalWebAPI.model.Frota;
import com.funtec.projetoFinalWebAPI.model.Registro;
import com.funtec.projetoFinalWebAPI.model.form.FrotaForm;
import com.funtec.projetoFinalWebAPI.model.form.FrotaUpdateForm;
import com.funtec.projetoFinalWebAPI.service.impl.FrotaServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/frotas")
public class FrotaController {

	@Autowired
	FrotaServiceImpl frota;
	
	@PostMapping ("/cadastro")
	public Frota create(@RequestBody FrotaForm form) {
		return frota.create(form);
	}
	
	@GetMapping("/{id}")
	public Frota get(@PathVariable("id") Long id) {
		return frota.get(id);
	}
	
	@PutMapping("/{id}")
	public Frota update(@PathVariable("id") Long id, @RequestBody FrotaUpdateForm form) {
		return frota.update(form, id);
	}
	
	@GetMapping("/{id}/registros")
	public Set<Registro> getAllRegistros(@PathVariable("id") Long id) {
		return frota.getAllRegistro(id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		frota.delete(id);
	}
}
