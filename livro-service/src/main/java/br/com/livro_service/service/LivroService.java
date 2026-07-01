package br.com.livro_service.service;

import br.com.livro_service.dto.request.LivroRequest;
import br.com.livro_service.dto.response.LivroResponse;

import java.util.List;

public interface LivroService {

    LivroResponse create(LivroRequest livroRequest);
    LivroResponse findById(Long id);
    List<LivroResponse> findByDisponivel(Boolean disponivel);
    List<LivroResponse> findByTituloContainingIgnoreCase(String titulo);
    LivroResponse findByTituloIgnoreCase(String titulo);
    List<LivroResponse> findAll();
    LivroResponse update(Long id, LivroRequest livroRequest);
    void delete(Long id);
}
