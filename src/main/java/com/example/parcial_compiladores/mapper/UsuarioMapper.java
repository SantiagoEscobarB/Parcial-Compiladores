package com.example.parcial_compiladores.mapper;

import com.example.parcial_compiladores.dto.UsuarioRequestDTO;
import com.example.parcial_compiladores.dto.UsuarioResponseDTO;
import com.example.parcial_compiladores.model.Usuario;

public class UsuarioMapper {
    public static UsuarioResponseDTO toResponseDTO(Usuario usuario) {
        if (usuario == null) return null;
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setId(usuario.getId());
        dto.setUsername(usuario.getUsername());
        dto.setEmail(usuario.getEmail());
        dto.setRol(usuario.getRol());
        dto.setFechaRegistro(usuario.getFechaRegistro());
        dto.setActivo(usuario.getActivo());
        return dto;
    }

    public static Usuario toEntity(UsuarioRequestDTO dto) {
        if (dto == null) return null;
        Usuario usuario = new Usuario();
        usuario.setUsername(dto.getUsername());
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(dto.getPassword());
        return usuario;
    }
}