package com.funtec.projetoFinalWebAPI.service.impl;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;

import com.funtec.projetoFinalWebAPI.model.Arquivo;
import com.funtec.projetoFinalWebAPI.model.Registro;
import com.funtec.projetoFinalWebAPI.model.RegistroCategoria;
import com.funtec.projetoFinalWebAPI.model.form.RegistroForm;
import com.funtec.projetoFinalWebAPI.model.form.RegistroUpdateForm;
import com.funtec.projetoFinalWebAPI.repository.FrotaRepository;
import com.funtec.projetoFinalWebAPI.repository.FuncionarioRepository;
import com.funtec.projetoFinalWebAPI.repository.RegistroRepository;
import com.funtec.projetoFinalWebAPI.service.IRegistroService;

public class RegistroServiceImpl implements IRegistroService{ 

	@Autowired
	RegistroRepository repository;
	@Autowired
	FrotaRepository frotaRepository;
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	@Override
	public Registro create(RegistroForm form) {
		Registro registro = new Registro();
		registro.setTitulo(form.getTitulo());
		registro.setDescricao(form.getDescricao());
		registro.setCategoria(form.getRegistroCategoria());
		registro.setFrota(frotaRepository.findById(form.getIdFrota()).get());
		registro.setFuncionario(funcionarioRepository.findById(form.getIdFuncionario()).get());
		return repository.save(registro);
	}

	@Override
	public Registro get(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public Registro update(RegistroUpdateForm form, Long id) {
		Registro registro = repository.findById(id).get();
		registro.setTitulo(form.getTitulo());
		registro.setDescricao(form.getDescricao());
		registro.setCategoria(form.getRegistroCategoria());
		return repository.save(registro);
	}
	
	@Override
	public Set<Registro> getAll() {
		return new TreeSet<Registro>(repository.findAll());
	}
	
	@Override
	public Set<Registro> getAllByCategoria(String categoria){
		RegistroCategoria registroCategoria = RegistroCategoria.valueOf(categoria);
		return new TreeSet<Registro>(repository.findAllByCategoria(registroCategoria));
	}

	@Override
	public Set<Arquivo> getAllArquivo(Long id) {
		Registro registro = repository.findById(id).get();
		return new TreeSet<Arquivo>(registro.getArquivos());
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
