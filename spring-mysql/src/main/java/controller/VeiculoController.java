package controller;

import dto.VeiculoRequestDTO;
import dto.VeiculoResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.VeiculoService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/veiculos")
@CrossOrigin(origins = "http://localhost:4200")

public class VeiculoController {
    private final VeiculoService service;

    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<VeiculoResponseDTO>> listarVeiculos() {
        List<VeiculoResponseDTO> response = service.listarTodos();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<VeiculoResponseDTO> salvarVeiculo(@RequestBody VeiculoRequestDTO request) {
        VeiculoResponseDTO response = service.salvar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVeiculo(@PathVariable UUID id) {
        service.deletarVeiculo(id);
        return ResponseEntity.noContent().build();
    }

}
