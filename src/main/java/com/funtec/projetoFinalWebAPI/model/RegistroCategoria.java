package com.funtec.projetoFinalWebAPI.model;

public enum RegistroCategoria {
	
	NOVO_LAUDO("novo laudo"),
	PROBLEMA_ENCONTRADO("problema encontrado"),
	PROBLEMA_SOLUCIONADO("problema solucionado");
	
	public String value;
	
	private RegistroCategoria(String value) {
		this.value = value;
	}

}
