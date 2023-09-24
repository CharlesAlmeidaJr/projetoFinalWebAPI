package com.funtec.projetoFinalWebAPI.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.funtec.projetoFinalWebAPI.model.Arquivo;
import com.funtec.projetoFinalWebAPI.model.form.ArquivoForm;
import com.funtec.projetoFinalWebAPI.model.form.ArquivoUpdateForm;
import com.funtec.projetoFinalWebAPI.service.impl.ArquivoServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/arquivos")
public class ArquivoController {

	@Autowired
	ArquivoServiceImpl arquivo;
	
	@PostMapping ("/criarArquivo")
	public Arquivo create(@RequestBody ArquivoForm form) {
		return arquivo.create(form);
	}
	
	@GetMapping("/{id}")
	public Arquivo get(@PathVariable("id") Long id) {
		return arquivo.get(id);
	}
	
	@PutMapping ("/{id}") 
	public Arquivo update(@PathVariable("id") Long id, @RequestBody ArquivoUpdateForm form ) {
		return arquivo.update(form, id);
	}
}
