package com.example.parcial_compiladores.dto;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * DTO para INICIAR una pelea.
 * Solo se necesitan los IDs de los dos peleadores y la fecha.
 * El ganador y los puntos los calcula el sistema.
 */
@Data
public class PeleaRequestDTO {

    private Long peleador1Id;  // ID del primer peleador
    private Long peleador2Id;  // ID del segundo peleador
    private LocalDateTime fecha; // Fecha/hora de la pelea
}
