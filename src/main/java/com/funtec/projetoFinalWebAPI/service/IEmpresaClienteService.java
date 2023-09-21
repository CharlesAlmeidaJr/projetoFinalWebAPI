package com.funtec.projetoFinalWebAPI.service;

import java.util.Set;

import com.funtec.projetoFinalWebAPI.model.EmpresaCliente;
import com.funtec.projetoFinalWebAPI.model.Frota;
import com.funtec.projetoFinalWebAPI.model.Funcionario;
import com.funtec.projetoFinalWebAPI.model.Registro;
import com.funtec.projetoFinalWebAPI.model.form.EmpresaClienteForm;
import com.funtec.projetoFinalWebAPI.model.form.EmpresaClienteUpdateForm;

public interface IEmpresaClienteService {
	
	EmpresaCliente create(EmpresaClienteForm form);
	
	EmpresaCliente get(Long id);
	
	EmpresaCliente update(EmpresaClienteUpdateForm form, Long id);
	
	Set<EmpresaCliente> getAll();
	
	Set<Funcionario> getAllFuncionarios(Long id);
	
	Set<Frota> getAllFrotas(Long id);
	
	void delete(Long id);

	Set<EmpresaCliente> getAllByEstado(String estado);

	Set<Registro> getAllResgistros(Long id);

}
