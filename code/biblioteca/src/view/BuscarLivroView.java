package view;

import java.util.Scanner;
import bo.AdminBO;
import model.Livro;

public class BuscarLivroView {

  public Livro exibirFormulario(Scanner scanner) {
    String isbn;
    boolean isCamposVazios;
    boolean isLivroCadastrado;
    do {
      System.out.println("\n---- Buscar Usuário ----");
      System.out.println("---- 0 - Voltar ----");

      System.out.print("\nISBN do Livro: ");
      isbn = scanner.nextLine();
      if (isbn.equals("0")) {
        return null;
      }

      isCamposVazios = isbn.isEmpty();
      isLivroCadastrado = AdminBO.verificarLivroCadastrado(isbn);
      if (isCamposVazios)
        System.out.println("\nPreencha o campo...");
      else if (!isLivroCadastrado)
      System.out.println("\nLivro não encontrado!");

    } while (isCamposVazios || !isLivroCadastrado);

    return AdminBO.buscarLivro(isbn);

  }
}
