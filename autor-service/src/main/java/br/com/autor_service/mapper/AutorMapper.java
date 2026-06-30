package br.com.autor_service.mapper;

import br.com.autor_service.dto.request.AutorRequest;
import br.com.autor_service.dto.response.AutorResponse;
import br.com.autor_service.model.AutorModel;
import org.springframework.stereotype.Component;

@Component
public class AutorMapper {

    public AutorModel toEntity(AutorRequest request) {
        AutorModel autor = new AutorModel();
        autor.setNome(request.getNome());
        autor.setNacionalidade(request.getNacionalidade());
        autor.setAnoNascimento(request.getAnoNascimento());
        return autor;
    }

    public AutorResponse toResponse(AutorModel autor) {
        AutorResponse response = new AutorResponse();
        response.setId(autor.getId());
        response.setNome(autor.getNome());
        response.setNacionalidade(autor.getNacionalidade());
        response.setAnoNascimento(autor.getAnoNascimento());
        return response;
    }
}
