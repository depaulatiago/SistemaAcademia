package com.example.projetoEmakers.controller;

import com.example.projetoEmakers.data.entity.Aluno;
import com.example.projetoEmakers.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5500")
@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    // Listar todos os alunoes
    @GetMapping
    public List<Aluno> getAllAlunos() {
        return alunoRepository.findAll();
    }

    // Criar um novo aluno
    @PostMapping
    public Aluno createAluno(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    // Buscar um aluno pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getAlunoById(@PathVariable Long id) {
        return alunoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Atualizar um aluno
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable Long id, @RequestBody Aluno updatedAluno) {
        return alunoRepository.findById(id)
                .map(aluno -> {
                    aluno.setNome(updatedAluno.getNome());
                    aluno.setPeso(updatedAluno.getPeso());
                    aluno.setIdade(updatedAluno.getIdade());
                    aluno.setGenero(updatedAluno.getGenero());
                    return ResponseEntity.ok(alunoRepository.save(aluno));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Deletar um aluno
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAluno(@PathVariable Long id) {
        return alunoRepository.findById(id)
                .map(aluno -> {
                    alunoRepository.delete(aluno);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

