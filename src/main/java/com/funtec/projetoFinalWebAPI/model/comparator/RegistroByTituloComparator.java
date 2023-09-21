package com.funtec.projetoFinalWebAPI.model.comparator;

import java.util.Comparator;

import com.funtec.projetoFinalWebAPI.model.Registro;

public class RegistroByTituloComparator implements Comparator<Registro>{

	@Override
	public int compare(Registro o1, Registro o2) {
		return o1.getTitulo().compareTo(o2.getTitulo());
	}

}
