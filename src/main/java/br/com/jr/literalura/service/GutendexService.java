package br.com.jr.literalura.service;

import br.com.jr.literalura.dto.LivroDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GutendexService {

    @Autowired
    private ConsumoAPI consumoAPI;

    @Autowired
    private ConverteDados converte;

    public JsonNode buscarDadosAPI(String titulo) throws JsonProcessingException {
        String urlBase = "https://gutendex.com/books/?search=";
        String endereco = urlBase + titulo.trim().replace(" ", "%20").toLowerCase();
        return converte.objeto(consumoAPI.consumo(endereco));
    }

    public LivroDTO extrairDados(JsonNode json, Class<LivroDTO> classe) {
        return converte.obterDados(String.valueOf(json.get("results").get(0)), classe);
    }

}
