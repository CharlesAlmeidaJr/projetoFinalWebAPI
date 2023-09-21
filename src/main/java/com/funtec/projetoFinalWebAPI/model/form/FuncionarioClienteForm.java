package com.funtec.projetoFinalWebAPI.model.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class FuncionarioClienteForm {
	
	@NotEmpty(message = "Preencha o campo corretamente.")
	private String nome;
	@Size(min = 5, message = "O login deve ter pelo menos 5 caracteres")
	@NotEmpty(message = "Preencha o campo corretamente.")
	private String login;
	@NotEmpty(message = "Preencha o campo corretamente.")
	private String senha;
	//@Email(message = "'${validatedValue}' é inválido!")
	@NotEmpty(message = "Preencha o campo corretamente.")
	private String email;
	private Long idEmpresa;

}
