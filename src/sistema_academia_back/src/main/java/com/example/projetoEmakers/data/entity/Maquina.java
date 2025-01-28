package com.example.projetoEmakers.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
public class Maquina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaq;

    private String nome;

    private String categoria;

    private int pesoMax;



    // Construtor padrão
    public Maquina() {
    }

    // Construtor com argumentos
    public Maquina(String nome, String categoria, int pesoMax) {
        this.nome = nome;
        this.categoria = String.valueOf(categoria);
        this.pesoMax = pesoMax;
    }

}
