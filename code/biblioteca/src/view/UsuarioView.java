package view;

import java.util.Scanner;

import model.Usuario;

public class UsuarioView {
  private Usuario usuario;

  public UsuarioView(Usuario usuario) {
    this.usuario = usuario;
  }

  public String exibirMenu(Scanner scanner) {
    String opcao;
    boolean isCamposVazios;
    do {
      System.out.println("\n----- Biblioteca - Membro -----");
      System.out.printf("\n----- Olá %s -----", this.usuario.getNome());
      System.out.println();
      System.out.println();
      System.out.println("1. Novo Empréstimo");
      System.out.println("2. Meus Empréstimos");
      System.out.println("3. Buscar Livros");
      System.out.println("4. Devolver Livros");
      System.out.println("5. Deslogar");
      System.out.println("0. Finalizar Programa");
      System.out.print("\nEscolha uma opção: ");

      opcao = scanner.nextLine();

      isCamposVazios = opcao.isEmpty();
    } while (isCamposVazios);

    return opcao;

  }
}
