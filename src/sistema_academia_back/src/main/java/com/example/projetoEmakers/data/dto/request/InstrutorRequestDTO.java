package com.example.projetoEmakers.data.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InstrutorRequestDTO(
        @NotNull(message = "O id do livro não pode ser nulo")
        int idInst,

        @NotBlank(message = "O nome do livro não pode ser nulo")
        String nome,

        @NotBlank(message = "O  do livro não pode ser nulo")
        int idade,

        @NotNull(message = "A data de lançamento do livro não pode ser nula")
        double salario

) {


}
