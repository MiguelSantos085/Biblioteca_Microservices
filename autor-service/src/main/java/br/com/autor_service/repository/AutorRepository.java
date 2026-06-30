package br.com.autor_service.repository;

import br.com.autor_service.model.AutorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<AutorModel, Long> {

    Optional<AutorModel> findByNome(String nome);

    Optional<AutorModel> findById(Long id);

}
