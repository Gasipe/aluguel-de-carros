package dto;

import entity.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class VeiculoUpdateDTO {
    private String marca;
    private String modelo;
    private Integer ano;
    private String cor;
    private Categoria categoria;
}
