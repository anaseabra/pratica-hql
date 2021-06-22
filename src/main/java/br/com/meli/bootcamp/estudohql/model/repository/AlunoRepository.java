package br.com.meli.bootcamp.estudohql.model.repository;

import br.com.meli.bootcamp.estudohql.model.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Aluno (nome) VALUES (:nome)", nativeQuery = true)
    void createAluno (@Param("nome") String nome);

    @Query("SELECT a FROM Aluno a WHERE a.matricula = :matricula")
    Aluno findAlunoByMatricula(@Param("matricula") Long matricula);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Aluno a WHERE a.matricula = :matricula", nativeQuery = true)
    void deleteAlunoByMatricula(@Param("matricula") Long matricula);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Aluno a SET a.nome = :nome WHERE a.matricula = :matricula", nativeQuery = true)
    void updateAluno(@Param("matricula") Long matricula, @Param("nome") String nome);

}
