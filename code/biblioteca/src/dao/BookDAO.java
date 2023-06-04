package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.List;
import model.Book;

public class BookDAO {
  private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
  private static final String USER = "root";
  private static final String PASSWORD = "#241258Aj";

  public static List<Book> availables() {
    List<Book> availableBooks = new ArrayList<>();
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
      String sql = "SELECT titulo, isbn, autor, ano_publicacao, categoria FROM tb_livro WHERE quantidade_disponivel>0;";
      PreparedStatement stmt = conn.prepareStatement(sql);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        String title = rs.getString("titulo");
        String isbn = rs.getString("isbn");
        String publicationYear = rs.getString("ano_publicacao");
        String author = rs.getString("autor");
        String category = rs.getString("categoria");
        Book book = new Book(title, isbn, author, publicationYear, category);
        availableBooks.add(book);
      }
      return availableBooks;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static boolean register(String title, String author, String isbn, String publicationYear,
      String category) {
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
      String sql = "INSERT INTO tb_livro (titulo, autor, isbn, ano_publicacao, categoria) VALUES (?, ?, ?, ?, ?)";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, title);
      stmt.setString(2, author);
      stmt.setString(3, isbn);
      stmt.setString(4, publicationYear);
      stmt.setString(5, category);
      stmt.executeUpdate();
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  public static boolean verifyRegistered(String isbn) {
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
      String sql = "SELECT * FROM tb_livro WHERE isbn = ?";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, isbn);
      ResultSet rs = stmt.executeQuery();
      return rs.next();
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  public static boolean update(String isbn, String attribute, String newValue) {
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
      String sql = String.format("UPDATE tb_livro SET %s = ? WHERE isbn = ?", attribute);
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, newValue);
      stmt.setString(2, isbn);
      stmt.executeUpdate();
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  public static boolean update(String isbn, String attribute, int newValue) {
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
      String sql = String.format("UPDATE tb_livro SET %s = ? WHERE isbn = ?", attribute);
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setInt(1, newValue);
      stmt.setString(2, isbn);
      stmt.executeUpdate();
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  public static boolean delete(String isbn) {
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
      String sql = "DELETE FROM tb_livro WHERE isbn = ?;";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, isbn);
      stmt.executeUpdate();
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  public static Book findOne(String isbn) {
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
      String sql = "SELECT titulo, autor, ano_publicacao, categoria, quantidade_disponivel, data_cadastro,status FROM tb_livro WHERE isbn = ?;";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, isbn);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        String title = rs.getString("titulo");
        String author = rs.getString("autor");
        String publicationYear = rs.getString("ano_publicacao");
        String category = rs.getString("categoria");
        String signUpDate = rs.getString("data_cadastro");
        String availableQuantity = rs.getString("quantidade_disponivel");
        String status = rs.getString("status");
        Book book = new Book(title, author, isbn, publicationYear, category, availableQuantity, signUpDate, status);
        return book;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static List<Book> find() {
    List<Book> books = new ArrayList<>();
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
      String sql = "SELECT titulo, isbn, quantidade_disponivel FROM tb_livro;";
      PreparedStatement stmt = conn.prepareStatement(sql);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        String title = rs.getString("titulo");
        String isbn = rs.getString("isbn");
        String availableQuantity = rs.getString("quantidade_disponivel");
        Book book = new Book(title, isbn, availableQuantity);
        books.add(book);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return books;
  }
}
