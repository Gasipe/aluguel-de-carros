package controller;

import dto.CategoriaRequestDTO;
import dto.CategoriaResponseDTO;
import dto.CategoriaUpdateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.CategoriaService;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin ( origins = "http://localhost:4200")

public class CategoriaController {
    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> listarTodos() {
        List<CategoriaResponseDTO> response = service.listarTodos();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CategoriaResponseDTO> salvar(@RequestBody CategoriaRequestDTO categoria) {
        CategoriaResponseDTO response = service.salvar(categoria);
        return ResponseEntity.created(URI.create("/api/categorias" + response.getId())).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> atualizar(@PathVariable UUID id, @RequestBody CategoriaUpdateDTO categoriaUpdateDTO) {
        CategoriaResponseDTO response = service.atualizar(id, categoriaUpdateDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        service.deletarCategoria(id);
        return ResponseEntity.noContent().build();
    }

 }
