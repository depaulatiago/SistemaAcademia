package com.example.projetoEmakers.controller;

import com.example.projetoEmakers.data.dto.request.FichaRequestDTO;
import com.example.projetoEmakers.data.dto.response.FichaResponseDTO;
import com.example.projetoEmakers.data.entity.Ficha;
import com.example.projetoEmakers.service.FichaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5500")
@RestController
@RequestMapping("/ficha")
public class FichaController {
    @Autowired
    private FichaService fichaService;

    @PostMapping
    public ResponseEntity<Ficha> criarFicha(@RequestBody FichaRequestDTO requestDTO) {
        Ficha ficha = fichaService.criarFicha(requestDTO);
        return ResponseEntity.ok(ficha);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<FichaResponseDTO>> consultarFicha(@PathVariable Long id) {
        return ResponseEntity.ok(Collections.singletonList(fichaService.consultarFicha(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ficha> atualizarFicha(@PathVariable Long id, @RequestBody FichaRequestDTO requestDTO) {
        Ficha fichaAtualizada = fichaService.atualizarFicha(id, requestDTO);
        return ResponseEntity.ok(fichaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFicha(@PathVariable Long id) {
        fichaService.deletarFicha(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Ficha>> listarTodasAsFichas() {
        List<Ficha> fichas = fichaService.listarTodasAsFichas();
        return ResponseEntity.ok(fichas);
    }
}
