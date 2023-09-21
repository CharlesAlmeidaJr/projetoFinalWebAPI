package com.funtec.projetoFinalWebAPI.service;

import java.util.Set;

import com.funtec.projetoFinalWebAPI.model.Arquivo;
import com.funtec.projetoFinalWebAPI.model.Registro;
import com.funtec.projetoFinalWebAPI.model.form.RegistroForm;
import com.funtec.projetoFinalWebAPI.model.form.RegistroUpdateForm;

public interface IRegistroService {

	Registro create (RegistroForm form);
	
	Registro get (Long id);
	
	Registro update (RegistroUpdateForm form, Long id);
	
	Set<Registro> getAll();
	
	Set<Arquivo> getAllArquivo (Long id);
	
	void delete (Long id);

	Set<Registro> getAllByCategoria(String categoria);
}
