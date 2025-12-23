package com.br.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


/*
 * Entity é o espelho do banco de dados, com as mesmas informações do banco.
 */

@Data
@Entity
@Table(name="tab_Aluno")
public class Entity_Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, length = 100)
	private Integer id;
	
	@Column(name="nome", nullable = false, length = 100)
	private String nome;
	
	@Column(name="telefone", nullable = false, length = 100)
	private String telefone;
	
	@Column(name="idade", length = 100)
	private Integer idade;
	
	@Column(name="endereco", nullable = false, length = 100)
	private String endereco;
	


}
