package com.funtec.projetoFinalWebAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.funtec.projetoFinalWebAPI.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	
	@Query(value = "SELECT * FROM funcionario WHERE cargo = %?1", nativeQuery = true)
	List<Funcionario> findAllByCargo(String cargo);
	
	@Query(value = "SELECT * FROM funcionario WHERE empresa_id is not NULL", nativeQuery = true)
	List<Funcionario> findAllFuncionarioCliente();
	
	@Query(value = "SELECT * FROM funcionario WHERE empresa_id is NULL", nativeQuery = true)
	List<Funcionario> findAllFuncionarioInterno();
	
	@Query(value = "SELECT * FROM funcionario WHERE login = %?1 AND senha = %?2", nativeQuery = true)
	Funcionario login(String login, String senha);

}
