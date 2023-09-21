package com.funtec.projetoFinalWebAPI.model.form;

import com.funtec.projetoFinalWebAPI.model.RegistroCategoria;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class RegistroUpdateForm {
	
	@NotEmpty(message = "Preencha o campo corretamente.")
	private String titulo;
	@NotEmpty(message = "Preencha o campo corretamente.")
	private String descricao;
	@NotEmpty(message = "Escolha um campo.")
	private RegistroCategoria registroCategoria;

}
