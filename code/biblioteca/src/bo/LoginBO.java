package bo;

import dao.LoginDAO;

public class LoginBO {
  public static void realizarLogin(String username, String password) {
    boolean loginValido = LoginDAO.verificarCredenciais(username, password);
    if (loginValido) {
      System.out.println("Login realizado com sucesso!");
    } else {
      System.out.println("Usuário ou Senha inválido. Tente novamente.");
    }
  }
}
