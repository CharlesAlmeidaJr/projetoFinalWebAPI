package com.funtec.projetoFinalWebAPI.service;

import java.util.Set;

import com.funtec.projetoFinalWebAPI.model.Frota;
import com.funtec.projetoFinalWebAPI.model.Registro;
import com.funtec.projetoFinalWebAPI.model.form.FrotaForm;
import com.funtec.projetoFinalWebAPI.model.form.FrotaUpdateForm;

public interface IFrotaService {

	Frota create (FrotaForm form);
	
	Frota get (Long id);
	
	Frota update (FrotaUpdateForm form, Long id);
	
	Set<Registro> getAllRegistro (Long id);
	
	void delete (Long id);

	Set<Registro> getAllRegistroByCategoria(Long id, String categoria);
}
