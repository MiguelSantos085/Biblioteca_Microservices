package br.com.livro_service.repository;

import br.com.livro_service.model.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<LivroModel, Long> {

    List<LivroModel> findByTituloContainingIgnoreCase(String titulo);

    Optional<LivroModel> findByTituloIgnoreCase(String titulo);

    Optional<LivroModel> findById(Long id);
}
