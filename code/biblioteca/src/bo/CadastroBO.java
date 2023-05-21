package bo;

import dao.CadastroDAO;

public class CadastroBO {
    public static void cadastrarUsuario(String name, String username, String password) {
        boolean isCamposVazios = verificarCamposVazios(name,username, password);
        boolean isUsuarioNaoCadastrado = verificarUsuarioNaoCadastrado(username);
        if (isCamposVazios && isUsuarioNaoCadastrado) {
            CadastroDAO.salvarUsuario(username, password);
        }
        ;
    }

    private static boolean verificarCamposVazios(String name,String username, String password) {
        if (name.isEmpty() || username.isEmpty() || password.isEmpty()) {
            System.out.println("Nome, usuário ou senha não preenchidos.");
            return false;
        }
        return true;
    }

    private static boolean verificarUsuarioNaoCadastrado(String username) {
        if (CadastroDAO.verificarUsuarioCadastrado(username)) {
            System.out.println("Usuário já cadastrado.");
            return false;
        }
        return true;
    }

}