package com.funtec.projetoFinalWebAPI.service;

import com.funtec.projetoFinalWebAPI.model.Arquivo;
import com.funtec.projetoFinalWebAPI.model.form.ArquivoForm;
import com.funtec.projetoFinalWebAPI.model.form.ArquivoUpdateForm;

public interface IArquivoService {

	Arquivo create(ArquivoForm form);

	Arquivo update(ArquivoUpdateForm form, Long id);

	Arquivo get(Long id);

	void delete(Long id);

}
