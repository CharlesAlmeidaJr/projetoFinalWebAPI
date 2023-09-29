package com.funtec.projetoFinalWebAPI.service.impl;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funtec.projetoFinalWebAPI.model.Frota;
import com.funtec.projetoFinalWebAPI.model.Registro;
import com.funtec.projetoFinalWebAPI.model.form.FrotaForm;
import com.funtec.projetoFinalWebAPI.model.form.FrotaUpdateForm;
import com.funtec.projetoFinalWebAPI.repository.EmpresaClienteRepository;
import com.funtec.projetoFinalWebAPI.repository.FrotaRepository;
import com.funtec.projetoFinalWebAPI.service.IFrotaService;

@Service
public class FrotaServiceImpl implements IFrotaService{

	@Autowired
	FrotaRepository repository;
	@Autowired
	EmpresaClienteRepository empresaRepository;
	
	@Override
	public Frota create(FrotaForm form) {
		Frota frota = new Frota();
		frota.setNome(form.getNome());
		frota.setEmpresa(empresaRepository.findById(form.getIdEmpresa()).get());
		return repository.save(frota);
	}

	@Override
	public Frota get(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public Frota update(FrotaUpdateForm form, Long id) {
		Frota frota = repository.findById(id).get();
		frota.setNome(form.getNome());
		return repository.save(frota);
	}

	@Override
	public Set<Registro> getAllRegistro(Long id) {
		Frota frota = repository.findById(id).get();
		return new TreeSet<Registro>(frota.getRegistros());
	}
	
	@Override
	public Set<Registro> getAllRegistroByCategoria(Long id, String categoria) {
		Set<Registro> registros = new TreeSet<Registro>();
		for(Registro r : getAllRegistro(id)) {
			if(r.getCategoria().name().equals(categoria)) registros.add(r);
		}
		return registros;
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
