package view;

import model.Book;
import model.Admin;
import java.util.List;

public class FindBooksView {
  public void showBooks() {
    List<Book> bookList = Admin.findBooks();
    System.out.println();
    System.out.println("Livros Cadastrados:");
    for (Book book : bookList) {
      System.out.println();
      System.out.printf("Título: %s", book.getTitle());
      System.out.println();
      System.out.printf("ISBN: %s", book.getIsbn());
      System.out.println();
      System.out.printf("Quantidade Disponível: %s", book.getAvailableQuantity());
      System.out.println();
      System.out.println("-------------------");
      System.out.println();
    }
  }
}