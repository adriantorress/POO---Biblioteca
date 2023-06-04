package view;

import java.util.Scanner;
import bo.Library;
import model.Admin;
import java.util.List;
import java.util.Arrays;

public class UpdateUserView {

  public String showMenu(Scanner scanner) {
    String option = null;
    boolean isEmpty = true;
    while (isEmpty) {
      System.out.println("\n0 - Voltar");
      System.out.println("\nAtualizar - Usuário");
      System.out.println("1. Atualizar Nome");
      System.out.println("2. Atualizar Username");
      System.out.println("3. Atualizar Senha");
      System.out.println("4. Atualizar Cargo");
      System.out.println("5. Atualizar Endereco");
      System.out.println("6. Atualizar Email");
      System.out.println("7. Atualizar Telefone");
      System.out.println("8. Atualizar Status");
      System.out.print("\nEscolha uma opção: ");
      option = scanner.nextLine();
      isEmpty = option.isEmpty();
      if (isEmpty) {
        System.out.println("\nSelecione algo...");
        continue;
      } else {
        break;
      }
    }
    return option;
  }

  public void showForm(Scanner scanner) {
    boolean isEmpty = true;
    boolean isUserRegistered = false;
    String user = null;
    String newValue;
    String[] options = new String[] { "0", "1", "2", "3", "4", "5", "6", "7" };
    List<String> options_list = Arrays.asList(options);

    while (isEmpty || !isUserRegistered) {
      {
        System.out.println("\n0 - Voltar");
        System.out.println("\nAtualizar Usuário");
        System.out.print("Usuário: ");
        user = scanner.nextLine();
        if (user.equals("0")) {
          break;
        }
        isEmpty = user.isEmpty();
        isUserRegistered = Library.verifyUserRegistered(user);
        if (isEmpty) {
          System.out.println("\nPreencha o campo!");
          continue;
        } else if (!isUserRegistered) {
          System.out.println("\nUsuário não encontrado!");
          continue;
        }
      }
    }

    if (!user.equals("0")) {
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
            System.out.print("\nNovo Nome: ");
            newValue = scanner.nextLine();
            boolean updateBook = Admin.updateUser(user, "nome", newValue);
            if (updateBook) {
              System.out.println("\nNome atualizado com sucesso!");
            } else {
              System.out.println("\nErro ao atualizar nome!");
              continue;
            }
            break;
          case "2":
            System.out.print("\nNovo Usuário: ");
            newValue = scanner.nextLine();
            updateBook = Admin.updateUser(user, "usuario", newValue);
            if (updateBook) {
              System.out.println("\nUsuário atualizado com sucesso!");
            } else {
              System.out.println("\nErro ao atualizar usuário!");
              continue;
            }
            break;
          case "3":
            System.out.print("\nNova Senha: ");
            newValue = scanner.nextLine();
            updateBook = Admin.updateUser(user, "senha", newValue);
            if (updateBook) {
              System.out.println("\nSenha atualizada com sucesso!");
            } else {
              System.out.println("\nErro ao atualizar senha!");
              continue;
            }
            break;
          case "4":
            System.out.print("\nNovo Cargo: ");
            newValue = scanner.nextLine();
            updateBook = Admin.updateUser(user, "cargo", newValue);
            if (updateBook) {
              System.out.println("\nCargo atualizado com sucesso!");
            } else {
              System.out.println("\nErro ao atualizar cargo!");
              continue;
            }
            break;
          case "5":
            System.out.print("\nNovo Endereço: ");
            newValue = scanner.nextLine();
            updateBook = Admin.updateUser(user, "endereco", newValue);
            if (updateBook) {
              System.out.println("\nEndereço atualizado com sucesso!");
            } else {
              System.out.println("\nErro ao atualizar endereço!");
              continue;
            }
            break;
          case "6":
            System.out.print("\nNova Email: ");
            newValue = scanner.nextLine();
            updateBook = Admin.updateUser(user, "email", newValue);
            if (updateBook) {
              System.out.println("\nEmail atualizado com sucesso!");
            } else {
              System.out.println("\nErro ao atualizar email!");
              continue;
            }
            break;
          case "7":
            System.out.print("\nNovo Telefone: ");
            newValue = scanner.nextLine();
            updateBook = Admin.updateUser(user, "telefone", newValue);
            if (updateBook) {
              System.out.println("\nTelefone atualizado com sucesso!");
            } else {
              System.out.println("\nErro ao atualizar telefone!");
              continue;
            }
            break;
          case "8":
            System.out.print("\nNovo Status: ");
            newValue = scanner.nextLine();
            updateBook = Admin.updateUser(user, "status", newValue);
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
