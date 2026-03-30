package com.example.parcial_compiladores.mapper;

import com.example.parcial_compiladores.dto.PeleaRequestDTO;
import com.example.parcial_compiladores.dto.PeleaResponseDTO;
import com.example.parcial_compiladores.model.Pelea;

public class PeleaMapper {
    public static PeleaResponseDTO toResponseDTO(Pelea pelea) {
        if (pelea == null) return null;
        PeleaResponseDTO dto = new PeleaResponseDTO();
        dto.setId(pelea.getId());

        dto.setPeleador1(PeleadorMapper.toResponseDTO(pelea.getPeleador1()));
        dto.setPeleador2(PeleadorMapper.toResponseDTO(pelea.getPeleador2()));

        if (pelea.getGanador() != null) {
            dto.setGanador(PeleadorMapper.toResponseDTO(pelea.getGanador()));
        }

        dto.setPuntosPeleador1(pelea.getPuntosPeleador1());
        dto.setPuntosPeleador2(pelea.getPuntosPeleador2());
        dto.setFecha(pelea.getFecha());
        return dto;
    }

    public static Pelea toEntity(PeleaRequestDTO dto) {
        if (dto == null) return null;
        Pelea pelea = new Pelea();
        // No seteamos peleadores aquí, lo hará el Service tras buscarlos en la DB
        pelea.setFecha(dto.getFecha());
        return pelea;
    }
}