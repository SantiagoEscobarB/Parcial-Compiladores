package com.example.parcial_compiladores.service;

import com.example.parcial_compiladores.dto.PeleadorRequestDTO;
import com.example.parcial_compiladores.dto.PeleadorResponseDTO;
import com.example.parcial_compiladores.mapper.PeleadorMapper;
import com.example.parcial_compiladores.model.Peleador;
import com.example.parcial_compiladores.repository.PeleadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeleadorService {
    @Autowired
    private PeleadorRepository peleadorRepository;

    public PeleadorResponseDTO guardar(PeleadorRequestDTO dto) {
        Peleador peleador = PeleadorMapper.toEntity(dto);
        peleador.setVictorias(0);
        peleador.setDerrotas(0);
        peleador.setEmpates(0);
        Peleador guardado = peleadorRepository.save(peleador);
        return PeleadorMapper.toResponseDTO(guardado);
    }

    public List<PeleadorResponseDTO> listar() {
        return peleadorRepository.findAll()
                .stream()
                .map(PeleadorMapper::toResponseDTO)
                .toList();
    }

    public PeleadorResponseDTO buscarPorId(Long id) {
        Peleador peleador = peleadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Peleador no encontrado"));
        return PeleadorMapper.toResponseDTO(peleador);
    }

    public PeleadorResponseDTO actualizar(Long id, PeleadorRequestDTO dto) {
        Peleador peleador = peleadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Peleador no encontrado"));

        // Solo actualizamos campos informativos y de balance
        peleador.setNombre(dto.getNombre());
        peleador.setAlias(dto.getAlias());
        peleador.setBiografia(dto.getBiografia());
        peleador.setHistoriaFondo(dto.getHistoriaFondo());
        peleador.setAtaque(dto.getAtaque());
        peleador.setDefensa(dto.getDefensa());
        peleador.setActivo(dto.getActivo());

        // NO tocamos victorias, derrotas ni empates aquí.

        return PeleadorMapper.toResponseDTO(peleadorRepository.save(peleador));
    }

    public void eliminar(Long id) {
        peleadorRepository.deleteById(id);
    }
}