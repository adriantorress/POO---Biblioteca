package dao;

import model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Emprestimo;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.List;
import model.Livro;

public class EmprestimoDAO {
  private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
  private static final String USUARIO = "root";
  private static final String SENHA = "#241258Aj";

  public static boolean realizarEmprestimo(Usuario usuario, String isbn) {
    try (
        Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA)) {
      String sql = "INSERT INTO tb_emprestimo (usuario_user, livro_isbn) VALUES (?, ?)";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, usuario.getUsuario());
      stmt.setString(2, isbn);
      stmt.executeUpdate();
      System.out.println("\nEmpréstimo realizado com sucesso!");
      return true;
    } catch (SQLException e) {
      System.out.println("\nErro ao realizar empréstimo: " + e.getMessage());
      return false;
    }
  }

  public static boolean devolverLivro(String usuario, String isbn) {
    try (
        Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA)) {
      String sql = "DELETE FROM tb_emprestimo WHERE usuario_user = ? AND livro_isbn = ? ";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, usuario);
      stmt.setString(2, isbn);
      stmt.executeUpdate();
      System.out.println("\nLivro Devolvido com sucesso!");
      return true;
    } catch (SQLException e) {
      System.out.println("\nErro ao devolver livro: " + e.getMessage());
      return false;
    }
  }

  public static List<Emprestimo> meusEmprestimos(Usuario usuario) {
    List<Emprestimo> emprestimos = new ArrayList<>();
    try (
        Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA)) {
      String sql = "SELECT l.titulo, l.isbn, e.data_emprestimo, e.data_devolucao,e.status FROM tb_emprestimo AS e JOIN tb_livro AS l ON l.isbn = e.livro_isbn JOIN tb_usuario u ON  u.usuario = e.usuario_user WHERE u.usuario = ?";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, usuario.getUsuario());
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        String titulo = rs.getString("l.titulo");
        String isbn = rs.getString("l.isbn");
        String dataEmprestimo = rs.getString("e.data_emprestimo");
        String dataDevolucao = rs.getString("e.data_devolucao");
        String status = rs.getString("e.status");

        Emprestimo emprestimo = new Emprestimo(titulo, isbn, dataEmprestimo, dataDevolucao, status);
        emprestimos.add(emprestimo);
      }
      return emprestimos;
    } catch (SQLException e) {
      System.out.println("\nErro ao buscar empréstimos: " + e.getMessage());
      return null;
    }
  }

  public static List<Livro> livrosDisponiveis() {
    List<Livro> livrosDisponiveis = new ArrayList<>();
    try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA)) {
      String sql = "SELECT titulo, isbn, autor, ano_publicacao, categoria FROM tb_livro WHERE quantidade_disponivel>0;";
      PreparedStatement stmt = conn.prepareStatement(sql);
      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        String titulo = rs.getString("titulo");
        String isbn = rs.getString("isbn");
        String anoPublicacao = rs.getString("ano_publicacao");

        String autor = rs.getString("autor");

        String categoria = rs.getString("categoria");

        Livro livro = new Livro(titulo, isbn, autor, anoPublicacao, categoria);
        livrosDisponiveis.add(livro);
      }
    } catch (SQLException e) {
      System.out.println("Erro ao obter livros: " + e.getMessage());
      return null;
    }
    return livrosDisponiveis;
  }

  public static boolean atualizarLivro(String isbn, String operacao, String status) {
    try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA)) {
      String sql = String.format(
          "UPDATE tb_livro SET quantidade_disponivel = quantidade_disponivel %s 1, status = CASE WHEN quantidade_disponivel %s 1 = 0 THEN '%s' ELSE status END WHERE isbn = ?",
          operacao, operacao, status);
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, isbn);
      stmt.executeUpdate();
      return true;
    } catch (SQLException e) {
      System.out.println("\nErro ao atualizar Livro: " + e.getMessage());
      return false;
    }
  }

  public static boolean verificarEmprestimo(String usuario, String isbn) {
    try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA)) {
      String sql = "SELECT * FROM tb_emprestimo WHERE usuario_user = ? AND livro_isbn = ?";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, usuario);
      stmt.setString(2, isbn);
      ResultSet rs = stmt.executeQuery();
      return rs.next();
    } catch (SQLException e) {
      System.out.println("\nErro ao verificar usuario: " + e.getMessage());
      return false;
    }
  }
}
