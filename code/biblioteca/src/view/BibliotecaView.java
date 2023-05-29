package view;

import java.util.Scanner;

public class BibliotecaView {

    public String exibirMenu(Scanner scanner) {
        String opcao;
        boolean isCamposVazios;
        do {
            System.out.println("\n----- Biblioteca -----");
            System.out.println("1. Login ");
            System.out.println("2. Cadastro ");
            System.out.println("0. Fechar Biblioteca");
            System.out.print("\nEscolha uma opção: ");

            opcao = scanner.nextLine();

            isCamposVazios = opcao.isEmpty();

            if (isCamposVazios) {
                System.out.println("\nSelecione algo...");
            }
        } while (isCamposVazios);

        return opcao;

    }
}
