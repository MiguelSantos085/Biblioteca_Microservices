package br.com.livro_service.mapper;

import br.com.livro_service.dto.request.LivroRequest;
import br.com.livro_service.dto.response.LivroResponse;
import br.com.livro_service.model.LivroModel;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface LivroMapper {

    LivroModel toEntity(LivroRequest request);

    LivroResponse toResponse(LivroModel livro);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateLivroFromRequest(
            LivroRequest request,
            @MappingTarget LivroModel livro);
}
