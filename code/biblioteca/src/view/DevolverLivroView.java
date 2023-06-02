package view;

import java.util.Scanner;
import bo.EmprestimoBO;

public class DevolverLivroView {

  public boolean exibirFormulario(Scanner scanner, String usuario) {
    String isbn;
    boolean isCamposVazios;
    boolean isLivroEmprestimo;
    do {
      System.out.println("\n---- Devolver Livro ----");
      System.out.println("---- 0 - Voltar ----");

      System.out.print("\nISBN do Livro: ");
      isbn = scanner.nextLine();
      if (isbn.equals("0")) {
        return false;
      }

      isCamposVazios = isbn.isEmpty();
      isLivroEmprestimo = EmprestimoBO.verificarEmprestimo(usuario, isbn);

      if (isCamposVazios) {
        System.out.println("\nPreencha todos os campos...");
      }

      else if (!isLivroEmprestimo) {
        System.out.println("\nEste livro não consta nos seus empréstimos!");
      }

    } while (isCamposVazios || !isLivroEmprestimo);

    EmprestimoBO.devolverLivro(usuario, isbn);

    return true;
  }
}
