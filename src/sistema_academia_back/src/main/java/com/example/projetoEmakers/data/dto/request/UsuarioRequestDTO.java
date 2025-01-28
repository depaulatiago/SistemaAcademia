package com.example.projetoEmakers.data.dto.request;

import jakarta.validation.constraints.NotNull;

public record UsuarioRequestDTO(

        @NotNull(message = "")
        int idUsuario,

        @NotNull(message = "")
        String nome,

        @NotNull(message = "")
        String email
) {
}
