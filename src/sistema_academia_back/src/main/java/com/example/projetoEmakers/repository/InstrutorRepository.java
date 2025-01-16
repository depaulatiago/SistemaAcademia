package com.example.projetoEmakers.repository;

import com.example.projetoEmakers.data.entity.Instrutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrutorRepository extends JpaRepository<Instrutor, Long> {
}
