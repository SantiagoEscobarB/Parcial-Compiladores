package com.example.parcial_compiladores.controller;

import com.example.parcial_compiladores.dto.PeleadorRequestDTO;
import com.example.parcial_compiladores.dto.PeleadorResponseDTO;
import com.example.parcial_compiladores.service.PeleadorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peleadores")
public class PeleadorController {

    @Autowired
    private PeleadorService peleadorService;

    @GetMapping
    public List<PeleadorResponseDTO> listar() {
        return peleadorService.listar();
    }

    @GetMapping("/{id}")
    public PeleadorResponseDTO buscar(@PathVariable Long id) {
        return peleadorService.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PeleadorResponseDTO crear(@Valid @RequestBody PeleadorRequestDTO dto) {
        return peleadorService.guardar(dto);
    }

    @PutMapping("/{id}")
    public PeleadorResponseDTO actualizar(@PathVariable Long id, @Valid @RequestBody PeleadorRequestDTO dto) {
        return peleadorService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        peleadorService.eliminar(id);
        return;
    }
}
