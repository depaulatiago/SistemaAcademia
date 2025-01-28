package com.example.projetoEmakers.controller;

import com.example.projetoEmakers.data.entity.Maquina;
import com.example.projetoEmakers.repository.MaquinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5500")
@RestController
@RequestMapping("/maquina")
public class MaquinaController {

    @Autowired
    private MaquinaRepository maquinaRepository;

    // Listar todos os maquinaes
    @GetMapping
    public List<Maquina> getAllMaquinas() {
        return maquinaRepository.findAll();
    }

    // Criar um novo maquina
    @PostMapping
    public Maquina createMaquina(@RequestBody Maquina maquina) {
        return maquinaRepository.save(maquina);
    }

    // Buscar um maquina pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Maquina> getMaquinaById(@PathVariable Long id) {
        return maquinaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Atualizar um maquina
    @PutMapping("/{id}")
    public ResponseEntity<Maquina> updateMaquina(@PathVariable Long id, @RequestBody Maquina updatedMaquina) {
        return maquinaRepository.findById(id)
                .map(maquina -> {
                    maquina.setNome(updatedMaquina.getNome());
                    maquina.setCategoria(updatedMaquina.getCategoria());
                    maquina.setPesoMax(updatedMaquina.getPesoMax());
                    return ResponseEntity.ok(maquinaRepository.save(maquina));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Deletar um maquina
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMaquina(@PathVariable Long id) {
        return maquinaRepository.findById(id)
                .map(maquina -> {
                    maquinaRepository.delete(maquina);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

