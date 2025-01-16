package com.example.projetoEmakers.data.dto.response;

import com.example.projetoEmakers.data.entity.Instrutor;

public record InstrutorResponseDTO(Long idInst,
                                   String nome,
                                   int idade,
                                      double salario) {

    public InstrutorResponseDTO(Instrutor instrutor) {
        this(instrutor.getId(), instrutor.getNome(), instrutor.getIdade(), instrutor.getSalario());
    }
}
