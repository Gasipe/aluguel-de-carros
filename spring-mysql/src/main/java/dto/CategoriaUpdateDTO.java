package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaUpdateDTO {
    private String nome;
    private String descricao;
    private BigDecimal precoDiario;
    private Integer quantidadeDePortas;
    private Integer limitePassageiros;
}
