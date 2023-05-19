package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CadastroDAO {
  private static final String URL = ConfigDAO.getURL();
  private static final String USUARIO = ConfigDAO.getUsuario();
  private static final String SENHA =  ConfigDAO.getSenha();

  public static void salvarUsuario(String username, String password) {
    try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA)) {
      String sql = "INSERT INTO usuarios (username, password) VALUES (?, ?)";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, username);
      stmt.setString(2, password);
      stmt.executeUpdate();
      System.out.println("Usuário cadastrado com sucesso!");
    } catch (SQLException e) {
      System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
    }
  }
  
    public static boolean verificarUsuarioCadastrado(String username) {
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "SELECT * FROM usuarios WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Erro ao verificar nome de usuário: " + e.getMessage());
            return false;
        }
    }
}

