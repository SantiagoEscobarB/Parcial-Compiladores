package com.example.parcial_compiladores.dto;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * DTO para RETORNAR el resultado de una pelea.
 * Usa PeleadorResponseDTO anidado para mostrar info de cada peleador.
 */
@Data
public class PeleaResponseDTO {

    private Long id;
    private PeleadorResponseDTO peleador1;
    private PeleadorResponseDTO peleador2;
    private PeleadorResponseDTO ganador;  // null si empate
    private Integer puntosPeleador1;
    private Integer puntosPeleador2;
    private LocalDateTime fecha;
}
