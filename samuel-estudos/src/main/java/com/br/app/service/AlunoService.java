package com.br.app.service;

import org.springframework.stereotype.Service;

import com.br.app.dto.AlunoDTO;

@Service
public class AlunoService {

	public AlunoDTO buscarTodosAlunos() {
		
		AlunoDTO dto = new AlunoDTO();
		dto.setId(3);
		dto.setNome("Eduardo");
		dto.setEndereco("Rua teste 123");
		dto.setIdade(22);
		dto.setTelefone("11 890880808");
		
		return dto;
	}
	
}
