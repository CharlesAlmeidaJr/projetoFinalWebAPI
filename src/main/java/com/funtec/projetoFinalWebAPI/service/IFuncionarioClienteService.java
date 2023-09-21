package com.funtec.projetoFinalWebAPI.service;

import java.util.Set;

import com.funtec.projetoFinalWebAPI.model.Funcionario;
import com.funtec.projetoFinalWebAPI.model.Registro;
import com.funtec.projetoFinalWebAPI.model.form.FuncionarioClienteForm;
import com.funtec.projetoFinalWebAPI.model.form.FuncionarioClienteUpdateForm;

public interface IFuncionarioClienteService {

	Funcionario create(FuncionarioClienteForm form);

	Funcionario get(Long id);

	Funcionario update(FuncionarioClienteUpdateForm form, Long id);

	Set<Funcionario> getAll();

	Set<Registro> getRegistrosById(Long id);

	void delete(Long id);

	

}
