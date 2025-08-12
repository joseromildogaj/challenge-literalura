package br.com.jr.literalura.view;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class View {

    private final Scanner scanner = new Scanner(System.in);

    protected String lerEntrada(){
        return scanner.nextLine();
    }

    protected void fecharScanner(){
        scanner.close();
    }

    protected void exibirMensagem(String mensagem){
        System.out.println(mensagem);
    }

    protected void pausar(){
        scanner.nextLine();
    }

    protected void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
