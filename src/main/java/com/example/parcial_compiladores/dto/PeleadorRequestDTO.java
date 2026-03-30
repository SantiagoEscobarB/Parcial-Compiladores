package com.example.parcial_compiladores.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

/**
 * DTO para CREAR o ACTUALIZAR un peleador.
 * No incluye id ni record de peleas (victorias/derrotas/empates),
 * esos los maneja el sistema internamente.
 */
@Data
public class PeleadorRequestDTO {
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 100)
    private String nombre;

    private String alias;        // Opcional
    private String biografia;    // Opcional
    private String historiaFondo; // Opcional

    @NotNull(message = "El ataque es obligatorio")
    @Min(value = 1, message = "El ataque debe ser >= 1")
    @Max(value = 100, message = "El ataque debe ser <= 100")
    private Integer ataque;      // Obligatorio

    @NotNull(message = "La defensa es obligatoria")
    @Min(value = 1)
    @Max(value = 100)
    private Integer defensa;

    @NotNull(message = "El estado activo es obligatorio")
    private Boolean activo;      // Obligatorio
}
