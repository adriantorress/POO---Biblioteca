package view;

import model.User;
import model.Member;
import model.Loan;
import java.util.List;

public class FindLoansView {
  public boolean showLoans(User user) {
    List<Loan> loanList = ((Member) user).myLoans();
    System.out.println();
    if (loanList.size() > 0) {
      System.out.println("\nMeus Empréstimos:");
      for (Loan loan : loanList) {
        System.out.println();
        System.out.printf("Título: %s", loan.getTitle());
        System.out.println();
        System.out.printf("ISBN: %s", loan.getIsbn());
        System.out.println();
        System.out.printf("Data do Empréstimo: %s", loan.getLoanDate());
        System.out.println();
        System.out.printf("Data de Devolução: %s", loan.getReturnDate());
        System.out.println();
        System.out.printf("Status: %s", loan.getStatus());
        System.out.println();
        System.out.println("-------------------");
        System.out.println();
      }
      return true;
    } else {
      System.out.println("Você não possui Empréstimos!");
      return false;
    }
  }
}
