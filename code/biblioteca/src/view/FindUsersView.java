package view;

import model.Admin;
import model.User;
import java.util.List;

public class FindUsersView {
  public void showUsers() {
    List<User> UserList = Admin.findUsers();
    System.out.println();
    System.out.println("Usuários Cadastrados:");
    for (User user : UserList) {
      System.out.println();
      System.out.printf("Nome: %s", user.getName());
      System.out.println();
      System.out.printf("Usuário: %s", user.getUsername());
      System.out.println();
      System.out.println("-------------------");
      System.out.println();
    }
  }
}
