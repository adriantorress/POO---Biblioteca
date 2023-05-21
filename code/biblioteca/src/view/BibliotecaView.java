package view;

import java.util.Scanner;

public class BibliotecaView {
    private Scanner scanner;

    public BibliotecaView() {
        scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        System.out.println("----- Biblioteca -----");
        System.out.println("1. Login ");
        System.out.println("2. Cadastro ");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public Scanner lerOpcao() {
        return scanner;
    }
}
