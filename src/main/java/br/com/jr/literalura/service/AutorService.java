package br.com.jr.literalura.service;

import br.com.jr.literalura.dto.AutorDTO;
import br.com.jr.literalura.exceptions.RecursoNaoEncontradoException;
import br.com.jr.literalura.model.Autor;
import br.com.jr.literalura.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<AutorDTO> ConsultarAutores() {
        List<Autor> autores = autorRepository.findAll();
        if (autores.isEmpty()) {
            throw new RecursoNaoEncontradoException("Não há autores cadastrados");
        }
        return autores.stream().map(AutorDTO::new).collect(Collectors.toList());
    }

    public List<AutorDTO> ConsultarAutoresVivosPorAno(String ano) {
        if (ano == null || ano.isEmpty()) {
            throw new IllegalArgumentException("Erro: O ano não foi informado");
        }
        try{
            int anoConvertido = Integer.parseInt(ano);
            if (anoConvertido < 1500 || anoConvertido > LocalDate.now().getYear()) {
                throw new IllegalArgumentException("O ano informado deve ser entre 1500 e o ano atual");
            }
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("O ano informado é inválido");
        }
        List<AutorDTO> autorDTOS = autorRepository.findByDataFalecimentoAfter(ano).stream()
                .map(AutorDTO::new).toList();
        if (autorDTOS.isEmpty()) {
            throw new RecursoNaoEncontradoException("Não há autores vivos no ano informado");
        }
        return autorDTOS;
    }

    public AutorDTO ConsultarAutorPorNome(String nome) throws RecursoNaoEncontradoException{
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Erro: O nome do autor não foi informado");
        }
        Optional<Autor> autorOptional = autorRepository.findByNomeContainingIgnoreCase(nome);
        if (autorOptional.isEmpty()) {
            throw new RecursoNaoEncontradoException("Não há autor cadastrado com o nome informado.");
        }
        return new AutorDTO(autorOptional.get());
    }
}
