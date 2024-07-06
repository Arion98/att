package com.agenda_service_back.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @PostMapping
    public ResponseEntity<ServicoDTO> createServico(@RequestBody ServicoDTO servicoDTO) {
        ServicoDTO createdServico = servicoService.createServico(servicoDTO);
        return new ResponseEntity<>(createdServico, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ServicoDTO>> getAllServicos() {
        List<ServicoDTO> servicos = servicoService.getAllServicos();
        return new ResponseEntity<>(servicos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoDTO> getServicoById(@PathVariable("id") Long id) {
        ServicoDTO servico = servicoService.getServicoById(id);
        return new ResponseEntity<>(servico, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicoDTO> updateServico(
            @PathVariable("id") Long id,
            @RequestBody ServicoDTO servicoDTO
    ) {
        ServicoDTO updatedServico = servicoService.updateServico(id, servicoDTO);
        return new ResponseEntity<>(updatedServico, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServico(@PathVariable("id") Long id) {
        servicoService.deleteServico(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
