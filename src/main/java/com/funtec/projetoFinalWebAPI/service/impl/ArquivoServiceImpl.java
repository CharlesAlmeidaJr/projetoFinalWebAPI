package com.funtec.projetoFinalWebAPI.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funtec.projetoFinalWebAPI.model.Arquivo;
import com.funtec.projetoFinalWebAPI.model.form.ArquivoForm;
import com.funtec.projetoFinalWebAPI.model.form.ArquivoUpdateForm;
import com.funtec.projetoFinalWebAPI.repository.ArquivoRepository;
import com.funtec.projetoFinalWebAPI.repository.RegistroRepository;
import com.funtec.projetoFinalWebAPI.service.IArquivoService;

@Service
public class ArquivoServiceImpl implements IArquivoService{
	
	@Autowired
	ArquivoRepository repository;
	@Autowired
	RegistroRepository registroRepository;
	
	@Override
	public Arquivo create(ArquivoForm form) {
		Arquivo arquivo = new Arquivo();
		arquivo.setNome(form.getNome());
		arquivo.setCaminhoArquivo(form.getCaminhoArquivo());
		arquivo.setRegistro(registroRepository.findById(form.getId_registro()).get());
		
		return repository.save(arquivo);
	}
	
	@Override
	public Arquivo get(Long id) {
		return repository.findById(id).get();
	}
	
	@Override
	public Arquivo update(ArquivoUpdateForm form) {
		Arquivo arquivo = new Arquivo();
		arquivo.setNome(form.getNome());
		arquivo.setCaminhoArquivo(form.getCaminhoArquivo());
		
		return repository.save(arquivo);
	}
	
	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
