package com.example.parcial_compiladores.controller;

import com.example.parcial_compiladores.dto.PeleaResponseDTO;
import com.example.parcial_compiladores.service.PeleaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peleas")
public class PeleaController {

    @Autowired
    private PeleaService peleaService;

    @PostMapping("/simular")
    public PeleaResponseDTO simular(@RequestParam Long p1Id, @RequestParam Long p2Id) {
        // Usamos RequestParam para enviar los IDs en la URL: ?p1Id=1&p2Id=2
        return peleaService.simularPelea(p1Id, p2Id);
    }

    @GetMapping
    public List<PeleaResponseDTO> historial() {
        return peleaService.listar();
    }
}
