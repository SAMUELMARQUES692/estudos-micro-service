package com.br.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.app.dto.AlunoDTO;
import com.br.app.service.AlunoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
@RequestMapping("aluno")
public class ClienteController {

	@Autowired
	private AlunoService alunoService;
	
	@PostMapping("/criar")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Sucesso", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = AlunoDTO.class))) }),
			@ApiResponse(responseCode = "401", description = "Autênticação é obrigatória", content = @Content),
			@ApiResponse(responseCode = "403", description = "usuarioAcao é obrigatório", content = @Content),
			@ApiResponse(responseCode = "500", description = "Erro interno sem causa mapeada.", content = @Content),
			@ApiResponse(responseCode = "504", description = "Gateway Time-Out", content = @Content) })
	@Operation(summary = "inserir usuario", description = "")
	
	public ResponseEntity<AlunoDTO>criarAluno(AlunoDTO dto) {

		return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.criarAluno(dto));
	}
	

	@GetMapping("/buscar")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = AlunoDTO.class))) }),
			@ApiResponse(responseCode = "204", description = "Sem conteudo", content = @Content),
			@ApiResponse(responseCode = "401", description = "Autênticação é obrigatória", content = @Content),
			@ApiResponse(responseCode = "403", description = "usuarioAcao é obrigatório", content = @Content),
			@ApiResponse(responseCode = "500", description = "Erro interno sem causa mapeada.", content = @Content),
			@ApiResponse(responseCode = "504", description = "Gateway Time-Out", content = @Content) })
	@Operation(summary = "busca todos os alunos", description = "")
	public ResponseEntity<java.util.List<AlunoDTO>> buscarTodosAluno() {

		return ResponseEntity.status(HttpStatus.OK).body(alunoService.buscarTodosAlunos());
	}

	
	@GetMapping("/aluno/id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = AlunoDTO.class))) }),
			@ApiResponse(responseCode = "204", description = "Sem conteudo", content = @Content),
			@ApiResponse(responseCode = "401", description = "Autênticação é obrigatória", content = @Content),
			@ApiResponse(responseCode = "403", description = "usuarioAcao é obrigatório", content = @Content),
			@ApiResponse(responseCode = "500", description = "Erro interno sem causa mapeada.", content = @Content),
			@ApiResponse(responseCode = "504", description = "Gateway Time-Out", content = @Content) })
	@Operation(summary = "buscar aluno pelo Id", description = "")
	public ResponseEntity<AlunoDTO> buscarIdAluno(@Parameter(name = "id", description = "Numero identificador do aluno", example = "1") 
									@RequestParam(value = "id",required = true) Integer Id) {

		return ResponseEntity.status(HttpStatus.OK).body(alunoService.buscarAlunoId(Id));
	}

	
	
	
}
