package com.funtec.projetoFinalWebAPI.service.impl;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funtec.projetoFinalWebAPI.model.Funcionario;
import com.funtec.projetoFinalWebAPI.model.FuncionarioInternoCargo;
import com.funtec.projetoFinalWebAPI.model.form.FuncionarioInternoForm;
import com.funtec.projetoFinalWebAPI.model.form.FuncionarioInternoUpdateForm;
import com.funtec.projetoFinalWebAPI.repository.FuncionarioRepository;
import com.funtec.projetoFinalWebAPI.service.IFuncionarioInternoService;

@Service
public class FuncionarioInternoServiceImpl implements IFuncionarioInternoService{
	@Autowired
	private FuncionarioRepository repository;
	
	@Override
	public Funcionario create(FuncionarioInternoForm form) {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(form.getNome());
		funcionario.setLogin(form.getLogin());
		funcionario.setSenha(form.getSenha());
		funcionario.setEmail(form.getEmail());
		funcionario.setCargo(form.getCargo());
		funcionario.setEmpresa(null);
		funcionario.setAtivo(true);
		
		return repository.save(funcionario);
	}
	
	@Override
	public Funcionario update(FuncionarioInternoUpdateForm form, Long id) {
		Funcionario funcionario = repository.findById(id).get();
		funcionario.setNome(form.getNome());
		funcionario.setSenha(form.getSenha());
		funcionario.setEmail(form.getEmail());
		funcionario.setCargo(form.getCargo());
		funcionario.setAtivo(form.isAtivo());
		
		return repository.save(funcionario);
	}
	
	@Override
	public Set<Funcionario> getAll(){		
		return new TreeSet<Funcionario>(repository.findAllFuncionarioInterno());
	}
	
	
	public Set<Funcionario> getAllByCargo(String cargo){
		FuncionarioInternoCargo funcionarioCargo = FuncionarioInternoCargo.valueOf(cargo);
		return new TreeSet<Funcionario>(repository.findAllByCargo(funcionarioCargo.name()));
	}

}
