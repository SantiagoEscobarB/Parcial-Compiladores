package com.example.parcial_compiladores.repository;

import com.example.parcial_compiladores.model.Peleador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PeleadorRepository extends JpaRepository<Peleador, Long> {
    // Buscar por nombre exacto
    Optional<Peleador> findByNombre(String nombre);

    // Buscar por alias
    Optional<Peleador> findByAlias(String alias);

    // Listar solo los peleadores activos
    List<Peleador> findByActivoTrue();

    // Listar peleadores con más victorias que un número dado
    List<Peleador> findByVictoriasGreaterThanEqual(Integer victorias);
}
