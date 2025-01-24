package com.example.projetoEmakers.data.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record AlunoRequestDTO(
        @NotNull(message = "")
        int idAluno,

        @NotBlank(message = "")
        String nome,

        @NotBlank(message = "")
        int peso,

        @NotNull(message = "")
        int idade,

        @NotNull(message = "")
        String genero

) {
}

