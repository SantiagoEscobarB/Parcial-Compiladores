package com.example.parcial_compiladores.dto;

import lombok.Data;

/**
 * DTO para REGISTRAR un nuevo usuario.
 * No incluye id, rol ni fechaRegistro — el sistema los asigna.
 */
@Data
public class UsuarioRequestDTO {

    private String username;  // Obligatorio, único
    private String email;     // Obligatorio, único
    private String password;  // Obligatorio (se encriptará en el service)
}
