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

    public PeleadorResponseDTO guardar(PeleadorRequestDTO dto) {
        Peleador peleador = PeleadorMapper.toEntity(dto);
        Peleador guardado = peleadorRepository.save(peleador);
        return PeleadorMapper.toDTO(guardado);
    }

    public List<PeleadorResponseDTO> listar() {
        return peleadorRepository.findAll()
                .stream()
                .map(PeleadorMapper::toDTO)
                .toList();
    }

    public PeleadorResponseDTO buscarPorId(Long id) {
        Peleador peleador = peleadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Peleador no encontrado"));
        return PeleadorMapper.toDTO(peleador);
    }

    public PeleadorResponseDTO actualizar(Long id, PeleadorRequestDTO dto) {
        Peleador peleador = peleadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Peleador no encontrado"));

        peleador.setNombre(dto.getNombre());
        peleador.setAlias(dto.getAlias());
        peleador.setBiografia(dto.getBiografia());
        peleador.setHistoriaFondo(dto.getHistoriaFondo());
        peleador.setAtaque(dto.getAtaque());
        peleador.setDefensa(dto.getDefensa());

        peleador.setVictorias(dto.getVictorias());
        peleador.setDerrotas(dto.getDerrotas());
        peleador.setEmpates(dto.getEmpates());

        peleador.setActivo(dto.getActivo());

        Peleador actualizado = peleadorRepository.save(peleador);
        return PeleadorMapper.toDTO(actualizado);
    }

    public void eliminar(Long id) {
        peleadorRepository.deleteById(id);
    }

    @Autowired
    private PeleadorRepository peleadorRepository;
}