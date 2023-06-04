package view;

import java.util.Scanner;
import model.Admin;
import bo.Library;

public class DeleteBookView {
  public void showForm(Scanner scanner) {
    boolean isEmpty = true;
    boolean isRegistered = false;
    String isbn;
    boolean bookDeleted = false;
    while (isEmpty || !isRegistered || !bookDeleted) {
      System.out.println("\n0 - Voltar");
      System.out.println("\nExcluir Livro");
      System.out.print("ISBN: ");
      isbn = scanner.nextLine();
      if (isbn.equals("0")) {
        break;
      }
      isEmpty = isbn.isEmpty();
      isRegistered = Library.verifyBookRegistered(isbn);
      if (isEmpty) {
        System.out.println("\nPreencha o campo!");
        continue;
      } else if (!isRegistered) {
        System.out.println("\nLivro não encontrado!");
        continue;
      }
      bookDeleted = Admin.deleteBook(isbn);
      if (bookDeleted)
        System.out.println("\nLivro excluído com sucesso!");
      else {
        System.out.println("\nErro ao exluir livro!");
      }
    }
  }
}
