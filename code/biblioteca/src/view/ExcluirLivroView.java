package view;

import java.util.Scanner;
import bo.AdminBO;

public class ExcluirLivroView {

  public boolean exibirFormulario(Scanner scanner) {
    System.out.println("\n---- Excluir Livro ----");
    System.out.println("---- 0 - Voltar ----");

    System.out.print("ISBN: ");
    String isbn = scanner.nextLine();
    if (isbn.equals("0")) {
      return false;
    }

    boolean isCamposVazios = isbn.isEmpty();
    boolean isLivroNaoCadastrado = AdminBO.isLivroNaoCadastrado(isbn);

    if (!isCamposVazios && !isLivroNaoCadastrado) {
      AdminBO.excluirLivro(isbn);
    }

    while (!(isCamposVazios && !isLivroNaoCadastrado)) {
      System.out.println("\n---- Excluir Livro ----");
      System.out.println("---- 0 - Voltar ----");

      System.out.print("ISBN: ");
      isbn = scanner.nextLine();
      if (isbn.equals("0")) {
        return false;
      }

      isCamposVazios = isbn.isEmpty();
      isLivroNaoCadastrado = AdminBO.isLivroNaoCadastrado(isbn);

      if (!isCamposVazios && !isLivroNaoCadastrado) {
        AdminBO.excluirLivro(isbn);
      }
    }
    return true;

  }
}
