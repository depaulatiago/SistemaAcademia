package com.example.projetoEmakers.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Aluno {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idAluno;

        private String nome;

        private int peso;

        private int idade;

        private String genero;

    public Aluno(String nome, int peso, int idade, String genero) {
        this.nome = nome;
        this.peso = peso;
        this.idade = idade;
        this.genero = genero;
    }

    public Aluno() {

    }

}
