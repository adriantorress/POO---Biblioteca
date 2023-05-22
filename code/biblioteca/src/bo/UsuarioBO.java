package bo;

import dao.LivroDAO;
import dao.EmprestimoDAO;
import dao.UsuarioDAO;
import model.Livro;
import model.Emprestimo;
import model.Usuario;
import java.util.List;

public class UsuarioBO {
    private UsuarioDAO usuarioDAO;
    private LivroDAO livroDAO;
    private EmprestimoDAO emprestimoDAO;

    public UsuarioBO() {
        usuarioDAO = new UsuarioDAO();
        livroDAO = new LivroDAO();
        emprestimoDAO = new EmprestimoDAO();
    }

    public List<Livro> buscarLivros(String termo) {
        return livroDAO.buscarLivros(termo);
    }

    public List<Emprestimo> obterMeusEmprestimos(String username) {
        return emprestimoDAO.obterEmprestimosPorUsuario(username);
    }

    public boolean novoEmprestimo(String username, int livroId) {
        Usuario usuario = usuarioDAO.obterUsuario(username);
        Livro livro = livroDAO.obterLivro(livroId);

        if (usuario != null && livro != null) {
            if (livro.getQuantidadeDisponivel() > 0) {
                Emprestimo emprestimo = new Emprestimo(usuario, livro);
                emprestimoDAO.adicionarEmprestimo(emprestimo);
                livro.setQuantidadeDisponivel(livro.getQuantidadeDisponivel() - 1);
                livroDAO.atualizarLivro(livro);
                return true;
            }
        }

        return false;
    }

    public boolean devolverLivro(int emprestimoId) {
        Emprestimo emprestimo = emprestimoDAO.obterEmprestimo(emprestimoId);

        if (emprestimo != null) {
            Livro livro = emprestimo.getLivro();
            livro.setQuantidadeDisponivel(livro.getQuantidadeDisponivel() + 1);
            livroDAO.atualizarLivro(livro);
            emprestimoDAO.removerEmprestimo(emprestimoId);
            return true;
        }

        return false;
    }
}
