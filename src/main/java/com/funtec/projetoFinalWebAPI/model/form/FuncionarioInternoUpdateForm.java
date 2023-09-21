package com.funtec.projetoFinalWebAPI.model.form;

import com.funtec.projetoFinalWebAPI.model.FuncionarioInternoCargo;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class FuncionarioInternoUpdateForm {

	private String nome;
	private String senha;
//	@Email(message = "'${validatedValue}' é inválido!")
	private String email;
	private FuncionarioInternoCargo cargo;
	private boolean ativo;
	
}
