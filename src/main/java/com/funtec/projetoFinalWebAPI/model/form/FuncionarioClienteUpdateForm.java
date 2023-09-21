package com.funtec.projetoFinalWebAPI.model.form;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class FuncionarioClienteUpdateForm {
	
	private String nome;
	private String senha;
//	@Email(message = "'${validatedValue}' é inválido!")
	private String email;
	private boolean ativo;

}
