package br.com.autor_service.mapper;

import br.com.autor_service.dto.request.AutorRequest;
import br.com.autor_service.dto.response.AutorResponse;
import br.com.autor_service.model.AutorModel;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface AutorMapper {

    AutorModel toEntity(AutorRequest request);

    AutorResponse toResponse(AutorModel autor);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAutorFromRequest(
            AutorRequest request,
            @MappingTarget AutorModel autor);
}
