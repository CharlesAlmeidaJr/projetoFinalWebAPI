package com.funtec.projetoFinalWebAPI.model.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class FrotaForm {

	@NotEmpty(message = "Preencha o campo corretamente.")
	private String nome;
	private Long idEmpresa;
}
