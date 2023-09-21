package com.funtec.projetoFinalWebAPI.model.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class FrotaUpdateForm {
	
	@NotEmpty(message = "Preencha o campo corretamente.")
	private String nome;

}
