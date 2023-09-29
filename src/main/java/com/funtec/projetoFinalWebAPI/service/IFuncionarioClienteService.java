package com.funtec.projetoFinalWebAPI.service;

import java.util.Set;

import com.funtec.projetoFinalWebAPI.model.Funcionario;
import com.funtec.projetoFinalWebAPI.model.form.FuncionarioClienteForm;
import com.funtec.projetoFinalWebAPI.model.form.FuncionarioClienteUpdateForm;

public interface IFuncionarioClienteService {

	Funcionario create(FuncionarioClienteForm form);

	Funcionario update(FuncionarioClienteUpdateForm form, Long id);

	Set<Funcionario> getAll();

	

}
