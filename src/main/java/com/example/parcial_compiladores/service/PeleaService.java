package com.example.parcial_compiladores.service;

import com.example.parcial_compiladores.dto.PeleaResponseDTO;
import com.example.parcial_compiladores.mapper.PeleaMapper;
import com.example.parcial_compiladores.model.Pelea;
import com.example.parcial_compiladores.model.Peleador;
import com.example.parcial_compiladores.repository.PeleaRepository;
import com.example.parcial_compiladores.repository.PeleadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class PeleaService {

    public PeleaResponseDTO simularPelea(Long p1Id, Long p2Id) {

        Peleador p1 = peleadorRepository.findById(p1Id)
                .orElseThrow(() -> new RuntimeException("Peleador 1 no encontrado"));

        Peleador p2 = peleadorRepository.findById(p2Id)
                .orElseThrow(() -> new RuntimeException("Peleador 2 no encontrado"));

        int poderP1 = p1.getAtaque() + p1.getDefensa();
        int poderP2 = p2.getAtaque() + p2.getDefensa();

        //FACTOR ALEATORIO
        poderP1 += random.nextInt(20);
        poderP2 += random.nextInt(20);

        Peleador ganador = null;

        if (poderP1 > poderP2) {
            ganador = p1;
            p1.setVictorias(p1.getVictorias() + 1);
            p2.setDerrotas(p2.getDerrotas() + 1);
        } else if (poderP2 > poderP1) {
            ganador = p2;
            p2.setVictorias(p2.getVictorias() + 1);
            p1.setDerrotas(p1.getDerrotas() + 1);
        } else {
            // empate
            p1.setEmpates(p1.getEmpates() + 1);
            p2.setEmpates(p2.getEmpates() + 1);
        }

        int puntos1 = random.nextInt(100);
        int puntos2 = random.nextInt(100);

        Pelea pelea = new Pelea();
        pelea.setPeleador1(p1);
        pelea.setPeleador2(p2);
        pelea.setGanador(ganador);
        pelea.setPuntosPeleador1(puntos1);
        pelea.setPuntosPeleador2(puntos2);
        pelea.setFecha(LocalDateTime.now());

        // guardar stats actualizados
        peleadorRepository.save(p1);
        peleadorRepository.save(p2);

        // guardar pelea
        Pelea guardada = peleaRepository.save(pelea);

        return PeleaMapper.toResponseDTO(guardada);
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

    @Autowired
    private PeleaRepository peleaRepository;

    @Autowired
    private PeleadorRepository peleadorRepository;

    private Random random = new Random();
}