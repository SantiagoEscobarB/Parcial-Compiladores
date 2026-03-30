package com.example.parcial_compiladores.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * DTO para REGISTRAR un nuevo usuario.
 * No incluye id, rol ni fechaRegistro — el sistema los asigna.
 */
@Data
public class UsuarioRequestDTO {
    @NotBlank(message = "El username es obligatorio")
    @Size(min = 3, max = 50, message = "Username: 3-50 caracteres")
    private String username;  // Obligatorio, único

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "Email inválido")
    private String email;     // Obligatorio, único

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 8, message = "Mínimo 8 caracteres")
    private String password;
}
