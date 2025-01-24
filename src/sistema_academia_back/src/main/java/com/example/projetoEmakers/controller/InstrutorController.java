package com.example.projetoEmakers.controller;

import com.example.projetoEmakers.data.entity.Instrutor;
import com.example.projetoEmakers.repository.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5500")
@RestController
@RequestMapping("/instrutor")
public class InstrutorController {

    @Autowired
    private InstrutorRepository instrutorRepository;

    // Listar todos os instrutores
    @GetMapping
    public List<Instrutor> getAllInstrutores() {
        return instrutorRepository.findAll();
    }

    // Criar um novo instrutor
    @PostMapping
    public Instrutor createInstrutor(@RequestBody Instrutor instrutor) {
        return instrutorRepository.save(instrutor);
    }

    // Buscar um instrutor pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Instrutor> getInstrutorById(@PathVariable Long id) {
        return instrutorRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Atualizar um instrutor
    @PutMapping("/{id}")
    public ResponseEntity<Instrutor> updateInstrutor(@PathVariable Long id, @RequestBody Instrutor updatedInstrutor) {
        return instrutorRepository.findById(id)
                .map(instrutor -> {
                    instrutor.setNome(updatedInstrutor.getNome());
                    instrutor.setIdade(updatedInstrutor.getIdade());
                    instrutor.setSalario(updatedInstrutor.getSalario());
                    return ResponseEntity.ok(instrutorRepository.save(instrutor));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Deletar um instrutor
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteInstrutor(@PathVariable Long id) {
        return instrutorRepository.findById(id)
                .map(instrutor -> {
                    instrutorRepository.delete(instrutor);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

