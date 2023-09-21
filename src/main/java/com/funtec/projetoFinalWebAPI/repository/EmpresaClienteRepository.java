package com.funtec.projetoFinalWebAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.funtec.projetoFinalWebAPI.model.EmpresaCliente;
import com.funtec.projetoFinalWebAPI.model.EstadosBrasileiros;
import com.funtec.projetoFinalWebAPI.model.Registro;

public interface EmpresaClienteRepository extends JpaRepository<EmpresaCliente, Long>{
	List<EmpresaCliente> findByEstado(EstadosBrasileiros estado);
	
	@Query(value = "SELECT * FROM registro WHERE (SELECT empresa_id FROM frota) = %?1", nativeQuery = true)
	List<Registro> findAllRegistro(Long id);
	
	@Query(value = "SELECT * FROM registro WHERE (SELECT empresa_id FROM frota) = %?1 AND categoria = %?2", nativeQuery = true)
	List<Registro> findAllRegistroByCategoria(Long id, String categoria);
}
