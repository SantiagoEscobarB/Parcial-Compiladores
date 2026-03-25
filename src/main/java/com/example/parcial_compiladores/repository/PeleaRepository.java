package com.example.parcial_compiladores.repository;

import com.example.parcial_compiladores.model.Pelea;
import com.example.parcial_compiladores.model.Peleador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeleaRepository extends JpaRepository<Pelea, Long> {

    // Todas las peleas donde participó un peleador (como p1 o p2)
    List<Pelea> findByPeleador1(Peleador peleador1);
    List<Pelea> findByPeleador2(Peleador peleador2);

    // Todas las peleas que ganó un peleador
    List<Pelea> findByGanador(Peleador ganador);

    // Peleas entre dos peleadores específicos
    List<Pelea> findByPeleador1AndPeleador2(Peleador peleador1, Peleador peleador2);
}
