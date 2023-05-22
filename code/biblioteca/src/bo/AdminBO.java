package bo;

import dao.LivroDAO;
import model.Livro;

public class AdminBO {

    public static boolean cadastrarLivro(String titulo, String autor, String isbn, int anoPublicacao, String categoria, int quantidadeDisponivel) {
        Livro livro = new Livro(titulo, autor, isbn, anoPublicacao, categoria, quantidadeDisponivel);
        return LivroDAO.cadastrarLivro(livro);
    }

    public static boolean atualizarLivro(int id, String titulo, String autor, String isbn, int anoPublicacao, String categoria, int quantidadeDisponivel) {
        Livro livro = new Livro(id, titulo, autor, isbn, anoPublicacao, categoria, quantidadeDisponivel);
        return LivroDAO.atualizarLivro(livro);
    }

    public static boolean excluirLivro(int id) {
        return LivroDAO.excluirLivro(id);
    }

    public static Livro buscarLivro(int id) {
        return LivroDAO.buscarLivro(id);
    }
}
