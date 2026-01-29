package mapper;

import dto.CategoriaResponseDTO;
import dto.CategoriaUpdateDTO;
import entity.Categoria;

import java.time.LocalDateTime;

public class CategoriaMapper {

    private CategoriaMapper() {}

    public static CategoriaResponseDTO toDTO(Categoria categoria) {
        return new CategoriaResponseDTO(
                categoria.getId(),
                categoria.getNome(),
                categoria.getDescricao(),
                categoria.getPrecoDiario(),
                categoria.getQuantidadeDePortas(),
                categoria.getLimitePassageiros(),
                categoria.getDataCriacao(),
                categoria.getDataAtualizacao()
        );
    }

    public static Categoria toEntity(CategoriaResponseDTO dto) {
        return new Categoria().builder()
                .nome(dto.getNome())
                .descricao(dto.getDescricao())
                .precoDiario(dto.getPrecoDiario())
                .quantidadeDePortas(dto.getQuantidadeDePortas())
                .limitePassageiros(dto.getLimitePassageiros())
                .build();
    }

    public static void updateEntity(CategoriaUpdateDTO dto, Categoria categoria) {
        categoria.setNome(dto.getNome());
        categoria.setDescricao(dto.getDescricao());
        categoria.setPrecoDiario(dto.getPrecoDiario());
        categoria.setQuantidadeDePortas(dto.getQuantidadeDePortas());
        categoria.setLimitePassageiros(dto.getLimitePassageiros());
        categoria.setDataAtualizacao(LocalDateTime.now());

    }
}
