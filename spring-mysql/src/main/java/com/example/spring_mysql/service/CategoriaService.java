package service;

import dto.CategoriaRequestDTO;
import dto.CategoriaResponseDTO;
import dto.CategoriaUpdateDTO;
import entity.Categoria;
import jakarta.transaction.Transactional;
import mapper.CategoriaMapper;
import org.springframework.stereotype.Service;
import repository.CategoriaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Transactional

public class CategoriaService {
    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public CategoriaResponseDTO salvar(CategoriaRequestDTO requestDTO) {
        Categoria categoria = new Categoria();
        Categoria saveCategoria = repository.save(categoria);
        return CategoriaMapper.toDTO(saveCategoria);
    }

    public List<CategoriaResponseDTO> listarTodos() {
        List<Categoria> categorias = repository.findAll();
        return categorias.stream().
                map(categoria -> new CategoriaResponseDTO(
                        categoria.getId(),
                        categoria.getNome(),
                        categoria.getDescricao(),
                        categoria.getPrecoDiario(),
                        categoria.getQuantidadeDePortas(),
                        categoria.getLimitePassageiros(),
                        categoria.getDataCriacao(),
                        categoria.getDataAtualizacao()
                )).toList();
    }

    public CategoriaResponseDTO atualizar (UUID id, CategoriaUpdateDTO updateDTO) {
        Categoria categoria = repository.findById(id).orElseThrow(() -> new RuntimeException("Categoria not found"));
        categoria.setNome(updateDTO.getNome());
        categoria.setDescricao(updateDTO.getDescricao());
        categoria.setPrecoDiario(updateDTO.getPrecoDiario());
        categoria.setLimitePassageiros(updateDTO.getLimitePassageiros());
        categoria.setDataAtualizacao(LocalDateTime.now());
        Categoria updateCategoria = repository.save(categoria);
        return CategoriaMapper.toDTO(updateCategoria);
    }

    public void deletarCategoria(UUID id) {
        repository.deleteById(id);
        System.out.println("Categoria successfully deleted");
    }
}
