package com.example.projeto.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.projeto.models.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    // Adicione métodos adicionais conforme necessário
}