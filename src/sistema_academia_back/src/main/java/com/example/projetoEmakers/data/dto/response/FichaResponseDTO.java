package com.example.projetoEmakers.data.dto.response;

import com.example.projetoEmakers.data.entity.Ficha;

import java.util.List;

public record FichaResponseDTO(
        Long idAluno,
        String nomeAluno,
        Long idInst,
        String nomeInst,
        List<Long> idsMaquinas,
        List<String> nomesMaquinas,
        List<String> categoriasMaquinas
) {
    public FichaResponseDTO(Ficha ficha) {
        this(ficha.getAluno().getIdAluno(),
                ficha.getAluno().getNome(),
                ficha.getInstrutor().getIdInst(),
                ficha.getInstrutor().getNome(),
                ficha.getMaquinas().stream().map(m -> m.getIdMaq()).toList(),
                ficha.getMaquinas().stream().map(m -> m.getNome()).toList(),
                ficha.getMaquinas().stream().map(m -> m.getCategoria()).toList());
    }
}
