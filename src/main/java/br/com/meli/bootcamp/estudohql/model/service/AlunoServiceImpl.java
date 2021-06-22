package br.com.meli.bootcamp.estudohql.model.service;

import br.com.meli.bootcamp.estudohql.model.DTO.AlunoDTO;
import br.com.meli.bootcamp.estudohql.model.entity.Aluno;
import br.com.meli.bootcamp.estudohql.model.repository.AlunoRepository;
import org.springframework.stereotype.Service;

@Service
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoServiceImpl(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Override
    public AlunoDTO findAlunoById(Long matricula) {
        Aluno aluno = alunoRepository.findAlunoByMatricula(matricula);
        return new AlunoDTO(aluno.getMatricula(), aluno.getNome());
    }

    @Override
    public void createAluno(String nome) {
        alunoRepository.createAluno(nome);
    }

    @Override
    public void updateAluno(AlunoDTO alunoDTO) {
        alunoRepository.updateAluno(alunoDTO.getMatricula(), alunoDTO.getNome());
    }

    @Override
    public void deleteAlunoByMatricula(Long matricula) {
        alunoRepository.deleteAlunoByMatricula(matricula);
    }
}
