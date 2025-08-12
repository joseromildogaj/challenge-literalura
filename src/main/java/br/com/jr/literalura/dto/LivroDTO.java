package br.com.jr.literalura.dto;

import br.com.jr.literalura.model.Livro;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivroDTO(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<AutorDTO> autores,
        @JsonAlias("languages") List<String> idiomas,
        @JsonAlias("download_count") Integer numeroDownloads
) {
    public LivroDTO(Livro livro) {
        this(livro.getTitulo(), livro.getAutores(), livro.getIdiomas(), livro.getNumeroDownloads());
    }

    @Override
    public String toString() {
        return """
                Título: %s
                Autor: %s
                Idiomas: %s
                Numero downloads: %s
                """.formatted(titulo, autores.getFirst().nome(), idiomas, numeroDownloads);
    }
}

