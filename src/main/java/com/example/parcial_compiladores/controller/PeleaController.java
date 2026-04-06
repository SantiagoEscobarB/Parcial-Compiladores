package com.example.parcial_compiladores.controller;

import com.example.parcial_compiladores.dto.PeleaRequestDTO;
import com.example.parcial_compiladores.dto.PeleaResponseDTO;
import com.example.parcial_compiladores.dto.PeleadorRequestDTO;
import com.example.parcial_compiladores.dto.PeleadorResponseDTO;
import com.example.parcial_compiladores.service.PeleaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peleas")
public class PeleaController {

    @Autowired
    private PeleaService peleaService;

    @PostMapping("/simular")
    public PeleaResponseDTO simular(@RequestBody PeleaRequestDTO dto) {
        return peleaService.simularPelea(dto.getPeleador1Id(), dto.getPeleador2Id());
    }

    @GetMapping
    public List<PeleaResponseDTO> historial() {
        return peleaService.listar();
    }

    @GetMapping("/{id}")
    public PeleaResponseDTO buscar(@PathVariable Long id) {
        return peleaService.buscarPorId(id);
    }

    @PutMapping
    public PeleaResponseDTO actualizar(@PathVariable Long id, @Valid @RequestBody PeleadorRequestDTO dto) {
        peleaService.
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        peleaService.eliminar(id);
    }
}
