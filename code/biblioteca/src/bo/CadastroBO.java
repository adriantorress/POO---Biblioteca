package bo;

import dao.CadastroDAO;

public class CadastroBO {
  public static void cadastrarUsuario(String username, String password) {
      CadastroDAO.salvarUsuario(username, password);
  }


  private static boolean verificarCamposVazios(String username, String password) {
      if (username.isEmpty() || password.isEmpty()) {
          System.out.println("Nome de usuário e senha devem ser preenchidos.");
          return false;
      }
      return true;
  }

  private static boolean verificarUsuarioNaoCadastrado(String username) {
      if (CadastroDAO.verificarUsuarioCadastrado(username)) {
          System.out.println("Nome de usuário já cadastrado.");
          return false;
      }
      return true;
  }
  
  public static boolean isCamposVazios(String username, String password) {
    return verificarCamposVazios(username, password);
  }

  public static boolean isUsuarioNaoCadastrado(String username) {
      return verificarUsuarioNaoCadastrado(username);
    
    
    
  }
  
}