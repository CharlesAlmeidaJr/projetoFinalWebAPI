package com.funtec.projetoFinalWebAPI.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

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
	public Arquivo create(MultipartFile file, Long idRegistro) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());				
		Arquivo arquivo = new Arquivo();
		arquivo.setNome(fileName);
		arquivo.setTipo(file.getContentType());
		arquivo.setData(file.getBytes());
		arquivo.setRegistro(registroRepository.findById(idRegistro).get());
		
		return repository.save(arquivo);
	}
	
	@Override
	public Arquivo get(Long id) {
		return repository.findById(id).get();
	}
	
//	@Override
//	public Arquivo update(ArquivoUpdateForm form, Long id) {
//		Arquivo arquivo = new Arquivo();
//		arquivo.setNome(form.getNome());
//		arquivo.setCaminhoArquivo(form.getCaminhoArquivo());
//		
//		return repository.save(arquivo);
//	}
	
	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
