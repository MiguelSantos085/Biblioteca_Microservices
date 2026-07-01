package br.com.autor_service.repository;

import br.com.autor_service.model.AutorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<AutorModel, Long> {

    List<AutorModel> findByNomeContainingIgnoreCase(String nome);

    Optional<AutorModel> findByNome(String nome);

    Optional<AutorModel> findById(Long id);

}
