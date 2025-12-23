package com.br.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.app.dto.AlunoDTO;
import com.br.app.service.AlunoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.Getter;

@RestController
@Getter
@AllArgsConstructor
public class ClienteController {

	@Autowired
	private AlunoService alunoService;

	@GetMapping("/alunos")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = AlunoDTO.class))) }),
			@ApiResponse(responseCode = "204", description = "Sem conteudo", content = @Content),
			@ApiResponse(responseCode = "401", description = "Autênticação é obrigatória", content = @Content),
			@ApiResponse(responseCode = "403", description = "usuarioAcao é obrigatório", content = @Content),
			@ApiResponse(responseCode = "500", description = "Erro interno sem causa mapeada.", content = @Content),
			@ApiResponse(responseCode = "504", description = "Gateway Time-Out", content = @Content) })
	@Operation(summary = "busca todos os alunos", description = "")
	public AlunoDTO buscarTodosAluno() {

		return alunoService.buscarTodosAlunos();
	}

	@GetMapping("/aluno/id")
	@Operation(summary = "buscar aluno pelo Id", description = "")
	public AlunoDTO buscarIdAluno() {

		return alunoService.buscarTodosAlunos();
	}

}
