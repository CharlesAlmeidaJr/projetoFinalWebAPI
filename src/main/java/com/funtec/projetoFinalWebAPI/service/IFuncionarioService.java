package com.funtec.projetoFinalWebAPI.service;

import java.util.Set;

import com.funtec.projetoFinalWebAPI.model.Funcionario;
import com.funtec.projetoFinalWebAPI.model.Registro;

public interface IFuncionarioService {

	Funcionario get(Long id);

	void delete(Long id);

	Set<Funcionario> getAll();

	Set<Registro> getRegistrosById(Long id);

}
