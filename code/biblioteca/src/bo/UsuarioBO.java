package bo;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioBO {

    public static Usuario realizarLogin(String username, String password) {
        boolean loginValido = UsuarioDAO.verificarCredenciais(username, password);
        if (loginValido) {
            return UsuarioDAO.obterUsuario(username);
        } else {
            return null;
        }
    }

    public static boolean verificarCredenciais(String username, String password) {
        boolean loginValido = UsuarioDAO.verificarCredenciais(username, password);
        if (loginValido) {
            return true;
        } else {
            return false;
        }
    }


    public static void cadastrarUsuario(String name, String username, String password) {
        boolean isUsuarioCadastrado = verificarUsuarioCadastrado(username);
        if (!isUsuarioCadastrado) {
            UsuarioDAO.salvarUsuario(name, username, password);
        }
        ;
    }


    public static boolean verificarUsuarioCadastrado(String username) {
        if (UsuarioDAO.verificarUsuarioCadastrado(username)) {
            return true;
        }
        return false;
    }

    

}