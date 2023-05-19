package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
  private static final String URL = ConfigDAO.getURL();
  private static final String USUARIO = ConfigDAO.getUsuario();
  private static final String SENHA =  ConfigDAO.getSenha();

  public static boolean verificarCredenciais(String username, String password) {
    try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA)) {
      String sql = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, username);
      stmt.setString(2, password);
      ResultSet rs = stmt.executeQuery();
      return rs.next();
    } catch (SQLException e) {
      System.out.println("Erro ao verificar credenciais: " + e.getMessage());
    }
    return false;
  }
}
