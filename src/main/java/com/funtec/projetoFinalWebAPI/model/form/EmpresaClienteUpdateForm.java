package com.funtec.projetoFinalWebAPI.model.form;

import com.funtec.projetoFinalWebAPI.model.EstadosBrasileiros;

import jakarta.validation.constraints.NotEmpty;	
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class EmpresaClienteUpdateForm {
	
	private String nome;
	private String endereco;
	private String cidade;
	private EstadosBrasileiros estado;

}
