package com.example.parcial_compiladores.mapper;

import com.example.parcial_compiladores.dto.PeleaRequestDTO;
import com.example.parcial_compiladores.dto.PeleaResponseDTO;
import com.example.parcial_compiladores.model.Pelea;
import com.example.parcial_compiladores.model.Peleador;

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

        pelea.setId(dto.getPeleaId());

        // Crear referencias de peleadores SOLO con ID
        Peleador p1 = new Peleador();
        p1.setId(dto.getPeleador1Id());

        Peleador p2 = new Peleador();
        p2.setId(dto.getPeleador2Id());

        Peleador ganador = pelea.getGanador();

        pelea.setPeleador1(p1);
        pelea.setPeleador2(p2);
        pelea.setGanador(ganador);

        pelea.setPuntosPeleador1(dto.getPuntosPeleador1());
        pelea.setPuntosPeleador2(dto.getPuntosPeleador2());

        pelea.setFecha(dto.getFecha());

        return pelea;
    }
}