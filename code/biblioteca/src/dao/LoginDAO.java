package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

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
        String user = rs.getString("usuario");
        String nome = rs.getString("nome");
        String cargo = rs.getString("cargo");
        String endereco = rs.getString("endereco");
        String email = rs.getString("email");
        String telefone = rs.getString("telefone");
        String status = rs.getString("status");

        Usuario usuario = new Usuario(user, nome,cargo,endereco,email,telefone,status);

        return usuario;
      }
    } catch (SQLException e) {
      System.out.println("Erro ao obter usuário: " + e.getMessage());
    }
    return null;
  }
}
