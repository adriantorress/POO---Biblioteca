package dao;

import model.Emprestimo;
import model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class EmprestimoDAO {
    private Connection conexao;

    public EmprestimoDAO() {
        conexao = criarConexao();
    }

    private Connection criarConexao() {
        try {
            String url = "jdbc:mysql://localhost:3306/biblioteca";
            String usuario = "";
            String senha = "";
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Emprestimo> obterEmprestimosPorUsuario(String username) {
        List<Emprestimo> resultados = new ArrayList<>();

        try {
            String sql = "SELECT * FROM tb_emprestimo " +
                    "INNER JOIN tb_usuario ON tb_emprestimo.usuario_id = tb_usuario.id " +
                    "WHERE tb_usuario.usuario = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setId(resultSet.getInt("id"));

                resultados.add(emprestimo);
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultados;
    }

    public Emprestimo obterEmprestimo(int emprestimoId) {
        try {
            String sql = "SELECT * FROM tb_emprestimo WHERE id = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, emprestimoId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Emprestimo emprestimo = new Emprestimo(resultSet.getInt("id"), resultSet.getDate("data_emprestimo"),
                        resultSet.getDate("data_devolucao"), resultSet.getString("status"));
                emprestimo.setId(resultSet.getInt("id"));

                statement.close();
                return emprestimo;
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        try {
            String sql = "INSERT INTO tb_emprestimo (data_emprestimo, data_devolucao, status, usuario_id) " +
                    "VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setDate(1, Date.valueOf(emprestimo.getDataEmprestimo()));
            statement.setDate(2, Date.valueOf(emprestimo.getDataDevolucao()));
            statement.setString(3, emprestimo.getStatus());
            statement.setInt(4, emprestimo.getUsuario().getId());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerEmprestimo(int emprestimoId) {
        try {
            String sql = "DELETE FROM tb_emprestimo WHERE id = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, emprestimoId);

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
