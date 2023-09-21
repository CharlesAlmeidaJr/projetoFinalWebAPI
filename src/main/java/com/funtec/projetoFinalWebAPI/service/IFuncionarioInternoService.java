package com.funtec.projetoFinalWebAPI.service;

import java.util.Set;

import com.funtec.projetoFinalWebAPI.model.Funcionario;
import com.funtec.projetoFinalWebAPI.model.Registro;
import com.funtec.projetoFinalWebAPI.model.form.FuncionarioInternoForm;
import com.funtec.projetoFinalWebAPI.model.form.FuncionarioInternoUpdateForm;

public interface IFuncionarioInternoService {

	Funcionario create(FuncionarioInternoForm form);

	Funcionario get(Long id);

	Funcionario update(FuncionarioInternoUpdateForm form, Long id);

	Set<Funcionario> getAll();

	Set<Registro> getRegistrosById(Long id);

	void delete(Long id);

}
