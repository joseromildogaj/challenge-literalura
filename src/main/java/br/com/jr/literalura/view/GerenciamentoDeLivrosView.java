package br.com.jr.literalura.view;

import org.springframework.stereotype.Component;

@Component
public class GerenciamentoDeLivrosView extends View{

    public char exibir() {
        limparTela();
        System.out.println("================================================");
        System.out.println("            GERENCIAMENTO DE LIVROS             ");
        System.out.println("================================================");
        System.out.println();
        System.out.println("        1 - Buscar Livro Por Título             ");
        System.out.println("        2 - Listar Livros                       ");
        System.out.println("        3 - Listar Autores                      ");
        System.out.println("        4 - Listar Autores Vivos Por Ano        ");
        System.out.println("        5 - Listar Livros Por Idioma            ");
        System.out.println("        6 - Buscar Autor Por Nome               ");
        System.out.println();
        System.out.println("        0 - Sair                                ");
        System.out.println();
        System.out.println("================================================");
        System.out.print("Escolha a opção: ");
        return lerEntrada().charAt(0);
    }

    public void finalizarPrograma(){
        fecharScanner();
        exibirMensagem("Finalizando o programa...");
    }

    public void exibirMensagemErro() {
        System.out.println("Opção inválida! Tente novamente.");
        System.out.println("======================================================");
        System.out.println("Pressione ENTER para continuar...");
        pausar();
    }

}
