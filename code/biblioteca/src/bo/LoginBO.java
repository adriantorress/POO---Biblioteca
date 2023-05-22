package bo;

import dao.LoginDAO;
import vo.Usuario;

public class LoginBO {
  public static Usuario realizarLogin(String username, String password) {
    if (username.equals("0"))
      return null;
    boolean loginValido = LoginDAO.verificarCredenciais(username, password);
    if (loginValido) {
      System.out.println("\nLogin realizado com sucesso!");
      return LoginDAO.obterUsuario(username);
    } else {
      System.out.println("\nUsuário ou Senha inválido. Tente novamente.");
      return null;
    }
  }
}
