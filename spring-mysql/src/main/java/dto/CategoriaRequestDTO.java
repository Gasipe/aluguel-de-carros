package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaRequestDTO {

    @JsonProperty(required = true)
    private String nome;

    @JsonProperty(required = true)
    private String descricao;

    @JsonProperty(required = true)
    private BigDecimal precoDiario;

    @JsonProperty(required = true)
    private Integer quantidadeDePortas;

    @JsonProperty(required = true)
    private Integer limitePassageiros;
}
