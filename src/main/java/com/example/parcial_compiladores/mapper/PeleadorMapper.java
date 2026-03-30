package com.example.parcial_compiladores.mapper;

import com.example.parcial_compiladores.dto.PeleadorRequestDTO;
import com.example.parcial_compiladores.dto.PeleadorResponseDTO;
import com.example.parcial_compiladores.model.Peleador;

public class PeleadorMapper {

    public static PeleadorResponseDTO toResponseDTO(Peleador peleador) {
        if (peleador == null) return null;

        PeleadorResponseDTO dto = new PeleadorResponseDTO();

        dto.setId(peleador.getId());
        dto.setNombre(peleador.getNombre());
        dto.setAlias(peleador.getAlias());
        dto.setBiografia(peleador.getBiografia());
        dto.setHistoriaFondo(peleador.getHistoriaFondo());
        dto.setAtaque(peleador.getAtaque());
        dto.setDefensa(peleador.getDefensa());

        dto.setVictorias(peleador.getVictorias());
        dto.setDerrotas(peleador.getDerrotas());
        dto.setEmpates(peleador.getEmpates());

        dto.setActivo(peleador.getActivo());

        return dto;
    }

    public static Peleador toEntity(PeleadorRequestDTO dto) {
        if (dto == null) return null;

        Peleador peleador = new Peleador();

        peleador.setId(dto.getPeleadorId());
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

        return peleador;
    }
}
