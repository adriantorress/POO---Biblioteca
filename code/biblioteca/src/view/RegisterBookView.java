package view;

import java.util.Scanner;
import bo.Library;
import model.Admin;

public class RegisterBookView {
  public void showForm(Scanner scanner) {
    String title;
    String author;
    String isbn;
    String publicationYear;
    String category;
    boolean isEmpty = true;
    boolean isRegistered = true;
    boolean book = false;
    while (isEmpty || isRegistered || !book) {
      System.out.println("\n0 - Voltar");
      System.out.println("\nCadastrar Livro");
      System.out.print("Título: ");
      title = scanner.nextLine();
      if (title.equals("0")) {
        break;
      }
      System.out.print("Autor: ");
      author = scanner.nextLine();
      System.out.print("ISBN: ");
      isbn = scanner.nextLine();
      System.out.print("Ano de publicação: ");
      publicationYear = scanner.nextLine();
      System.out.print("Categoria: ");
      category = scanner.nextLine();
      isEmpty = title.isEmpty() || author.isEmpty() || isbn.isEmpty() || publicationYear.isEmpty()
          || category.isEmpty();
      isRegistered = Library.verifyBookRegistered(isbn);
      if (isEmpty) {
        System.out.println("\nPreencha todos os campos!");
        continue;
      } else if (isRegistered) {
        System.out.println("\nLivro já cadastrado!");
        continue;
      }
      book = Admin.registerBook(title, author, isbn, publicationYear, category);
      if (book) {
        System.out.println("\nLivro cadastrado com sucesso!");
      } else {
        System.out.println("\nErro ao cadastrar livro!");
      }
    }
  }
}
