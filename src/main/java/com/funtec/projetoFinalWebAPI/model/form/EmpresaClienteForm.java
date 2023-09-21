package com.funtec.projetoFinalWebAPI.model.form;

import org.hibernate.validator.constraints.br.CNPJ;

import com.funtec.projetoFinalWebAPI.model.EstadosBrasileiros;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class EmpresaClienteForm {
	@NotEmpty(message = "Preencha o campo corretamente")
	private String nome;
	@NotEmpty(message = "Preencha o campo corretamente")
	//@CNPJ(message = "'${validatedValue}' é inválido!")
	private String cnpj;
	@NotEmpty(message = "Preencha o campo corretamente")
	private String endereco;
	@NotEmpty(message = "Preencha o campo corretamente")
	private String cidade;
	@NotEmpty(message = "Preencha o campo corretamente")
	private EstadosBrasileiros estado;

}
