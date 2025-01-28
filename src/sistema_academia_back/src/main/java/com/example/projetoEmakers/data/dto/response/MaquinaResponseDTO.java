package com.example.projetoEmakers.data.dto.response;

import com.example.projetoEmakers.data.entity.Maquina;

import java.util.Date;

public record MaquinaResponseDTO(Long idMaq,
                                   String nome,
                                   String categoria,
                                   int pesoMax) {

    public MaquinaResponseDTO(Maquina maquina) {
        this(maquina.getIdMaq(), maquina.getNome(), maquina.getCategoria(), maquina.getPesoMax());
    }
}