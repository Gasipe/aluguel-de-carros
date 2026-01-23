package mapper;

import dto.VeiculoResponseDTO;
import dto.VeiculoUpdateDTO;
import entity.Veiculo;

public class VeiculoMapper {

    private VeiculoMapper() {}

    public static VeiculoResponseDTO toDTO(Veiculo veiculo) {
        return new VeiculoResponseDTO(
                veiculo.getId(),
                veiculo.getMarca(),
                veiculo.getModelo(),
                veiculo.getAno(),
                veiculo.getCor(),
                veiculo.getCategoria(),
                veiculo.getDataCriacao(),
                veiculo.getDataAtualizacao()
        );
    }

    public static Veiculo toEntity(VeiculoResponseDTO dto) {
        return new Veiculo().builder()
                .marca(dto.getMarca())
                .modelo(dto.getModelo())
                .ano(dto.getAno())
                .cor(dto.getCor())
                .categoria(dto.getCategoria())
                .build();
    }

    public static void updateEntity(VeiculoUpdateDTO dto, Veiculo veiculo) {
        veiculo.setMarca(dto.getMarca());
        veiculo.setModelo(dto.getModelo());
        veiculo.setAno(dto.getAno());
        veiculo.setCor(dto.getCor());
        veiculo.setCategoria(dto.getCategoria());
    }
}
