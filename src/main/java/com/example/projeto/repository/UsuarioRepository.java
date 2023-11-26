package com.example.projeto.repository;

import com.example.projeto.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Métodos específicos, se necessário
}