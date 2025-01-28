package com.example.projetoEmakers.data.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;


public record MaquinaRequestDTO(
        @NotNull(message = "")
        int idMaq,

        @NotBlank(message = "")
        String nome,

        @NotBlank(message = "")
        String categoria,

        @NotNull(message = "")
        int pesoMax

) {


}
