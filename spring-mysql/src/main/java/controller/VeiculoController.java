package controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.VeiculoService;

@RestController
@RequestMapping("/api/veiculos")
@CrossOrigin(origins = "http://localhost:4200")

public class VeiculoController {
    private final VeiculoService service;

    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

    
}
