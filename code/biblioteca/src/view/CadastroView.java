package view;

import bo.UsuarioBO;
import java.util.Scanner;

public class CadastroView {
    public boolean exibirFormulario(Scanner scanner) {
        String name;
        String username;
        String password;
        boolean isCamposVazios;
        boolean isUsuarioCadastrado;
        do {
            System.out.println("\n---- Cadastro ----");
            System.out.println("---- 0 - Voltar ----");
            System.out.print("Nome: ");
            name = scanner.nextLine();
            if (name.equals("0")) {
                return false;
            }
            System.out.print("Usuário: ");
            username = scanner.nextLine();
            System.out.print("Senha: ");
            password = scanner.nextLine();

            isCamposVazios = name.isEmpty() || username.isEmpty() || password.isEmpty();
            isUsuarioCadastrado = UsuarioBO.verificarUsuarioCadastrado(username);

            if (isCamposVazios) {
                System.out.println("\nNome, usuário ou senha não preenchidos.");
            }

            else if (isUsuarioCadastrado) {
                System.out.println("\nUsuário já cadastrado.");
            }
            
        } while (isCamposVazios || isUsuarioCadastrado);

        UsuarioBO.cadastrarUsuario(name, username, password);

        return true;
    }
}
