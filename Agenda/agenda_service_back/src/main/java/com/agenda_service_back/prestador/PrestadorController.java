package com.agenda_service_back.prestador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestadores")
public class PrestadorController {

    @Autowired
    private PrestadorService prestadorService;

    @PostMapping
    public ResponseEntity<PrestadorDTO> createPrestador(@RequestBody PrestadorDTO prestadorDTO) {
        PrestadorDTO createdPrestador = prestadorService.createPrestador(prestadorDTO);
        return ResponseEntity.ok(createdPrestador);
    }

    @GetMapping
    public ResponseEntity<List<PrestadorDTO>> getAllPrestadores() {
        List<PrestadorDTO> prestadores = prestadorService.getAllPrestadores();
        return ResponseEntity.ok(prestadores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrestadorDTO> getPrestadorById(@PathVariable Long id) {
        return prestadorService.getPrestadorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrestadorDTO> updatePrestador(@PathVariable Long id, @RequestBody PrestadorDTO prestadorDTO) {
        PrestadorDTO updatedPrestador = prestadorService.updatePrestador(id, prestadorDTO);
        return ResponseEntity.ok(updatedPrestador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrestador(@PathVariable Long id) {
        prestadorService.deletePrestador(id);
        return ResponseEntity.noContent().build();
    }
}
