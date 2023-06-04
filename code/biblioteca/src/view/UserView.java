package view;

import java.util.Scanner;

import bo.Library;
import model.Book;
import model.User;
import java.util.List;

public class UserView {

  private User user;
  private Scanner scanner;

  public UserView(User user) {
    this.user = user;
  }

  public String showMenu(Scanner scanner) {
    String option = null;
    boolean isEmpty = true;
    while (isEmpty) {
      System.out.println("\nBiblioteca - Membro");
      System.out.println("1. Novo Empréstimo");
      System.out.println("2. Meus Empréstimos");
      System.out.println("3. Livros Disponíveis");
      System.out.println("4. Devolver Livros");
      System.out.println("5. Deslogar");
      System.out.println("0. Finalizar Programa");
      System.out.print("\nEscolha uma opção: ");
      option = scanner.nextLine();
      isEmpty = option.isEmpty();
      if (isEmpty) {
        System.out.println("\nSelecione algo...");
        continue;
      } else {
        this.scanner = scanner;
        break;
      }
    }
    return option;

  }

  public void callBoMethod(String option) {
    switch (option) {
      case "1":
        RegisterLoanView LoanBookView = new RegisterLoanView();
        LoanBookView.showForm(scanner, user);
        break;
      case "2":
        FindLoansView findLoansView = new FindLoansView();
        findLoansView.showLoans(user);
        break;
      case "3":
        List<Book> availableBooks = Library.availableBooks();
        System.out.println();
        if (availableBooks.size() > 0) {
          System.out.println("Livros Disponíveis:");
          for (Book book : availableBooks) {

            System.out.println();
            System.out.printf("ISBN: %s", book.getIsbn());

            System.out.printf("\nTitulo: %s", book.getTitle());
            System.out.println();

            System.out.printf("Autor: %s", book.getAuthor());
            System.out.println();

            System.out.printf("Ano de Publicacao: %s", book.getPublicationYear());
            System.out.println();

            System.out.printf("Categoria: %s", book.getCategory());
            System.out.println();
          }
        } else {
          System.out.println("Nenhum Livro Disponível!");
        }
        break;
      case "4":
        FindLoansView findLoansAndReturnBookView = new FindLoansView();
        if (findLoansAndReturnBookView.showLoans(user)) {
          ReturnBookView returnBookView = new ReturnBookView();
          returnBookView.showForm(scanner, user);
        }
        break;
    }
  }

}
