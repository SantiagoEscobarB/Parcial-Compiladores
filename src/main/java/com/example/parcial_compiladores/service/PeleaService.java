package com.example.parcial_compiladores.service;

import com.example.parcial_compiladores.dto.PeleaRequestDTO;
import com.example.parcial_compiladores.dto.PeleaResponseDTO;
import com.example.parcial_compiladores.mapper.PeleaMapper;
import com.example.parcial_compiladores.model.Pelea;
import com.example.parcial_compiladores.model.Peleador;
import com.example.parcial_compiladores.repository.PeleaRepository;
import com.example.parcial_compiladores.repository.PeleadorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class PeleaService {

    @Autowired
    private PeleaRepository peleaRepository;
    @Autowired
    private PeleadorRepository peleadorRepository;

    @Transactional // para actualizar múltiples tablas
    public PeleaResponseDTO simularPelea(Long p1Id, Long p2Id) {
        Peleador p1 = peleadorRepository.findById(p1Id).orElseThrow();
        Peleador p2 = peleadorRepository.findById(p2Id).orElseThrow();

        Random random = new Random();

        int poder1 = p1.getAtaque() + p1.getDefensa();
        int poder2 = p2.getAtaque() + p2.getDefensa();
        int rand1 = random.nextInt(20);
        int rand2 = random.nextInt(20);
        int puntos1 = poder1 + rand1;
        int puntos2 = poder2 + rand2;

        Pelea pelea = new Pelea();
        pelea.setPeleador1(p1);
        pelea.setPeleador2(p2);
        pelea.setPuntosPeleador1(puntos1);
        pelea.setPuntosPeleador2(puntos2);
        pelea.setFecha(LocalDateTime.now());

        if (puntos1 > puntos2) {
            pelea.setGanador(p1);
            p1.setVictorias(p1.getVictorias() + 1);
            p2.setDerrotas(p2.getDerrotas() + 1);
        } else if (puntos2 > puntos1) {
            pelea.setGanador(p2);
            p2.setVictorias(p2.getVictorias() + 1);
            p1.setDerrotas(p1.getDerrotas() + 1);
        } else {
            p1.setEmpates(p1.getEmpates() + 1);
            p2.setEmpates(p2.getEmpates() + 1);
        }

        peleadorRepository.save(p1);
        peleadorRepository.save(p2);
        return PeleaMapper.toResponseDTO(peleaRepository.save(pelea));
    }
    public List<PeleaResponseDTO> listar() {
        return peleaRepository.findAll()
                .stream()
                .map(PeleaMapper::toResponseDTO)
                .toList();
    }

    public PeleaResponseDTO buscarPorId(Long id) {
        Pelea pelea = peleaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pelea no encontrada"));

        return PeleaMapper.toResponseDTO(pelea);
    }
    public void eliminar(Long id) {
        peleaRepository.deleteById(id);
    }
}