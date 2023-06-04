package view;

import java.util.Scanner;
import bo.Library;
import model.User;
import model.Member;

public class RegisterLoanView {
  public void showForm(Scanner scanner, User user) {
    String isbn;
    boolean isEmpty = true;
    boolean isBookRegistered = false;
    boolean isLoanRegistered = true;
    boolean makeLoan = false;

    while (isEmpty || !isBookRegistered || isLoanRegistered || !makeLoan) {
      System.out.println("\n0 - Voltar");
      System.out.println("\nNovo Empréstimo");
      System.out.print("ISBN do Livro: ");
      isbn = scanner.nextLine();
      if (isbn.equals("0")) {
        break;
      }
      isEmpty = isbn.isEmpty();
      isBookRegistered = Library.verifyBookRegistered(isbn);
      isLoanRegistered = Library.verifyLoan(user.getUsername(), isbn);
      if (isEmpty) {
        System.out.println("\nPreencha o campo!");
        continue;
      } else if (!isBookRegistered) {
        System.out.println("\nLivro não encontrado!");
        continue;
      } else if (isLoanRegistered) {
        System.out.println("\nVocê já está em posse deste livro!");
        continue;
      }
      makeLoan = ((Member) user).makeLoan(isbn);
      if (makeLoan) {
        System.out.println("\nEmpréstimo realizado com sucesso!");
      } else {
        System.out.println("\nErro ao realizar empréstimo!");
      }
    }
  }
}
