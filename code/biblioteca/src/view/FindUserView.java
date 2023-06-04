package view;

import java.util.Scanner;
import bo.Library;
import model.User;
import model.Admin;

public class FindUserView {
  public User showForm(Scanner scanner) {
    String username;
    boolean isEmpty = true;
    boolean isRegistered = false;
    User user = null;
    while (isEmpty || !isRegistered || user == null) {
      System.out.println("\n0 - Voltar");
      System.out.println("\nBuscar Usuário");
      System.out.print("Usuário: ");
      username = scanner.nextLine();
      if (username.equals("0")) {
        return null;
      }
      isEmpty = username.isEmpty();
      isRegistered = Library.verifyUserRegistered(username);
      if (isEmpty) {
        System.out.println("\nPreencha o campo...");
        continue;
      } else if (!isRegistered) {
        System.out.println("\nUsuário não encontrado!");
        continue;
      }
      user = Admin.findUser(username);
      if (user != null) {
        System.out.printf("\nNome: %s", user.getName());
        System.out.println("");
        System.out.printf("Cargo: %s", user.getType());
        System.out.println("");
        System.out.printf("Endereço: %s", user.getAddress());
        System.out.println("");
        System.out.printf("E-mail: %s", user.getEmail());
        System.out.println("");
        System.out.printf("Telefone: %s", user.getPhone());
        System.out.println("");
        System.out.printf("Status: %s", user.getStatus());
        System.out.println("");
      } else {
        System.out.println("\nUsuário não encontrado");
      }
    }
    return user;
  }
}