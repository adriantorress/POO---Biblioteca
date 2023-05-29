package view;

import java.util.Scanner;
import bo.AdminBO;

public class CadastroLivroView {
  public boolean exibirFormulario(Scanner scanner) {
    String titulo;
    String autor;
    String isbn;
    String anoPublicacao;
    String categoria;
    boolean isCamposVazios;
    boolean isLivroCadastrado;
    do {
      System.out.println("\n---- Cadastrar Livro ----");
      System.out.println("---- 0 - Voltar ----");

      System.out.print("\nTítulo: ");
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

      isCamposVazios = titulo.isEmpty() || autor.isEmpty() || isbn.isEmpty() || anoPublicacao.isEmpty()
          || categoria.isEmpty();
      isLivroCadastrado = AdminBO.verificarLivroCadastrado(isbn);

      if (isCamposVazios) {
        System.out.println("\nPreencha todos os campos...");
      }

      else if (isLivroCadastrado) {
        System.out.println("\nLivro já cadastrado!");
      }

    } while (isCamposVazios || isLivroCadastrado);

    AdminBO.salvarLivro(titulo, autor, isbn, anoPublicacao, categoria);

    return true;
  }
}