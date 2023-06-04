package view;

import java.util.Scanner;

public class LibraryView {
    public String showMenu(Scanner scanner) {
        String option = null;
        boolean isEmpty = true;
        while (isEmpty) {
            System.out.println("\nBiblioteca");
            System.out.println("1. Login");
            System.out.println("2. Cadastro");
            System.out.println("0. Fechar Biblioteca");
            System.out.print("\nEscolha uma opção: ");
            option = scanner.nextLine();
            isEmpty = option.isEmpty();
            if (isEmpty) {
                System.out.println("\nSelecione algo...");
            }
        }
        return option;
    }
}
