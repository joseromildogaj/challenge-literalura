package br.com.jr.literalura.service;

import br.com.jr.literalura.dto.LivroDTO;
import br.com.jr.literalura.exceptions.RecursoNaoEncontradoException;
import br.com.jr.literalura.model.Autor;
import br.com.jr.literalura.model.Livro;
import br.com.jr.literalura.repository.AutorRepository;
import br.com.jr.literalura.repository.LivroRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private GutendexService gutendexService;

    public List<LivroDTO> ConsultarPorTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: título não informado!");
        }
        try {
            JsonNode json = gutendexService.buscarDadosAPI(titulo);
            LivroDTO livroDTO = gutendexService.extrairDados(json, LivroDTO.class);
            if (livroDTO == null) {
                throw new RecursoNaoEncontradoException("O título informado não foi encontrado");
            }
            if (livroRepository.existsByTituloContainingIgnoreCase(titulo)) {
                return livroRepository.findByTituloContainingIgnoreCase(titulo).stream()
                        .map(LivroDTO::new).toList();
            }
            return Collections.singletonList(salvar(livroDTO));
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao consultar livro", e.getCause());
        }

    }

    private LivroDTO salvar(LivroDTO livroDTO) {
        Livro livro = new Livro(livroDTO);
        Autor autor = new Autor(livroDTO.autores().getFirst());
        autor = autorRepository.save(autor);
        livro.setAutor(autor);
        livroRepository.save(livro);
        return livroDTO;
    }

    public List<LivroDTO> ConsultarTodosLivros() {
        List<LivroDTO> livroDTOS = livroRepository.findAll().stream()
                .map(LivroDTO::new).toList();
        if (livroDTOS.isEmpty()) {
            throw new RecursoNaoEncontradoException("Não há livros cadastrados!");
        }
        return livroDTOS;
    }

    public List<LivroDTO> listarLivrosPorIdioma(char idioma) throws IllegalArgumentException {
        String idiomaSelecionado = validarIdioma(idioma);
        List<String> idiomas = Collections.singletonList(idiomaSelecionado);
        List<LivroDTO> livroDTOS = livroRepository.findByIdiomas(idiomas).stream()
                .map(LivroDTO::new).toList();
        if (livroDTOS.isEmpty()) {
            throw new RecursoNaoEncontradoException("Não há livros cadastrados para o idioma informado!");
        }
        return livroDTOS;
    }

    private String validarIdioma(char idioma) {
        return switch (idioma) {
            case '1' -> "pt";
            case '2' -> "es";
            case '3' -> "fr";
            case '4' -> "en";
            case '5' -> "it";
            case '6' -> "de";
            default -> throw new IllegalArgumentException("O idioma selecionado é inválido!");
        };
    }
}
