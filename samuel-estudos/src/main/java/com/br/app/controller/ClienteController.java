package com.br.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.app.dto.AlunoDTO;
import com.br.app.service.AlunoService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.Getter;

@RestController
@Getter
@AllArgsConstructor
public class ClienteController {

	@Autowired
	private AlunoService alunoService;
	
	@GetMapping
	@Operation(summary = "busca todos os alunos", description = "")
	public AlunoDTO buscarTodosAluno() {
		
		return alunoService.buscarTodosAlunos();
	}
	

}
