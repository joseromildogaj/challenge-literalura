package br.com.jr.literalura.view;

import br.com.jr.literalura.controller.LivroController;
import org.springframework.stereotype.Component;

@Component
public class LivroView extends View{

    private final LivroController controller;

    public LivroView(LivroController controller) {
        this.controller = controller;
    }

    public void buscarLivroPorTitulo() {
        limparTela();
        System.out.println("======================================================");
        System.out.println("              BUSCAR LIVRO POR TITULO                 ");
        System.out.println("======================================================");
        System.out.println();
        System.out.print("Título: ");
        var titulo = lerEntrada().trim().toLowerCase();
        System.out.println();
        System.out.println(controller.consultarLivro(titulo));
        System.out.println("======================================================");
        System.out.print("Pressione ENTER para continuar...");
        pausar();
    }

    public void listarLivros() {
        limparTela();
        System.out.println("======================================================");
        System.out.println("                   LISTAR LIVROS                      ");
        System.out.println("======================================================");
        System.out.println();
        System.out.println(controller.consultarLivros());
        System.out.println("======================================================");
        System.out.print("Pressione ENTER para continuar...");
        pausar();
    }

    public void listarLivrosPorIdioma() {
        limparTela();
        System.out.println("======================================================");
        System.out.println("               LISTAR LIVROS POR IDIOMA               ");
        System.out.println("======================================================");
        System.out.println();
        System.out.println("1 - Português [PT]");
        System.out.println("2 - Espanhol [ES]");
        System.out.println("3 - Francês [FR]");
        System.out.println("4 - Inglês [EN]");
        System.out.println("5 - Italiano [IT]");
        System.out.println("6 - Alemão [DE]");
        System.out.println();
        System.out.print("Escolha o idioma: ");
        var idioma = lerEntrada().charAt(0);
        System.out.println();
        System.out.println(controller.consultarLivrosPorIdioma(idioma));
        System.out.println("======================================================");
        System.out.println("Pressione ENTER para continuar...");
        pausar();
    }
}
