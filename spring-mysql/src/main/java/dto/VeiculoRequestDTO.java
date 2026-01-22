package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import entity.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoRequestDTO {

    @JsonProperty(required = true)
    private String marca;

    @JsonProperty(required = true)
    private String modelo;

    @JsonProperty(required = true)
    private Integer ano;

    @JsonProperty(required = true)
    private String cor;

    @JsonProperty(required = true)
    private Categoria categoria;
}
