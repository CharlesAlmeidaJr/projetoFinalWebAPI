package com.funtec.projetoFinalWebAPI.service.impl;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funtec.projetoFinalWebAPI.model.Funcionario;
import com.funtec.projetoFinalWebAPI.model.form.FuncionarioClienteForm;
import com.funtec.projetoFinalWebAPI.model.form.FuncionarioClienteUpdateForm;
import com.funtec.projetoFinalWebAPI.repository.EmpresaClienteRepository;
import com.funtec.projetoFinalWebAPI.repository.FuncionarioRepository;
import com.funtec.projetoFinalWebAPI.service.IFuncionarioClienteService;

@Service
public class FuncionarioClienteServiceImpl implements IFuncionarioClienteService{
	
	@Autowired
	FuncionarioRepository repository;
	@Autowired
	EmpresaClienteRepository empresaRepository;
	
	@Override
	public Funcionario create(FuncionarioClienteForm form) {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(form.getNome());
		funcionario.setLogin(form.getLogin());
		funcionario.setSenha(form.getSenha());
		funcionario.setEmail(form.getEmail());
		funcionario.setCargo(null);
		funcionario.setEmpresa(empresaRepository.findById(form.getIdEmpresa()).get());
		funcionario.setAtivo(true);
		
		return repository.save(funcionario);
	}
	
	@Override
	public Funcionario update(FuncionarioClienteUpdateForm form, Long id) {
		Funcionario funcionario = repository.findById(id).get();
		funcionario.setNome(form.getNome());
		funcionario.setSenha(form.getSenha());
		funcionario.setEmail(form.getEmail());
		funcionario.setAtivo(form.isAtivo());
		
		return repository.save(funcionario);
	}
	
	@Override
	public Set<Funcionario> getAll(){
		return new TreeSet<Funcionario>(repository.findAllFuncionarioCliente());
	}

}
