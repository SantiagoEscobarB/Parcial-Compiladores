package com.example.parcial_compiladores.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="peleadores")
@Data

public class Peleador {
    //Datos del peleador
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 100)
    private String alias;

    @Column(length = 500)
    private String biografia;

    @Column(name = "historia_fondo", length = 1000)
    private String historiaFondo;

    //Habilidades de pelea
    @Column(nullable = false)
    private Integer ataque;

    @Column(nullable = false)
    private Integer defensa;

    //Record de peleas
    @Column(nullable = false)
    private Integer victorias;

    @Column (nullable = false)
    private Integer derrotas;

    @Column (nullable = false)
    private Integer empates;

    @Column(nullable = false)
    private Boolean activo;
}
