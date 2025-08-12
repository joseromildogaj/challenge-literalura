package br.com.jr.literalura.controller;

import br.com.jr.literalura.dto.AutorDTO;
import br.com.jr.literalura.exceptions.RecursoNaoEncontradoException;
import br.com.jr.literalura.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AutorController {

    @Autowired
    private AutorService autorService;

    public String ConsultarAutores() {
        try {
            return autorService.ConsultarAutores().stream()
                    .map(AutorDTO::toString).collect(Collectors.joining("\n"));
        } catch (RecursoNaoEncontradoException e) {
            return e.getMessage();
        }
    }

    public String ConsultarAutoresVivosPorAno(String ano) {
        try {
            return autorService.ConsultarAutoresVivosPorAno(ano).stream()
                    .map(AutorDTO::toString).collect(Collectors.joining("\n"));
        } catch (RecursoNaoEncontradoException | IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    public String ConsultarAutorPorNome(String nome) {
        try {
            return autorService.ConsultarAutorPorNome(nome).toString();
        } catch (RecursoNaoEncontradoException | IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
