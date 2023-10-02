package com.funtec.projetoFinalWebAPI.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.funtec.projetoFinalWebAPI.model.Arquivo;
import com.funtec.projetoFinalWebAPI.model.form.ArquivoForm;
import com.funtec.projetoFinalWebAPI.model.form.ArquivoUpdateForm;

public interface IArquivoService {

	Arquivo create(MultipartFile file, Long idRegistro) throws IOException;

//	Arquivo update(ArquivoUpdateForm form, Long id);

	Arquivo get(Long id);

	void delete(Long id);

}
