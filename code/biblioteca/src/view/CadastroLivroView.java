package view;

import java.util.Scanner;
import bo.AdminBO;

public class CadastroLivroView {
  public boolean exibirFormulario(Scanner scanner) {
    System.out.println("\n---- Cadastrar Livro ----");
    System.out.println("---- 0 - Voltar ----");

    System.out.print("Título: ");
    String titulo = scanner.nextLine();
    if (titulo.equals("0")) {
      return false;
    }
    System.out.print("Autor: ");
    String autor = scanner.nextLine();
    System.out.print("ISBN: ");
    String isbn = scanner.nextLine();
    System.out.print("Ano de publicação: ");
    String anoPublicacao = scanner.nextLine();
    System.out.print("Categoria: ");
    String categoria = scanner.nextLine();

    boolean isCamposVazios = AdminBO.isCamposVazios(titulo, autor, isbn, anoPublicacao, categoria);
    boolean isLivroNaoCadastrado = AdminBO.isLivroNaoCadastrado(isbn);

    if (isCamposVazios && isLivroNaoCadastrado) {
      AdminBO.cadastrarLivro(titulo, autor, isbn, anoPublicacao, categoria);
    }

    while (!(isCamposVazios && isLivroNaoCadastrado)) {
      System.out.println("\n---- Cadastrar Livro ----");
      System.out.println("---- 0 - Voltar ----");

      System.out.print("Título: ");
      titulo = scanner.nextLine();
      if (titulo.equals("0")) {
        return false;
      }
      System.out.print("Autor: ");
      autor = scanner.nextLine();
      System.out.print("ISBN: ");
      isbn = scanner.nextLine();
      System.out.print("Ano de publicação: ");
      anoPublicacao = scanner.nextLine();
      System.out.print("Categoria: ");
      categoria = scanner.nextLine();

      isCamposVazios = AdminBO.isCamposVazios(titulo, autor, isbn, anoPublicacao, categoria);
      isLivroNaoCadastrado = AdminBO.isLivroNaoCadastrado(isbn);

      if (isCamposVazios && isLivroNaoCadastrado) {
        AdminBO.cadastrarLivro(titulo, autor, isbn, anoPublicacao, categoria);
      }
    }

    return true;
  }

}
