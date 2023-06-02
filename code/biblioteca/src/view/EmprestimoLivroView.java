package view;

import java.util.Scanner;
import bo.AdminBO;
import bo.EmprestimoBO;
import model.Usuario;

public class EmprestimoLivroView {

  public boolean exibirFormulario(Scanner scanner, Usuario usuario) {
    String isbn;
    boolean isCamposVazios;
    boolean isLivroCadastrado;
    do {
      System.out.println("\n---- Novo Empréstimo ----");
      System.out.println("---- 0 - Voltar ----");

      System.out.print("\nISBN do Livro: ");
      isbn = scanner.nextLine();
      if (isbn.equals("0")) {
        return false;
      }

      isCamposVazios = isbn.isEmpty();
      isLivroCadastrado = AdminBO.verificarLivroCadastrado(isbn);

      if (isCamposVazios) {
        System.out.println("\nPreencha todos os campos...");
      }

      else if (!isLivroCadastrado) {
        System.out.println("\nLivro não cadastrado!");
      }

    } while (isCamposVazios || !isLivroCadastrado);

    EmprestimoBO.realizarEmprestimo(usuario, isbn);

    return true;
  }
}
