package bo;

import dao.AdminDAO;

public class AdminBO {

    public static void cadastrarLivro(String titulo, String autor, String isbn, String anoPublicacao,
            String categoria) {
        boolean isCamposLivroVazios = verificarCamposLivroVazios(titulo, autor, isbn, anoPublicacao, categoria);
        boolean isLivroNaoCadastrado = verificarLivroNaoCadastrado(isbn);
        if (isCamposLivroVazios && isLivroNaoCadastrado) {
            AdminDAO.salvarLivro(titulo, autor, isbn, anoPublicacao, categoria);
        }
    }

    private static boolean verificarCamposLivroVazios(String titulo, String autor, String isbn, String anoPublicacao,
            String categoria) {
        if (titulo.isEmpty() || autor.isEmpty() || isbn.isEmpty() || anoPublicacao.isEmpty() || categoria.isEmpty()) {
            System.out.println("Todos os campos devem ser preenchidos.");
            return false;
        }
        return true;
    }

    private static boolean verificarLivroNaoCadastrado(String isbn) {
        if (AdminDAO.verificarLivroCadastrado(isbn)) {
            System.out.println("Livro já cadastrado.");
            return false;
        }
        return true;
    }

    public static boolean isCamposVazios(String titulo, String autor, String isbn, String anoPublicacao,
            String categoria) {
        return verificarCamposLivroVazios(titulo, autor, isbn, anoPublicacao, categoria);
    }

    public static boolean isLivroNaoCadastrado(String isbn) {
        return verificarLivroNaoCadastrado(isbn);
    }

    public static void atualizarLivro(String titulo, String autor, String isbn, String anoPublicacao, String categoria,
            int quantidadeDisponivel, String status) {
        AdminDAO.atualizarLivro(titulo, autor, isbn, anoPublicacao, categoria, quantidadeDisponivel, status);
    }

    public static void excluirLivro(String isbn) {
        AdminDAO.excluirLivro(isbn);
    }

    public static void buscarLivro(String isbn) {
        AdminDAO.buscarLivro(isbn);
    }

    public static void atualizarUsuario(String usuario, String nome, String senha, String cargo, String endereco,
            String email, String telefone, String status) {
        AdminDAO.atualizarUsuario(usuario, nome, senha, cargo, endereco, email, telefone,
                status);
    }

    public static void excluirUsuario(String usuario) {
        AdminDAO.excluirUsuario(usuario);
    }

    public static void buscarUsuario(String usuario) {
        AdminDAO.buscarUsuario(usuario);
    };

    public static boolean isUsuarioNaoCadastrado(String usuario) {
        return verificarLivroNaoCadastrado(usuario);
    };

}
