package com.br.app.service;

import java.awt.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.app.dto.AlunoDTO;
import com.br.app.model.Entity_Aluno;
import com.br.app.repository.AlunoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	public void excluirAluno(Integer Id) throws Exception {
		log.info("Iniciando o metodo buscar Id");
		
		if(this.buscarAlunoId(Id) == null) {
			throw new Exception("Id do usuario não existe");
		}
		
		alunoRepository.deleteById(Id);
	}

	public AlunoDTO buscarAlunoId(Integer Id) {
		log.info("Iniciando o metodo buscar Id");
		Optional<Entity_Aluno> opt = alunoRepository.findById(Id);

		if (opt.isPresent()) {

			Entity_Aluno entity = opt.get();
			AlunoDTO alunoDto = new AlunoDTO();
			alunoDto.setId(entity.getId());
			alunoDto.setNome(entity.getNome());
			alunoDto.setEndereco(entity.getEndereco());
			alunoDto.setIdade(entity.getIdade());
			alunoDto.setTelefone(entity.getTelefone());
			log.info("ID aluno {} ", entity.getId());
			return alunoDto;
		}
		return null;
	}

	public java.util.List<AlunoDTO> buscarTodosAlunos() {

		java.util.List<Entity_Aluno> listaAlunos = alunoRepository.findAll();
		java.util.List<AlunoDTO> listaAlunosDTO = new ArrayList<>();

		for (Entity_Aluno entity : listaAlunos) {

			AlunoDTO alunoDto = new AlunoDTO();
			alunoDto.setId(entity.getId());
			alunoDto.setNome(entity.getNome());
			alunoDto.setEndereco(entity.getEndereco());
			alunoDto.setIdade(entity.getIdade());
			alunoDto.setTelefone(entity.getTelefone());

			listaAlunosDTO.add(alunoDto);
		}

		return listaAlunosDTO;
	}

	public AlunoDTO criarAluno(AlunoDTO dto) {

		Entity_Aluno entity = new Entity_Aluno();
		entity.setNome(dto.getNome());
		entity.setEndereco(dto.getEndereco());
		entity.setIdade(dto.getIdade());
		entity.setTelefone(dto.getTelefone());

		Entity_Aluno bd = alunoRepository.save(entity);

		AlunoDTO alunoDto = new AlunoDTO();
		alunoDto.setId(bd.getId());
		alunoDto.setNome(bd.getNome());
		alunoDto.setEndereco(bd.getEndereco());
		alunoDto.setIdade(bd.getIdade());
		alunoDto.setTelefone(bd.getTelefone());

		return alunoDto;
	}

	public AlunoDTO atualizarAluno(AlunoDTO dto) {

		Entity_Aluno entity = new Entity_Aluno();
		entity.setId(dto.getId());
		entity.setNome(dto.getNome());
		entity.setEndereco(dto.getEndereco());
		entity.setIdade(dto.getIdade());
		entity.setTelefone(dto.getTelefone());

		Entity_Aluno bd = alunoRepository.save(entity);

		AlunoDTO alunoDto = new AlunoDTO();
		alunoDto.setId(bd.getId());
		alunoDto.setNome(bd.getNome());
		alunoDto.setEndereco(bd.getEndereco());
		alunoDto.setIdade(bd.getIdade());
		alunoDto.setTelefone(bd.getTelefone());

		return alunoDto;
	}

	public AlunoDTO buscarSqlAlunoId(Integer Id) {
		log.info("Iniciando o metodo buscar Id");
		 Entity_Aluno entity = alunoRepository.buscarAlunoSql(Id);
		 AlunoDTO alunoDto = new AlunoDTO();
			alunoDto.setId(entity.getId());
			alunoDto.setNome(entity.getNome());
			alunoDto.setEndereco(entity.getEndereco());
			alunoDto.setIdade(entity.getIdade());
			alunoDto.setTelefone(entity.getTelefone());
			
		 return alunoDto;
	}
	
}
