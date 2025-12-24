package com.br.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.app.model.Entity_Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Entity_Aluno, Integer> {

	@Query(value="select id, nome, telefone, endereco, idade from tab_aluno where id= :id", nativeQuery = true )
	public Entity_Aluno buscarAlunoSql(@Param("id")Integer id);
	
}
