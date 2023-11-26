package com.example.projeto.repository;

import com.example.projeto.models.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VagaRepository extends JpaRepository<Vaga, Long> {
    // Adicione métodos adicionais conforme necessário
}