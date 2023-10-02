package com.funtec.projetoFinalWebAPI.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.funtec.projetoFinalWebAPI.message.ResponseMessage;
import com.funtec.projetoFinalWebAPI.model.Arquivo;
import com.funtec.projetoFinalWebAPI.model.form.ArquivoForm;
import com.funtec.projetoFinalWebAPI.model.form.ArquivoUpdateForm;
import com.funtec.projetoFinalWebAPI.service.impl.ArquivoServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/arquivos")
public class ArquivoController {

	@Autowired
	ArquivoServiceImpl service;
	
	@PostMapping ("/upload/{idRegistro}")
	public ResponseEntity<ResponseMessage> create(@RequestParam("file") MultipartFile file, @PathVariable("idRegistro") Long id) {
		
		String message = "";
		
		try {
			service.create(file, id);
			message = "Carregado com sucesso: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		}catch(Exception e) {
			message = "Não foi possível carregar: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<byte[]> get(@PathVariable("id") Long id) {
		 Arquivo arquivo = service.get(id);
		 
		 return ResponseEntity.ok()
				 .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + arquivo.getNome() + "\"")
				 .body(arquivo.getData());
	}
	
//	@PutMapping ("/update/{id}") 
//	public Arquivo update(@PathVariable("id") Long id, @RequestBody ArquivoUpdateForm form ) {
//		return arquivo.update(form, id);
//	}
	
	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
	}
}
