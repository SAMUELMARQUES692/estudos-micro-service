package com.br.app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


/**
 * Aluno DTO - o DTO é o espelho do tela, que é prenchida fora do banco de dados.
 */

@Data
public class AlunoDTO {

	@Schema(name= "id", description = "identificador do aluno", example = "123")
	private Integer id;
	
	@Schema(name= "nome", description = "nome do aluno", example = "samuel")
	private String nome;
	
	@Schema(name= "telefone", description = "telefone do aluno", example = "(11) 94949-3483")
	private String telefone;
	
	@Schema(name= "idade", description = "idade do aluno", example = "22")
	private Integer idade;
	
	@Schema(name= "endereco", description = "endereço do aluno", example = "Rua XTPO 123")
	private String endereco;
	
}
