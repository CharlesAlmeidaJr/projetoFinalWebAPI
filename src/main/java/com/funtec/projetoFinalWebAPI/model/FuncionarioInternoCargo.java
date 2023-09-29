package com.funtec.projetoFinalWebAPI.model;

public enum FuncionarioInternoCargo {
	
	GERENCIA("gerencia"),
	MANUTENCAO("manutencao");

	public String value;
	
	private FuncionarioInternoCargo(String value) {
		this.value = value;
	}
	
}
