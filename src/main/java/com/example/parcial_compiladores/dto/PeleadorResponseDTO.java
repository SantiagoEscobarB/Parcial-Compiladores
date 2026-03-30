package com.example.parcial_compiladores.dto;

import lombok.Data;

/**
 * DTO para RETORNAR datos de un peleador al cliente.
 * Incluye id y record completo de peleas.
 */
@Data
public class PeleadorResponseDTO {
    private Long id;
    private String nombre;
    private String alias;
    private String biografia;
    private String historiaFondo;
    private Integer ataque;
    private Integer defensa;
    private Integer victorias;
    private Integer derrotas;
    private Integer empates;
    private Boolean activo;
}
