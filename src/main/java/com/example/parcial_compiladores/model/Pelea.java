package com.example.parcial_compiladores.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name="Peleas")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Pelea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne //Un peleador puede estar en muchas peleas
    @JoinColumn (name = "peleador1_id", nullable=false)
    private Peleador peleador1;

    @ManyToOne
    @JoinColumn (name = "peleador2_id", nullable = false)
    private Peleador peleador2;

    @ManyToOne //Un peleador puede ganar muchas peleas
    @JoinColumn (name = "ganador")
    private Peleador ganador;

    @Column (name = "puntos_p1")
    private Integer puntosPeleador1;

    @Column (name = "puntos_p2")
    private Integer puntosPeleador2;

    @Column(nullable = false)
    private LocalDateTime fecha;
}
