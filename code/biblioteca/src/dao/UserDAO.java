package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.User;
import model.Member;
import model.Admin;

import java.util.ArrayList;

public class UserDAO {
  private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
  private static final String USER = "root";
  private static final String PASSWORD = "#241258Aj";

  public static boolean register(String name, String username, String password) {
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
      String sql = "INSERT INTO tb_usuario (nome,usuario, senha) VALUES (?, ?, ?)";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, name);
      stmt.setString(2, username);
      stmt.setString(3, password);
      stmt.executeUpdate();
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  public static boolean verifyRegistered(String username) {
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
      String sql = "SELECT * FROM tb_usuario WHERE usuario = ?";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, username);
      ResultSet rs = stmt.executeQuery();
      return rs.next();
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  public static boolean checkCredentials(String username, String password) {
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
      String sql = "SELECT * FROM tb_usuario WHERE usuario = ? AND senha = ?";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, username);
      stmt.setString(2, password);
      ResultSet rs = stmt.executeQuery();
      return rs.next();
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  public static User catchOne(String username) {
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
      String sql = "SELECT * FROM tb_usuario WHERE usuario = ?";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, username);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        String name = rs.getString("nome");
        String type = rs.getString("cargo");
        String address = rs.getString("endereco");
        String email = rs.getString("email");
        String phone = rs.getString("telefone");
        String status = rs.getString("status");

        if (type.equals("MEMBRO")) {
          User newUser = new Member(username, name, address, email, phone, status);
          return (Member) newUser;
        } else if (type.equals("ADMINISTRADOR")) {
          User newUser = new Admin(username, name, address, email, phone, status);
          return (Admin) newUser;
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static boolean update(String username, String attribute, String newValue) {
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
      String sql = String.format("UPDATE tb_usuario SET %s = ? WHERE usuario = ?", attribute);
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, newValue);
      stmt.setString(2, username);
      stmt.executeUpdate();
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  public static boolean delete(String username) {
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
      String sql = "DELETE FROM tb_usuario WHERE usuario = ?;";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, username);
      stmt.executeUpdate();
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  public static User findOne(String username) {
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
      String sql = "SELECT usuario, nome, senha, cargo, endereco, email, telefone,status FROM tb_usuario WHERE usuario = ?;";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, username);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        String name = rs.getString("nome");
        String type = rs.getString("cargo");
        String address = rs.getString("endereco");
        String email = rs.getString("email");
        String phone = rs.getString("telefone");
        String status = rs.getString("status");
        User newUser = new User(username, name, type, address, email, phone, status);
        return newUser;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static List<User> find() {
    List<User> users = new ArrayList<>();
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
      String sql = "SELECT nome,usuario FROM tb_usuario;";
      PreparedStatement stmt = conn.prepareStatement(sql);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        String user = rs.getString("usuario");
        String name = rs.getString("nome");
        User newUser = new User(name, user);
        users.add(newUser);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return users;
  }
}
