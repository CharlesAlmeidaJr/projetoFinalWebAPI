package com.funtec.projetoFinalWebAPI.service.impl;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funtec.projetoFinalWebAPI.model.Funcionario;
import com.funtec.projetoFinalWebAPI.model.Registro;
import com.funtec.projetoFinalWebAPI.model.form.LoginForm;
import com.funtec.projetoFinalWebAPI.repository.FuncionarioRepository;
import com.funtec.projetoFinalWebAPI.service.IFuncionarioService;

@Service
public class FuncionarioServiceImpl implements IFuncionarioService{
	
	@Autowired
	FuncionarioRepository repository;
	
	@Override
	public Funcionario get(Long id) {
		return repository.findById(id).get();
	}
	
	@Override
	public Set<Funcionario> getAll(){
		return new TreeSet<Funcionario>(repository.findAll());
	}
	
	@Override
	public Set<Registro> getRegistrosById(Long id){
		Funcionario funcionario = repository.findById(id).get();
		
		return funcionario.getRegistros();
	}
	
	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	
	public Funcionario login(LoginForm form) {
		Funcionario funcionario = repository.login(form.getLogin(), form.getSenha());
		if (funcionario != null) {
			return funcionario.isAtivo() ? funcionario : null;
		}
		else {
			return null;
		}
		
	}

}
