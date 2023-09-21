package com.funtec.projetoFinalWebAPI.model;

public enum FuncionarioInternoCargo {
	
	GERENCIA("gerencia"),
	MANUTENCAO("manutencao");

	private String value;
	
	private FuncionarioInternoCargo(String value) {
		this.value = value;
	}
	
	public String getCargo() {
		return value;
	}
	
}
