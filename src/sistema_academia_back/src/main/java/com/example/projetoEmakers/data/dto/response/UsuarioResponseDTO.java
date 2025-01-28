package com.example.projetoEmakers.data.dto.response;

import com.example.projetoEmakers.data.entity.Usuario;

public record UsuarioResponseDTO(int idUsuario,
                                String email,
                                String senha) {

    public UsuarioResponseDTO(Usuario usuario) {
        this(usuario.getIdUsuario(), usuario.getEmail(), usuario.getSenha());
    }
}
