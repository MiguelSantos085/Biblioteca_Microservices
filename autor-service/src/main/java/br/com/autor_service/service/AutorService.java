package br.com.autor_service.service;

import br.com.autor_service.dto.request.AutorRequest;
import br.com.autor_service.dto.response.AutorResponse;

import java.util.List;

public interface AutorService {

    AutorResponse create(AutorRequest autorRequest);
    AutorResponse findById(Long id);
    List<AutorResponse> findByNomeContainingIgnoreCase(String nome);
    AutorResponse findByName(String nome);
    List<AutorResponse> findAll();
    AutorResponse update(Long id, AutorRequest autorRequest);
    void delete(Long id);
}
