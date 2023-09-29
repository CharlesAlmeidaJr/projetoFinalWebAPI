package com.funtec.projetoFinalWebAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.funtec.projetoFinalWebAPI.model.EmpresaCliente;
import com.funtec.projetoFinalWebAPI.model.EstadosBrasileiros;

public interface EmpresaClienteRepository extends JpaRepository<EmpresaCliente, Long>{
	List<EmpresaCliente> findByEstado(EstadosBrasileiros estado);
}
