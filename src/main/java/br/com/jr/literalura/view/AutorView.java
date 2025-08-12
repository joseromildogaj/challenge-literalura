package br.com.jr.literalura.view;

import br.com.jr.literalura.controller.AutorController;
import org.springframework.stereotype.Component;

@Component
public class AutorView extends View{

    private final AutorController controller;

    public AutorView(AutorController controller) {
        this.controller = controller;
    }

    public void listarAutores() {
        limparTela();
        System.out.println("======================================================");
        System.out.println("                   LISTAR AUTORES                     ");
        System.out.println("======================================================");
        System.out.println();
        System.out.println(controller.ConsultarAutores());
        System.out.println("======================================================");
        System.out.print("Pressione ENTER para continuar...");
        pausar();
    }

    public void listarAutoresVivosPorAno() {
        limparTela();
        System.out.println("======================================================");
        System.out.println("           LISTAR AUTORES VIVOS POR ANO               ");
        System.out.println("======================================================");
        System.out.println();
        System.out.print("Informe o ano: ");
        var ano = lerEntrada().trim().toLowerCase();
        System.out.println();
        System.out.println(controller.ConsultarAutoresVivosPorAno(ano));
        System.out.println("======================================================");
        System.out.print("Pressione ENTER para continuar...");
        pausar();
    }

    public void buscarAutoresPorNome() {
        limparTela();
        System.out.println("======================================================");
        System.out.println("               BUSCAR AUTOR POR NOME                  ");
        System.out.println("======================================================");
        System.out.println();
        System.out.print("Informe o nome: ");
        var nome = lerEntrada().trim();
        System.out.println();
        System.out.println(controller.ConsultarAutorPorNome(nome));
        System.out.println("======================================================");
        System.out.print("Pressione ENTER para continuar...");
        pausar();
    }

}
