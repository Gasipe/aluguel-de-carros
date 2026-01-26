package service;

import dto.VeiculoRequestDTO;
import dto.VeiculoResponseDTO;
import dto.VeiculoUpdateDTO;
import entity.Veiculo;
import jakarta.transaction.Transactional;
import mapper.VeiculoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import repository.VeiculoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Transactional

public class VeiculoService {
    private final VeiculoRepository repository;

    public VeiculoService(VeiculoRepository repository) {
        this.repository = repository;
    }

    public VeiculoResponseDTO salvar(VeiculoRequestDTO dto) {
        Veiculo veiculo =  new Veiculo();
        Veiculo salvarVeiculo = repository.save(veiculo);
        return VeiculoMapper.toDTO(salvarVeiculo);
    }

    public List<VeiculoResponseDTO> listarTodos() {
        List<Veiculo> veiculos = repository.findAll();
        return veiculos.stream().map(
            veiculo -> new VeiculoResponseDTO(
                    veiculo.getId(),
                    veiculo.getMarca(),
                    veiculo.getModelo(),
                    veiculo.getAno(),
                    veiculo.getCor(),
                    veiculo.getCategoria(),
                    veiculo.getDataCriacao(),
                    veiculo.getDataAtualizacao()
            )).toList();
    }

    public VeiculoResponseDTO atualizar(UUID id, VeiculoUpdateDTO updateDTO) {
        Veiculo veiculo = repository.findById(id).orElseThrow(() -> new RuntimeException("Veiculo not found"));
        veiculo.setMarca(updateDTO.getMarca());
        veiculo.setModelo(updateDTO.getModelo());
        veiculo.setAno(updateDTO.getAno());
        veiculo.setCor(updateDTO.getCor());
        veiculo.setCategoria(updateDTO.getCategoria());
        veiculo.setDataAtualizacao(LocalDateTime.now());
        Veiculo veiculoUpdate = repository.save(veiculo);
        return VeiculoMapper.toDTO(veiculoUpdate);
        }

    public void deletarVeiculo(UUID id) {
        repository.deleteById(id);
        System.out.println("Veiculo successfully deleted");
    }
}
