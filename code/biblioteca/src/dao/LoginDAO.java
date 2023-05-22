package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.Usuario;

public class LoginDAO {
  private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
  private static final String USUARIO = "root";
  private static final String SENHA = "#241258Aj";

  public static boolean verificarCredenciais(String username, String password) {
    try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA)) {
      String sql = "SELECT * FROM tb_usuario WHERE usuario = ? AND senha = ?";
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

  public static Usuario obterUsuario(String username) {
    try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA)) {
      String sql = "SELECT * FROM tb_usuario WHERE usuario = ?";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, username);
      ResultSet rs = stmt.executeQuery();

      if (rs.next()) {
        int id = rs.getInt("id");
        String nome = rs.getString("nome");

        Usuario usuario = new Usuario(id, nome, username);

        return usuario;
      }
    } catch (SQLException e) {
      System.out.println("Erro ao obter usuário: " + e.getMessage());
    }
    return null;
  }
}
