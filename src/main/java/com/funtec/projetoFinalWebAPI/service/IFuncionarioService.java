package com.funtec.projetoFinalWebAPI.service;

import java.util.Set;

import com.funtec.projetoFinalWebAPI.model.Funcionario;
import com.funtec.projetoFinalWebAPI.model.Registro;
import com.funtec.projetoFinalWebAPI.model.form.LoginForm;

public interface IFuncionarioService {

	Funcionario get(Long id);

	void delete(Long id);

	Set<Funcionario> getAll();

	Set<Registro> getRegistrosById(Long id);

	Funcionario login(LoginForm form);

}
