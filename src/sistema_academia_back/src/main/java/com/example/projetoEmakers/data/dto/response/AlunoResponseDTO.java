package com.example.projetoEmakers.data.dto.response;

import com.example.projetoEmakers.data.entity.Aluno;

import java.util.Date;

public record AlunoResponseDTO(Long idMaq,
                                 String nome,
                                 int peso,
                                 int idade,
                                 String genero) {

    public AlunoResponseDTO(Aluno aluno) {
        this(aluno.getIdAluno(), aluno.getNome(), aluno.getPeso(), aluno.getIdade(), aluno.getGenero());
    }
}