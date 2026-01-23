package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaResponseDTO {
    private UUID id;
    private String nome;
    private String descricao;
    private BigDecimal precoDiario;
    private Integer quantidadeDePortas;
    private Integer limitePassageiros;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
}
