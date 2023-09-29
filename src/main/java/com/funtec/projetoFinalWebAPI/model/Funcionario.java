package com.funtec.projetoFinalWebAPI.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Funcionario implements Comparable<Funcionario>{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@Column(unique = true)
	private String login;
	private String senha;
	private String email;
	@Enumerated(EnumType.STRING)
	private FuncionarioInternoCargo cargo;
	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private EmpresaCliente empresa;
	private boolean ativo;
	
	@OneToMany(mappedBy = "funcionario", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	@JsonIgnore
	List<Registro> registros;

	@Override
	public int compareTo(Funcionario o) {
		return nome.compareTo(o.getNome());
	}

}
