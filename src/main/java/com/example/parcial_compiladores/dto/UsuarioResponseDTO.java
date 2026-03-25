package com.example.parcial_compiladores.dto;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * DTO para RETORNAR datos de un usuario.
 * NUNCA incluye password.
 */
@Data
public class UsuarioResponseDTO {

    private Long id;
    private String username;
    private String email;
    private String rol;
    private LocalDateTime fechaRegistro;
    private Boolean activo;
}
