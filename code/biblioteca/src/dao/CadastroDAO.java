package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CadastroDAO {
  private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
  private static final String USUARIO = "root";
  private static final String SENHA = "#241258Aj";

  public static boolean salvarUsuario(String name, String username, String password) {
    try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA)) {
      String sql = "INSERT INTO tb_usuario (nome,usuario, senha) VALUES (?, ?, ?)";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, name);
      stmt.setString(2, username);
      stmt.setString(3, password);
      stmt.executeUpdate();
      System.out.println("\nUsuário cadastrado com sucesso!");
      return true;
    } catch (SQLException e) {
      System.out.println("\nErro ao cadastrar usuário: " + e.getMessage());
      return false;
    }
  }

  public static boolean verificarUsuarioCadastrado(String username) {
    try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA)) {
      String sql = "SELECT * FROM tb_usuario WHERE usuario = ?";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, username);
      ResultSet rs = stmt.executeQuery();
      return rs.next();
    } catch (SQLException e) {
      System.out.println("\nErro ao verificar nome de usuário: " + e.getMessage());
      return false;
    }
  }
}
