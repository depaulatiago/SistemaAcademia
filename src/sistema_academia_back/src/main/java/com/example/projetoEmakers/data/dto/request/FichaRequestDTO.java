package com.example.projetoEmakers.data.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public record FichaRequestDTO(

        Long idAluno,

        Long idInstrutor,

        List<Long> idsMaquinas
) {
}
