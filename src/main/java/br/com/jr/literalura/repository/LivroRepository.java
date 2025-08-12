package br.com.jr.literalura.repository;

import br.com.jr.literalura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    List<Livro> findByTituloContainingIgnoreCase(String titulo);

    boolean existsByTituloContainingIgnoreCase(String titulo);

    List<Livro> findByIdiomas(List<String> idiomas);

}
