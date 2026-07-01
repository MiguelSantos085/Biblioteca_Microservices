package br.com.livro_service.service.impl;

import br.com.livro_service.dto.request.LivroRequest;
import br.com.livro_service.dto.response.LivroResponse;
import br.com.livro_service.mapper.LivroMapper;
import br.com.livro_service.model.LivroModel;
import br.com.livro_service.repository.LivroRepository;
import br.com.livro_service.service.LivroService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroServiceImpl implements LivroService {

    private final LivroRepository repository;
    private final LivroMapper mapper;

    public LivroServiceImpl(LivroRepository repository, LivroMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public LivroResponse create(LivroRequest request) {
        LivroModel livro = mapper.toEntity(request);
        LivroModel saved = repository.save(livro);
        return mapper.toResponse(saved);
    }

    @Override
    public List<LivroResponse> findByDisponivel(Boolean disponivel) {
        List<LivroModel> disponibilidades = repository.findByDisponivel(disponivel);
        return disponibilidades.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public LivroResponse findById(Long id) {
        LivroModel livro = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro not found"));
        return mapper.toResponse(livro);
    }

    @Override
    public List<LivroResponse> findByTituloContainingIgnoreCase(String titulo) {
        List<LivroModel> titulos = repository.findByTituloContainingIgnoreCase(titulo);
        return titulos.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public LivroResponse findByTituloIgnoreCase(String titulo) {
        LivroModel livro = repository.findByTituloIgnoreCase(titulo)
                .orElseThrow(() -> new RuntimeException("Livro titulo not found"));
        return mapper.toResponse(livro);
    }

    @Override
    public List<LivroResponse> findAll() {
        List<LivroModel> livros = repository.findAll();
        return livros.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public LivroResponse update(Long id, LivroRequest request) {
        LivroModel livro = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro not found"));

        mapper.updateLivroFromRequest(request, livro);

        LivroModel livroAtualizado = repository.save(livro);

        return mapper.toResponse(livroAtualizado);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
