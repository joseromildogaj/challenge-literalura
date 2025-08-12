package br.com.jr.literalura.principal;

import br.com.jr.literalura.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Principal {

    @Autowired
    private GerenciamentoDeLivrosView gerenciamentoDeLivrosView;

    @Autowired
    private AutorView autorView;

    @Autowired
    private LivroView livroView;

    public void iniciar() {
        char opcao = '9';
        while (opcao != '0') {
            opcao = gerenciamentoDeLivrosView.exibir();
            switch (opcao) {
                case '1' -> livroView.buscarLivroPorTitulo();
                case '2' -> livroView.listarLivros();
                case '3' -> autorView.listarAutores();
                case '4' -> autorView.listarAutoresVivosPorAno();
                case '5' -> livroView.listarLivrosPorIdioma();
                case '6' -> autorView.buscarAutoresPorNome();
                case '0' -> gerenciamentoDeLivrosView.finalizarPrograma();
                default -> gerenciamentoDeLivrosView.exibirMensagemErro();
            }
        }
    }
}
