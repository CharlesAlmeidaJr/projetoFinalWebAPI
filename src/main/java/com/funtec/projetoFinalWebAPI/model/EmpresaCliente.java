package com.funtec.projetoFinalWebAPI.model;

import java.util.Set;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "empresa_cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EmpresaCliente implements Comparable<EmpresaCliente>{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@Column(unique = true)
	private String cnpj;
	private String endereco;
	private String cidade;
	@Enumerated(EnumType.STRING)
	private EstadosBrasileiros estado;
	
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Funcionario> funcionarios;
	
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Frota> frotas;

	@Override
	public int compareTo(EmpresaCliente o) {
		return nome.compareTo(o.getNome());
	}

}
