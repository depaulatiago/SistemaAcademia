package com.example.projetoEmakers.repository;

import com.example.projetoEmakers.data.dto.response.FichaResponseDTO;
import com.example.projetoEmakers.data.entity.Ficha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FichaRepository extends JpaRepository<Ficha, Long>{ @Query("SELECT new com.example.projetoEmakers.data.dto.response.FichaResponseDTO(" +
        "f.aluno.idAluno, f.aluno.nome, f.instrutor.idInst, f.instrutor.nome, " +
        "m.idMaq, m.nome, m.categoria) " +
        "FROM Ficha f JOIN f.maquinas m WHERE f.id = :id")
List<FichaResponseDTO> findFichaById(Long id);
}