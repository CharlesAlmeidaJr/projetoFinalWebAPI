package com.funtec.projetoFinalWebAPI.service.impl;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funtec.projetoFinalWebAPI.model.EmpresaCliente;
import com.funtec.projetoFinalWebAPI.model.EstadosBrasileiros;
import com.funtec.projetoFinalWebAPI.model.Frota;
import com.funtec.projetoFinalWebAPI.model.Funcionario;
import com.funtec.projetoFinalWebAPI.model.Registro;
import com.funtec.projetoFinalWebAPI.model.RegistroCategoria;
import com.funtec.projetoFinalWebAPI.model.form.EmpresaClienteForm;
import com.funtec.projetoFinalWebAPI.model.form.EmpresaClienteUpdateForm;
import com.funtec.projetoFinalWebAPI.repository.EmpresaClienteRepository;
import com.funtec.projetoFinalWebAPI.service.IEmpresaClienteService;

@Service
public class EmpresaClienteServiceImpl implements IEmpresaClienteService{
	
	@Autowired
	EmpresaClienteRepository repository;

	@Override
	public EmpresaCliente create(EmpresaClienteForm form) {
		EmpresaCliente empresa = new EmpresaCliente();
		empresa.setNome(form.getNome());
		empresa.setCnpj(form.getCnpj());
		empresa.setCidade(form.getCidade());
		empresa.setEndereco(form.getEndereco());
		empresa.setEstado(form.getEstado());
		return repository.save(empresa);
	}

	@Override
	public EmpresaCliente get(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public EmpresaCliente update(EmpresaClienteUpdateForm form, Long id) {
		EmpresaCliente empresa = repository.findById(id).get();
		empresa.setNome(form.getNome());
		empresa.setEndereco(form.getEndereco());
		empresa.setCidade(form.getCidade());
		empresa.setEstado(form.getEstado());
		return repository.save(empresa);
	}

	@Override
	public Set<EmpresaCliente> getAll() {
		return new TreeSet<EmpresaCliente>(repository.findAll());
	}
	
	@Override
	public Set<EmpresaCliente> getAllByEstado(String estado){
		EstadosBrasileiros estadoEmpresa = EstadosBrasileiros.valueOf(estado);
		return new TreeSet<EmpresaCliente>(repository.findByEstado(estadoEmpresa));
	}

	@Override
	public Set<Funcionario> getAllFuncionarios(Long id) {
		EmpresaCliente empresa = repository.findById(id).get();
		return new TreeSet<Funcionario> (empresa.getFuncionarios());
	}

	@Override
	public Set<Frota> getAllFrotas(Long id) {
		EmpresaCliente empresa = repository.findById(id).get();
		return new TreeSet<Frota>(empresa.getFrotas());
	}
	
	@Override
	public Set<Registro> getAllResgistros(Long id){
//		Set<Registro> registros = new TreeSet<Registro>();
//		
//		for(Frota frota : getAllFrotas(id)) {
//			registros.addAll(frota.getRegistros());
//		}
//		
//		return registros;
		
		return new TreeSet<Registro>(repository.findAllRegistro(id));
	}
	
	
	public Set<Registro> getAllResgistrosByCategoria(Long id, String categoria){
		return new TreeSet<Registro>(repository.findAllRegistroByCategoria(id, categoria));
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
}
