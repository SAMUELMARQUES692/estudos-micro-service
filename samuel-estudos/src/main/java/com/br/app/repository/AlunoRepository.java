package com.br.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.app.model.Entity_Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Entity_Aluno, Integer> {

	
	
	
}
