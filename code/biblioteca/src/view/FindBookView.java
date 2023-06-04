package view;

import java.util.Scanner;
import bo.Library;
import model.Book;
import model.Admin;

public class FindBookView {
  public Book showForm(Scanner scanner) {
    String isbn;
    boolean isEmpty = true;
    boolean isRegistered = false;
    Book book = null;
    while (isEmpty || !isRegistered || book == null) {
      System.out.println("\n0 - Voltar");
      System.out.println("\nBuscar Livro");
      System.out.print("ISBN do Livro: ");
      isbn = scanner.nextLine();
      if (isbn.equals("0")) {
        return null;
      }
      isEmpty = isbn.isEmpty();
      isRegistered = Library.verifyBookRegistered(isbn);
      if (isEmpty) {
        System.out.println("\nPreencha o campo...");
        continue;
      } else if (!isRegistered) {
        System.out.println("\nLivro não encontrado!");
        continue;
      }
      book = Admin.findBook(isbn);
      if (book != null) {
        System.out.printf("\nTitulo: %s", book.getTitle());
        System.out.println("");
        System.out.printf("Autor: %s", book.getAuthor());
        System.out.println("");
        System.out.printf("Ano de Publicacao: %s", book.getPublicationYear());
        System.out.println("");
        System.out.printf("Categoria: %s", book.getCategory());
        System.out.println("");
        System.out.printf("Quantidade Disponivel: %s", book.getAvailableQuantity());
        System.out.println("");
        System.out.printf("Data de Cadastro: %s", book.getRegisterDate());
        System.out.println("");
        System.out.printf("Status: %s", book.getStatus());
        System.out.println("");
      } else {
        System.out.println("\nLivro não encontrado");
      }
    }
    return book;
  }
}
