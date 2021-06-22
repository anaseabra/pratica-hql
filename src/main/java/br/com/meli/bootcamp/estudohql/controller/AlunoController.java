package br.com.meli.bootcamp.estudohql.controller;


import br.com.meli.bootcamp.estudohql.model.DTO.AlunoDTO;
import br.com.meli.bootcamp.estudohql.model.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<AlunoDTO> findAlunoByMatricula(@PathVariable Long matricula) {
        return new ResponseEntity<>(alunoService.findAlunoById(matricula), HttpStatus.OK);
    }

    @PostMapping("/new/{nome}")
    public ResponseEntity<String> createAluno(@PathVariable String nome) {
        alunoService.createAluno(nome);
        return new ResponseEntity<>("Aluno criado!", HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateAlunoByMatricula (@RequestBody AlunoDTO alunoDTO) {
        alunoService.updateAluno(alunoDTO);
        return new ResponseEntity<>("Aluno atualizado", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{matricula}")
    public ResponseEntity<String> deleteAlunoByMatricula (@PathVariable Long matricula) {
        alunoService.deleteAlunoByMatricula(matricula);
        return new ResponseEntity<>("Aluno excluído com sucesso", HttpStatus.OK);
    }

}
