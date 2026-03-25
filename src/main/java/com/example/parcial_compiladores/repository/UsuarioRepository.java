package com.example.parcial_compiladores.repository;

import com.example.parcial_compiladores.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Buscar por username (para login)
    Optional<Usuario> findByUsername(String username);

    // Buscar por email (para validar duplicados)
    Optional<Usuario> findByEmail(String email);

    // Verificar si ya existe un username o email
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    // Listar usuarios por rol
    List<Usuario> findByRol(String rol);

    // Solo usuarios activos
    List<Usuario> findByActivoTrue();
}
