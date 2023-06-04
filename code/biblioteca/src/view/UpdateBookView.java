package view;

import java.util.Scanner;
import model.Admin;
import bo.Library;
import java.util.List;
import java.util.Arrays;

public class UpdateBookView {

  public String showMenu(Scanner scanner) {
    String option = null;
    boolean isEmpty = true;
    while (isEmpty) {
      System.out.println("\n0 - Voltar");
      System.out.println("\nAtualizar - Livro");
      System.out.println("1. Atualizar Titulo");
      System.out.println("2. Atualizar Autor");
      System.out.println("3. Atualizar Isbn");
      System.out.println("4. Atualizar Ano de Publicacao");
      System.out.println("5. Atualizar Categoria");
      System.out.println("6. Atualizar Quantidade Disponivel");
      System.out.println("7. Atualizar Status");
      System.out.print("\nEscolha uma opção: ");
      option = scanner.nextLine();
      isEmpty = option.isEmpty();
      if (isEmpty) {
        System.out.println("\nSelecione algo...");
      } else {
        break;
      }
    }
    return option;
  }

  public void showForm(Scanner scanner) {
    boolean isEmpty = true;
    boolean isBookRegistered = false;
    String isbn = null;
    String newValue;
    String[] options = new String[] { "0", "1", "2", "3", "4", "5", "6", "7" };
    List<String> options_list = Arrays.asList(options);

    while (isEmpty || !isBookRegistered) {
      System.out.println("\n0 - Voltar");
      System.out.println("\nAtualizar Livro");
      System.out.print("ISBN do Livro: ");
      isbn = scanner.nextLine();
      if (isbn.equals("0")) {
        break;
      }
      isEmpty = isbn.isEmpty();
      isBookRegistered = Library.verifyBookRegistered(isbn);
      if (isEmpty) {
        System.out.println("\nPreencha o campo!");
        continue;
      } else if (!isBookRegistered) {
        System.out.println("\nLivro não encontrado!");
        continue;
      }
    }

    if (!isbn.equals("0")) {
      String option = "";
      while (option.isEmpty() || !options_list.contains(option)) {
        option = showMenu(scanner);
        if (option.isEmpty()) {
          System.out.println("\nSelecione algo...");
          continue;
        }
        switch (option) {
          case "0":
            break;
          case "1":
            System.out.print("\nNovo Titulo: ");
            newValue = scanner.nextLine();
            boolean updateBook = Admin.updateBook(isbn, "titulo", newValue);
            if (updateBook) {
              System.out.println("\nTitulo atualizado com sucesso!");
            } else {
              System.out.println("\nErro ao atualizar titulo!");
              continue;
            }
            break;
          case "2":
            System.out.print("\nNovo Autor: ");
            newValue = scanner.nextLine();
            updateBook = Admin.updateBook(isbn, "autor", newValue);
            if (updateBook) {
              System.out.println("\nAutor atualizado com sucesso!");
            } else {
              System.out.println("\nErro ao atualizar autor!");
              continue;
            }
            break;
          case "3":
            System.out.print("\nNovo ISBN: ");
            newValue = scanner.nextLine();
            updateBook = Admin.updateBook(isbn, "isbn", newValue);
            if (updateBook) {
              System.out.println("\nISBN atualizado com sucesso!");
            } else {
              System.out.println("\nErro ao atualizar ISBN!");
              continue;
            }
            break;
          case "4":
            System.out.print("\nNovo Ano de Publicacao: ");
            int newIntegerValue = scanner.nextInt();
            updateBook = Admin.updateBook(isbn, "ano_publicacao", newIntegerValue);
            if (updateBook) {
              System.out.println("\nAno de publicacao atualizado com sucesso!");
            } else {
              System.out.println("\nErro ao atualizar ano de publicacao!");
              continue;
            }
            break;
          case "5":
            System.out.print("\nNovo Categoria: ");
            newValue = scanner.nextLine();
            updateBook = Admin.updateBook(isbn, "categoria", newValue);
            if (updateBook) {
              System.out.println("\nCategoria atualizado com sucesso!");
            } else {
              System.out.println("\nErro ao atualizar categoria!");
              continue;
            }
            break;
          case "6":
            System.out.print("\nNova Quantidade Disponivel: ");
            newIntegerValue = scanner.nextInt();
            updateBook = Admin.updateBook(isbn, "quantidade_disponivel", newIntegerValue);
            if (updateBook) {
              System.out.println("\nQuantidade disponivel atualizado com sucesso!");
            } else {
              System.out.println("\nErro ao atualizar quantidade disponivel!");
              continue;
            }
            break;
          case "7":
            System.out.print("\nNovo Status: ");
            newValue = scanner.nextLine();
            updateBook = Admin.updateBook(isbn, "status", newValue);
            if (updateBook) {
              System.out.println("\nStatus atualizado com sucesso!");
            } else {
              System.out.println("\nErro ao atualizar status!");
              continue;
            }
            break;
          default:
            System.out.println("\nOpção inválida! tente novamente...");
        }
      }
    }
  }

}
