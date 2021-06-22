package br.com.meli.bootcamp.estudohql.model.service;

import br.com.meli.bootcamp.estudohql.model.DTO.AlunoDTO;
import br.com.meli.bootcamp.estudohql.model.entity.Aluno;
import org.springframework.http.ResponseEntity;

public interface AlunoService {
    AlunoDTO findAlunoById(Long matricula);

    void createAluno(String nome);

    void updateAluno(AlunoDTO aluno);

    void deleteAlunoByMatricula(Long matricula);
}
