package br.com.autor_service.mapper;

import br.com.autor_service.dto.request.AutorRequest;
import br.com.autor_service.dto.response.AutorResponse;
import br.com.autor_service.model.AutorModel;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface AutorMapper {

    AutorModel toEntity(AutorRequest request);

    AutorResponse toResponse(AutorModel autor);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAutorFromRequest(
            AutorRequest request,
            @MappingTarget AutorModel autor);

//    public AutorModel toEntity(AutorRequest request) {
//        AutorModel autor = new AutorModel();
//        autor.setNome(request.getNome());
//        autor.setNacionalidade(request.getNacionalidade());
//        autor.setAnoNascimento(request.getAnoNascimento());
//        return autor;
//    }
//
//    public AutorResponse toResponse(AutorModel autor) {
//        AutorResponse response = new AutorResponse();
//        response.setId(autor.getId());
//        response.setNome(autor.getNome());
//        response.setNacionalidade(autor.getNacionalidade());
//        response.setAnoNascimento(autor.getAnoNascimento());
//        return response;
//    }
}
