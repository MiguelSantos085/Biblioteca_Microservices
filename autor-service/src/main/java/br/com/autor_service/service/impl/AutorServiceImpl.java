package br.com.autor_service.service.impl;

import br.com.autor_service.dto.request.AutorRequest;
import br.com.autor_service.dto.response.AutorResponse;
import br.com.autor_service.mapper.AutorMapper;
import br.com.autor_service.model.AutorModel;
import br.com.autor_service.repository.AutorRepository;
import br.com.autor_service.service.AutorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutorServiceImpl implements AutorService {

    private final AutorRepository repository;
    private final AutorMapper mapper;

    public AutorServiceImpl(AutorRepository repository, AutorMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public AutorResponse create(AutorRequest request){
        AutorModel autor = mapper.toEntity(request);
        AutorModel saved = repository.save(autor);
        return mapper.toResponse(saved);
    }

    @Override
    public AutorResponse findById(Long id) {
        AutorModel autor = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor not found"));
        return mapper.toResponse(autor);
    }

    @Override
    public AutorResponse findByName(String nome) {
        AutorModel autor = repository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Autor nome not found"));
        return mapper.toResponse(autor);
    }

    @Override
    public List<AutorResponse> findAll() {
        List<AutorModel> autores = repository.findAll();
        return autores.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AutorResponse update(Long id, AutorRequest request) {
        AutorModel autor = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor not found"));

        autor.setNome(request.getNome());
        autor.setNacionalidade(request.getNacionalidade());
        autor.setAnoNascimento(request.getAnoNascimento());

        AutorModel updated = repository.save(autor);
        return mapper.toResponse(updated);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
