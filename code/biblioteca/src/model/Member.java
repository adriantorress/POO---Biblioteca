package model;

import dao.LoanDAO;
import java.util.List;

public class Member extends User {

  public Member(String username, String name, String address,
      String email, String phone, String status) {
    super(username, name, "MEMBRO", address,
        email, phone, status);
  }

  public boolean makeLoan(String isbn) {
    String userStatus = super.getStatus();
    boolean isAvailable = (Integer.parseInt(Admin.findBook(isbn).getAvailableQuantity())) > 0;
    if (!userStatus.equals("ATIVO")) {
      System.out.printf("Usuário %s!", userStatus.toLowerCase());
      System.out.println();
      return false;
    } else if (!isAvailable) {
      System.out.println("Livro indisponível");
      return false;
    } else {
      LoanDAO.register(super.getUsername(), isbn);
      LoanDAO.updateBook(isbn, "-");
      return true;
    }

  }

  public List<Loan> myLoans() {
    List<Loan> loans = LoanDAO.loans(super.getUsername());
    return loans;
  }

  public boolean returnBook(String isbn) {
    if (LoanDAO.returnBook(super.getUsername(), isbn)) {
      LoanDAO.updateBook(isbn, "+");
      return true;
    } else {
      return false;
    }
  }
}
