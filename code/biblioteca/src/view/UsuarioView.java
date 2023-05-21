package view;

import java.util.Scanner;

public class UsuarioView {
  private Scanner scanner;

  public UsuarioView() {
    scanner = new Scanner(System.in);
  }

  public void exibirMenu() {
    System.out.println("----- UsuarioView -----");
    System.out.println("1. Novo Empréstimo");
    System.out.println("2. Meus Empréstimos");
    System.out.println("3. Buscar Livros");
    System.out.println("4. Devolver Livros");
    System.out.println("0. Sair");
    System.out.print("Escolha uma opção: ");
  }

  public int lerOpcao() {
    return scanner.nextInt();
  }
}
