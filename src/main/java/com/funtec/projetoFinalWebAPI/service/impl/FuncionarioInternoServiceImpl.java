package com.funtec.projetoFinalWebAPI.service.impl;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;

import com.funtec.projetoFinalWebAPI.model.Funcionario;
import com.funtec.projetoFinalWebAPI.model.FuncionarioInternoCargo;
import com.funtec.projetoFinalWebAPI.model.Registro;
import com.funtec.projetoFinalWebAPI.model.form.FuncionarioInternoForm;
import com.funtec.projetoFinalWebAPI.model.form.FuncionarioInternoUpdateForm;
import com.funtec.projetoFinalWebAPI.repository.FuncionarioRepository;
import com.funtec.projetoFinalWebAPI.service.IFuncionarioInternoService;

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
	public Funcionario get(Long id) {
		return repository.findById(id).get();
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
		
//		Set<Funcionario> funcionarios = new TreeSet<Funcionario>();
//		
//		for(Funcionario funcionario : repository.findAll()) {
//			if(funcionario.getCargo() != null) {
//				funcionarios.add(funcionario);
//			}
//		}
//		
//		return funcionarios;
		
		return new TreeSet<Funcionario>(repository.findAllFuncionarioInterno());
	}
	
	
	public Set<Funcionario> getAllByCargo(String cargo){
		FuncionarioInternoCargo funcionarioCargo = FuncionarioInternoCargo.valueOf(cargo);
		return new TreeSet<Funcionario>(repository.findAllByCargo(cargo));
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

}
