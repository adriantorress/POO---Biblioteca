package view;

import java.util.Scanner;
import bo.AdminBO;

public class ExcluirLivroView {

  public void exibirFormulario(Scanner scanner) {
    boolean isCamposVazios;
    boolean isLivroCadastrado;
    String isbn;

    do {
      System.out.println("\n---- Excluir Livro ----");
      System.out.println("---- 0 - Voltar ----");

      System.out.print("ISBN: ");
      isbn = scanner.nextLine();
      if (isbn.equals("0")) {
        break;
      }

      isCamposVazios = isbn.isEmpty();
      isLivroCadastrado = AdminBO.verificarLivroCadastrado(isbn);

      if (isCamposVazios) {
        System.out.println("\nPreencha o campo!");
      }
      else if (!isLivroCadastrado) {
        System.out.println("\nLivro não encontrado!");
      }

    } while (isCamposVazios || !isLivroCadastrado);

    if (!isbn.equals("0"))
      AdminBO.excluirLivro(isbn);

  }
}
