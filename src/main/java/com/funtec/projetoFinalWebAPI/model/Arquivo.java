package com.funtec.projetoFinalWebAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Arquivo implements Comparable<Arquivo>{
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String caminhoArquivo;
	@ManyToOne
	@JoinColumn(name = "registro_id")
	private Registro registro;
	
	@Override
	public int compareTo(Arquivo o) {
		return nome.compareTo(o.getNome());
	}

}
