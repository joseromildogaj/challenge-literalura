package br.com.jr.literalura.dto;

import br.com.jr.literalura.model.Autor;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AutorDTO(
        @JsonAlias("name") String nome,
        @JsonAlias("birth_year") String dataNascimento,
        @JsonAlias("death_year") String dataFalecimento
) {

    public AutorDTO(Autor autor) {
        this(autor.getNome(), autor.getDataNascimento(), autor.getDataFalecimento());
    }

    @Override
    public String toString() {
        return """
                Nome: %s
                Data de Nascimento: %s
                Data de Falecimento: %s
                """.formatted(nome, dataNascimento, dataFalecimento);
    }
}