package com.funtec.projetoFinalWebAPI.model;

import java.time.LocalDateTime;
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
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Registro implements Comparable<Registro>{
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "id_funcionario")
	private Funcionario funcionario;
	private String titulo;
	private String descricao;
	@ManyToOne
	@JoinColumn(name = "frota_id")
	private Frota frota;
	@Column(name = "data_resgistro")
	private LocalDateTime dataResgistro = LocalDateTime.now();
	@Enumerated(EnumType.STRING)
	private RegistroCategoria categoria;
	
	@OneToMany(mappedBy = "registro", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Arquivo> arquivos;

	@Override
	public int compareTo(Registro o) {
		return dataResgistro.compareTo(o.getDataResgistro());
	}

}
