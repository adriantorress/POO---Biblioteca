package view;

import java.util.Scanner;
import bo.Library;
import model.Admin;

public class DeleteUserView {
  public void showForm(Scanner scanner) {
    boolean isEmpty = true;
    boolean isRegistered = false;
    String username;
    boolean userDeleted = false;
    while (isEmpty || !isRegistered || !userDeleted) {
      System.out.println("\n0 - Voltar");
      System.out.println("\nExcluir Usuário");
      System.out.print("Usuário: ");
      username = scanner.nextLine();
      if (username.equals("0")) {
        break;
      }
      isEmpty = username.isEmpty();
      isRegistered = Library.verifyUserRegistered(username);
      if (isEmpty) {
        System.out.println("\nPreencha o campo!");
        continue;
      } else if (!isRegistered) {
        System.out.println("\nUsuário não encontrado!");
        continue;
      }
      userDeleted = Admin.deleteUser(username);
      if (userDeleted)
        System.out.println("\nUsuário excluído com sucesso!");
      else {
        System.out.println("\nErro ao exluir usuário!");
      }
    }
  }
}