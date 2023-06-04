package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.List;

import model.Loan;

public class LoanDAO {
  private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
  private static final String USER = "root";
  private static final String PASSWORD = "#241258Aj";

  public static boolean register(String username, String isbn) {
    try (
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
      String sql = "INSERT INTO tb_emprestimo (usuario_user, livro_isbn) VALUES (?, ?)";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, username);
      stmt.setString(2, isbn);
      stmt.executeUpdate();
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  public static boolean returnBook(String username, String isbn) {
    try (
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
      String sql = "DELETE FROM tb_emprestimo WHERE usuario_user = ? AND livro_isbn = ? ";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, username);
      stmt.setString(2, isbn);
      stmt.executeUpdate();
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  public static List<Loan> loans(String username) {
    List<Loan> loans = new ArrayList<>();
    try (
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
      String sql = "SELECT l.titulo, l.isbn, e.data_emprestimo, e.data_devolucao,e.status FROM tb_emprestimo AS e JOIN tb_livro AS l ON l.isbn = e.livro_isbn JOIN tb_usuario u ON  u.usuario = e.usuario_user WHERE u.usuario = ?";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, username);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        String title = rs.getString("l.titulo");
        String isbn = rs.getString("l.isbn");
        String loanDate = rs.getString("e.data_emprestimo");
        String returnDate = rs.getString("e.data_devolucao");
        String status = rs.getString("e.status");
        Loan loan = new Loan(title, isbn, loanDate, returnDate, status);
        loans.add(loan);
      }
      return loans;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static boolean updateBook(String isbn, String operation) {
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
      String sql = String.format(
          "UPDATE tb_livro SET quantidade_disponivel = quantidade_disponivel %s 1, status = CASE WHEN quantidade_disponivel - 1 <0 THEN 'INDISPONIVEL' WHEN quantidade_disponivel + 1 > 0 THEN 'DISPONIVEL' END WHERE isbn = ?",
          operation);
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, isbn);
      stmt.executeUpdate();
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  public static boolean verify(String username, String isbn) {
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
      String sql = "SELECT * FROM tb_emprestimo WHERE usuario_user = ? AND livro_isbn = ?";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, username);
      stmt.setString(2, isbn);
      ResultSet rs = stmt.executeQuery();
      return rs.next();
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }
}
