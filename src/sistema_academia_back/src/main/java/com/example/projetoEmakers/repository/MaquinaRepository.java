package com.example.projetoEmakers.repository;

import com.example.projetoEmakers.data.entity.Maquina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaquinaRepository extends JpaRepository<Maquina, Long> {
}
