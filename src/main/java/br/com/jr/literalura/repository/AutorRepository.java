package br.com.jr.literalura.repository;

import br.com.jr.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    List<Autor> findByDataFalecimentoAfter(String anoFalecimento);

    Optional<Autor> findByNomeContainingIgnoreCase(String nome);

}
