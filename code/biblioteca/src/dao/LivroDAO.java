package dao;

import model.Livro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;

public class LivroDAO {
  private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
  private static final String USUARIO = "";
  private static final String SENHA = "";

  public List<Livro> buscarLivros(String termo) {
    List<Livro> resultados = new ArrayList<>();

    try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM tb_livro WHERE titulo LIKE ?");
      statement.setString(1, "%" + termo + "%");

      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        int id = resultSet.getInt("id");
        String titulo = resultSet.getString("titulo");
        String autor = resultSet.getString("autor");
        String isbn = resultSet.getString("isbn");
        int anoPublicacao = resultSet.getInt("ano_publicacao");
        String categoria = resultSet.getString("categoria");
        int quantidadeDisponivel = resultSet.getInt("quantidade_disponivel");
        String status = resultSet.getString("status");

        Livro livro = new Livro(id, titulo, autor, isbn, anoPublicacao, categoria, quantidadeDisponivel, status);
        resultados.add(livro);
      }

      resultSet.close();
      statement.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return resultados;
  }

  public Livro obterLivro(int livroId) {
    try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM tb_livro WHERE id = ?");
      statement.setInt(1, livroId);

      ResultSet resultSet = statement.executeQuery();

      if (resultSet.next()) {
        int id = resultSet.getInt("id");
        String titulo = resultSet.getString("titulo");
        String autor = resultSet.getString("autor");
        String isbn = resultSet.getString("isbn");
        int anoPublicacao = resultSet.getInt("ano_publicacao");
        String categoria = resultSet.getString("categoria");
        int quantidadeDisponivel = resultSet.getInt("quantidade_disponivel");
        String status = resultSet.getString("status");

        Livro livro = new Livro(id, titulo, autor, isbn, anoPublicacao, categoria, quantidadeDisponivel, status);
        resultSet.close();
        statement.close();
        return livro;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return null;
  }

  public void atualizarLivro(Livro livro) {
    try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
      PreparedStatement statement = connection.prepareStatement(
          "UPDATE tb_livro SET titulo = ?, autor = ?, isbn = ?, ano_publicacao = ?, categoria = ?, quantidade_disponivel = ?, status = ? WHERE id = ?");
      statement.setString(1, livro.getTitulo());
      statement.setString(2, livro.getAutor());
      statement.setString(3, livro.getIsbn());
      statement.setInt(4, livro.getAnoPublicacao());
      statement.setString(5, livro.getCategoria());
      statement.setInt(6, livro.getQuantidadeDisponivel());
      statement.setString(7, livro.getStatus());
      statement.setInt(8, livro.getId());

      statement.executeUpdate();
      statement.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void excluirLivro(int livroId) {
    try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
      PreparedStatement statement = connection.prepareStatement("DELETE FROM tb_livro WHERE id = ?");
      statement.setInt(1, livroId);

      statement.executeUpdate();
      statement.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
