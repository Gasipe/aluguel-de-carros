package dto;

import entity.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class VeiculoResponseDTO {
    private UUID id;
    private String marca;
    private String modelo;
    private Integer ano;
    private String cor;
    private Categoria categoria;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
