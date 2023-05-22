package view;

import java.util.Scanner;

import model.Usuario;

public class UsuarioView {
  private Usuario usuario;

  public UsuarioView(Usuario usuario) {
    this.usuario = usuario;
  }

  public void exibirMenu() {
    System.out.printf("\n----- Olá %s -----", this.usuario.getNome());
    System.out.println();
    System.out.println("1. Novo Empréstimo");
    System.out.println("2. Meus Empréstimos");
    System.out.println("3. Buscar Livros");
    System.out.println("4. Devolver Livros");
    System.out.println("5. Deslogar");
    System.out.println("0. Finalizar Programa");
  }

  public String lerOpcao(Scanner scanner) {
    System.out.print("\nEscolha uma opção: ");
    return scanner.nextLine();
  }
}
