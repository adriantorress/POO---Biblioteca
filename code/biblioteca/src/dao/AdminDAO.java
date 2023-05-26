package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
  private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
  private static final String USUARIO = "root";
  private static final String SENHA = "#241258Aj";

  public static boolean salvarLivro(String titulo, String autor, String isbn, String anoPublicacao,
      String categoria) {
    try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA)) {
      String sql = "INSERT INTO tb_livro (titulo, autor, isbn, ano_publicacao, categoria) VALUES (?, ?, ?, ?, ?)";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, titulo);
      stmt.setString(2, autor);
      stmt.setString(3, isbn);
      stmt.setString(4, anoPublicacao);
      stmt.setString(5, categoria);
      stmt.executeUpdate();
      System.out.println("\nLivro cadastrado com sucesso!");
      return true;
    } catch (SQLException e) {
      System.out.println("\nErro ao cadastrar Livro: " + e.getMessage());
      return false;
    }
  }

  public static boolean verificarLivroCadastrado(String isbn) {
    try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA)) {
      String sql = "SELECT * FROM tb_livro WHERE isbn = ?";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, isbn);
      ResultSet rs = stmt.executeQuery();
      return rs.next();
    } catch (SQLException e) {
      System.out.println("\nErro ao verificar livro: " + e.getMessage());
      return false;
    }
  }

  public static boolean atualizarLivro(String titulo, String autor, String isbn, String anoPublicacao,
      String categoria, int quantidade_disponivel, String status) {
    try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA)) {
      String sql = "UPDATE tb_livro SET titulo = ?, autor = ?, isbn = ?, ano_publicacao = ?, categoria = ?, quantidade_disponivel = ?, status = ? WHERE isbn = ?";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, titulo);
      stmt.setString(2, autor);
      stmt.setString(3, isbn);
      stmt.setString(4, anoPublicacao);
      stmt.setString(5, categoria);
      stmt.setInt(6, quantidade_disponivel);
      stmt.setString(7, status);
      stmt.executeUpdate();
      System.out.println("\nLivro atualizado com sucesso!");
      return true;
    } catch (SQLException e) {
      System.out.println("\nErro ao atualizar Livro: " + e.getMessage());
      return false;
    }
  }

  public static boolean excluirLivro(String isbn) {
    try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA)) {
      String sql = "DELETE FROM tb_livro WHERE isbn = ?;";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, isbn);
      stmt.executeUpdate();
      System.out.println("\nLivro excluido com sucesso!");
      return true;
    } catch (SQLException e) {
      System.out.println("\nErro ao excluir Livro: " + e.getMessage());
      return false;
    }
  }

  public static boolean buscarLivro(String isbn) {
    try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA)) {
      String sql = "SELECT titulo, autor, isbn, anoPublicacao, categoria, quantidadeDisponivel, status FROM tb_livro WHERE isbn = ?;";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, isbn);
      stmt.executeUpdate();
      System.out.println("\nBusca concluída com sucesso!");
      return true;
    } catch (SQLException e) {
      System.out.println("\nErro ao buscar Livro: " + e.getMessage());
      return false;
    }
  }

  public static boolean atualizarUsuario(String usuario, String nome, String senha, String cargo, String endereco,
      String email, String telefone, String status) {
    try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA)) {
      String sql = "UPDATE tb_livro SET nome = ?, senha = ?, cargo = ?, endereco = ?, email = ?, telefone = ?, status = ? WHERE usuario = ?";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, nome);
      stmt.setString(2, senha);
      stmt.setString(3, cargo);
      stmt.setString(4, endereco);
      stmt.setString(5, email);
      stmt.setString(6, telefone);
      stmt.setString(7, status);
      stmt.setString(8, usuario);
      stmt.executeUpdate();
      System.out.println("\nLivro atualizado com sucesso!");
      return true;
    } catch (SQLException e) {
      System.out.println("\nErro ao atualizar Livro: " + e.getMessage());
      return false;
    }
  }

  public static boolean excluirUsuario(String isbn) {
    try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA)) {
      String sql = "DELETE FROM tb_livro WHERE isbn = ?;";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, isbn);
      stmt.executeUpdate();
      System.out.println("\nLivro excluido com sucesso!");
      return true;
    } catch (SQLException e) {
      System.out.println("\nErro ao excluir Livro: " + e.getMessage());
      return false;
    }
  }

  public static boolean buscarUsuario(String isbn) {
    try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA)) {
      String sql = "SELECT titulo, autor, isbn, anoPublicacao, categoria, quantidadeDisponivel, status FROM tb_livro WHERE isbn = ?;";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, isbn);
      stmt.executeUpdate();
      System.out.println("\nBusca concluída com sucesso!");
      return true;
    } catch (SQLException e) {
      System.out.println("\nErro ao buscar Livro: " + e.getMessage());
      return false;
    }
  }

}
