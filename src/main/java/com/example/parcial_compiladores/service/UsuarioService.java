package com.example.parcial_compiladores.service;

import com.example.parcial_compiladores.dto.UsuarioRequestDTO;
import com.example.parcial_compiladores.dto.UsuarioResponseDTO;
import com.example.parcial_compiladores.mapper.UsuarioMapper;
import com.example.parcial_compiladores.model.Usuario;
import com.example.parcial_compiladores.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioResponseDTO guardar(UsuarioRequestDTO dto) {
        if(usuarioRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("El email ya está en uso");
        }

        Usuario usuario = UsuarioMapper.toEntity(dto);
        Usuario guardado = usuarioRepository.save(usuario);
        return UsuarioMapper.toResponseDTO(guardado);
    }

    public List<UsuarioResponseDTO> listar() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioMapper::toResponseDTO)
                .toList();
    }

    public UsuarioResponseDTO buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .map(UsuarioMapper::toResponseDTO)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
    }

    public UsuarioResponseDTO actualizar(Long id, UsuarioRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Solo actualizamos lo que viene en el RequestDTO
        usuario.setUsername(dto.getUsername());
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(dto.getPassword());

        Usuario actualizado = usuarioRepository.save(usuario);
        return UsuarioMapper.toResponseDTO(actualizado);
    }

    public void eliminar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("No se puede eliminar: Usuario no encontrado");
        }
        usuarioRepository.deleteById(id);
    }
}