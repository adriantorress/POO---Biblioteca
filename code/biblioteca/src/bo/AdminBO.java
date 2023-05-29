package bo;

import dao.AdminDAO;
import model.Usuario;
import model.Livro;

public class AdminBO {

    public static void salvarLivro(String titulo, String autor, String isbn, String anoPublicacao,
            String categoria) {
        boolean isLivroCadastrado = verificarLivroCadastrado(isbn);
        if (!isLivroCadastrado) {
            AdminDAO.salvarLivro(titulo, autor, isbn, anoPublicacao, categoria);
        }
    }

    public static boolean verificarLivroCadastrado(String isbn) {
        if (AdminDAO.verificarLivroCadastrado(isbn)) {
            return true;
        }
        return false;
    }

    public static void atualizarLivro(String isbn, String atributo, String novoValor) {
        AdminDAO.atualizarLivro(isbn, atributo, novoValor);
    }

    public static void atualizarLivro(String isbn, String atributo, int novoValor) {
        AdminDAO.atualizarLivro(isbn, atributo, novoValor);
    }

    public static void excluirLivro(String isbn) {
        AdminDAO.excluirLivro(isbn);
    }

    public static Livro buscarLivro(String livro) {
        boolean isLivroCadastrado = verificarLivroCadastrado(livro);
        if (isLivroCadastrado) {
            return AdminDAO.buscarLivro(livro);
        }
        return null;
    };

    public static void atualizarUsuario(String usuario, String atributo, String novoValor) {
        AdminDAO.atualizarUsuario(usuario, atributo, novoValor);
    }


    public static void excluirUsuario(String usuario) {
        AdminDAO.excluirUsuario(usuario);
    }

    public static boolean isUsuarioCadastrado(String usuario) {
        return verificarUsuarioCadastrado(usuario);
    };

    public static boolean verificarUsuarioCadastrado(String usuario) {
        if (AdminDAO.verificarUsuarioCadastrado(usuario)) {
            return true;
        }
        return false;
    }

    public static Usuario buscarUsuario(String usuario) {
        boolean isUsuarioCadastrado = verificarUsuarioCadastrado(usuario);
        if (isUsuarioCadastrado) {
            return AdminDAO.buscarUsuario(usuario);
        }
        return null;
    };

}
