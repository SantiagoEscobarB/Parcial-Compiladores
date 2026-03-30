package com.example.parcial_compiladores.controller;

import com.example.parcial_compiladores.dto.UsuarioRequestDTO;
import com.example.parcial_compiladores.dto.UsuarioResponseDTO;
import com.example.parcial_compiladores.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registro")
    public UsuarioResponseDTO registrar(@Valid @RequestBody UsuarioRequestDTO dto) {
        return usuarioService.guardar(dto);
    }

    @GetMapping("/{id}")
    public UsuarioResponseDTO obtenerPerfil(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
    }
}