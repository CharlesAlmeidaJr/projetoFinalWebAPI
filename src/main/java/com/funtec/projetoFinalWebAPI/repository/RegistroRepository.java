package com.funtec.projetoFinalWebAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.funtec.projetoFinalWebAPI.model.Registro;
import com.funtec.projetoFinalWebAPI.model.RegistroCategoria;

public interface RegistroRepository extends JpaRepository<Registro, Long> {
	
	List<Registro> findAllByCategoria(RegistroCategoria categoria);

}
