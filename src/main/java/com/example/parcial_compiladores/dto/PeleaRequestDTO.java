package com.example.parcial_compiladores.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * DTO para INICIAR una pelea.
 * Solo se necesitan los IDs de los dos peleadores y la fecha.
 * El ganador y los puntos los calcula el sistema.
 */
@Data
public class PeleaRequestDTO {
    @NotNull
    @Min(1)
    private Long peleaId;

    @NotNull(message = "El ID del peleador 1 es obligatorio")
    @Min(1)
    private Long peleador1Id;  // ID del primer peleador

    @NotNull(message = "El ID del peleador 2 es obligatorio")
    @Min(1)
    private Long peleador2Id;  // ID del segundo peleador

    @NotNull(message = "La fecha es obligatoria")
    @FutureOrPresent(message = "La fecha no puede ser en el pasado")
    private LocalDateTime fecha; // Fecha/hora de la pelea

    @AssertTrue(message = "Los peleadores deben ser diferentes")
    private boolean isPeleadoresValidos() {
        return peleador1Id != null && peleador2Id != null &&
                !peleador1Id.equals(peleador2Id);
    }
}
