package com.example.parcial_compiladores.dto;

import lombok.Data;

/**
 * DTO para CREAR o ACTUALIZAR un peleador.
 * No incluye id ni record de peleas (victorias/derrotas/empates),
 * esos los maneja el sistema internamente.
 */
@Data
public class PeleadorRequestDTO {

    private String nombre;       // Obligatorio
    private String alias;        // Opcional
    private String biografia;    // Opcional
    private String historiaFondo; // Opcional
    private Integer ataque;      // Obligatorio
    private Integer defensa;     // Obligatorio
    private Boolean activo;      // Obligatorio
}
