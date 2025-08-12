package br.com.jr.literalura.controller;

import br.com.jr.literalura.dto.LivroDTO;
import br.com.jr.literalura.exceptions.RecursoNaoEncontradoException;
import br.com.jr.literalura.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class LivroController {

    @Autowired
    private LivroService livroService;

    public String consultarLivro(String titulo) {
        try {
            var livroDTOS = livroService.ConsultarPorTitulo(titulo);
            return livroDTOS.stream()
                    .map(LivroDTO::toString).collect(Collectors.joining("\n"));
        } catch (RecursoNaoEncontradoException | IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    public String consultarLivros() {
        try {
            return livroService.ConsultarTodosLivros().stream()
                    .map(LivroDTO::toString).collect(Collectors.joining("\n"));
        } catch (RecursoNaoEncontradoException e) {
            return e.getMessage();
        }
    }

    public String consultarLivrosPorIdioma(char idioma) {
        try {
            return livroService.listarLivrosPorIdioma(idioma).stream()
                    .map(LivroDTO::toString).collect(Collectors.joining("\n"));
        } catch (RecursoNaoEncontradoException | IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
