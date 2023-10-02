package com.funtec.projetoFinalWebAPI.controller;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.funtec.projetoFinalWebAPI.message.ResponseFile;
import com.funtec.projetoFinalWebAPI.model.Arquivo;
import com.funtec.projetoFinalWebAPI.model.Registro;
import com.funtec.projetoFinalWebAPI.model.RegistroCategoria;
import com.funtec.projetoFinalWebAPI.model.form.RegistroForm;
import com.funtec.projetoFinalWebAPI.model.form.RegistroUpdateForm;
import com.funtec.projetoFinalWebAPI.service.impl.RegistroServiceImpl;

@Transactional
@RestController
@CrossOrigin
@RequestMapping("/registros")
public class RegistroController {

	@Autowired
	RegistroServiceImpl registro;
	
	@PostMapping("/cadastro")
	public Registro create(@RequestBody RegistroForm form) {
		return registro.create(form);
	}
	
	@GetMapping("/{id}")
	public Registro get(@PathVariable("id") Long id) {
		return registro.get(id);
	}
	
	@PutMapping ("/update/{id}") 
	public Registro update(@PathVariable("id") Long id, @RequestBody RegistroUpdateForm form ) {
		return registro.update(form, id);
	}
	
	@GetMapping
	public Set<Registro> getAll() {
		return registro.getAll();
	}
	
	@GetMapping("/{id}/arquivos")
	public ResponseEntity<List<ResponseFile>> getAllArquivo(@PathVariable("id") Long id) {
		
		List<ResponseFile> files = registro.getAllArquivo(id).map(dbFile -> {
			String fileDownloadUri = ServletUriComponentsBuilder
					.fromCurrentContextPath()
					.path("/arquivos/")
					.path(dbFile.getId()+"")
					.toUriString();
			return new ResponseFile(dbFile.getNome(), fileDownloadUri, dbFile.getTipo(), dbFile.getData().length);
		}).collect(Collectors.toList());
		
		return ResponseEntity.status(HttpStatus.OK).body(files);
	}
	
	@GetMapping("/categorias/{categoria}")
	public Set<Registro> getAllByCategoria(@PathVariable("categoria") String categoria) {
		return registro.getAllByCategoria(categoria);
	}
	
	@GetMapping("/categorias")
	public Set<RegistroCategoria> getAllCategorias() {
		Set<RegistroCategoria> categorias = new TreeSet<RegistroCategoria>();
		for(RegistroCategoria categoria : RegistroCategoria.values())categorias.add(categoria);		
		return categorias;
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		registro.delete(id);
	}
}
