package com.funtec.projetoFinalWebAPI.model.comparator;

import java.util.Comparator;

import com.funtec.projetoFinalWebAPI.model.Funcionario;

public class FuncionarioByLoginComparator implements Comparator<Funcionario>{

	@Override
	public int compare(Funcionario o1, Funcionario o2) {
		return o1.getLogin().compareTo(o2.getLogin());
	}

}
