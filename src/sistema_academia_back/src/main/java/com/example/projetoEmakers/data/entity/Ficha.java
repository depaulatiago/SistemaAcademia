package com.example.projetoEmakers.data.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Ficha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idAluno", nullable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "idInstrutor", nullable = false)
    private Instrutor instrutor;

    @ManyToMany
    @JoinTable(
            name = "ficha_maquinas",
            joinColumns = @JoinColumn(name = "idFicha"),
            inverseJoinColumns = @JoinColumn(name = "idMaq")
    )
    private List<Maquina> maquinas;

    public Ficha() {
    }

    public Ficha(Aluno aluno, Instrutor instrutor, List<Maquina> maquinas) {
        this.aluno = aluno;
        this.instrutor = instrutor;
        this.maquinas = maquinas;
    }
}
