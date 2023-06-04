package view;

import java.util.Scanner;
import bo.Library;
import model.User;
import model.Member;

public class ReturnBookView {
  public void showForm(Scanner scanner, User user) {
    boolean isEmpty = true;
    boolean isBookLoaned = false;
    String isbn;
    boolean returnBook = false;
    while (isEmpty || !isBookLoaned || !returnBook) {
      System.out.println("\n0 - Voltar");
      System.out.println("\nDevolver Livro");
      System.out.print("ISBN do Livro: ");
      isbn = scanner.nextLine();
      if (isbn.equals("0")) {
        break;
      }
      isEmpty = isbn.isEmpty();
      isBookLoaned = Library.verifyLoan(user.getUsername(), isbn);
      if (isEmpty) {
        System.out.println("\nPreencha o campo!");
        continue;
      } else if (!isBookLoaned) {
        System.out.println("\nLivro não encontrado nos seus empréstimos!");
        continue;
      }
      returnBook = ((Member)user).returnBook(isbn);
      if (returnBook) {
        System.out.println("\nLivro devolvido com sucesso!");
      } else {
        System.out.println("\nErro ao devolver livro!");
      }
    }
  }
}
