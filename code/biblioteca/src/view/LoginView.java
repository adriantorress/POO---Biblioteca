package view;

import bo.UsuarioBO;
import model.Usuario;

import java.util.Scanner;

public class LoginView {

    public Usuario exibirFormulario(Scanner scanner) {
        String password;
        String username;
        boolean isCamposVazios;
        boolean isUsuarioCadastrado;
        do {
            System.out.println("\n---- Login ----");
            System.out.println("---- 0 - Voltar ----");
            System.out.print("\nNome de usuário: ");
            username = scanner.nextLine();
            if (username.equals("0")) {
                return null;
            }
            ;
            System.out.print("Senha: ");
            password = scanner.nextLine();

            isCamposVazios = username.isEmpty() || password.isEmpty();
            isUsuarioCadastrado = UsuarioBO.verificarCredenciais(username,password);

            if (isCamposVazios) {
                System.out.println("\nUsuário ou senha não preenchidos, tente novamente...");
            }

            else if (!isUsuarioCadastrado) {
                System.out.println("\nUsuário ou Senha inválido. Tente novamente.");
            }

        } while (isCamposVazios || !isUsuarioCadastrado);
        
        System.out.println("\nLogin realizado com sucesso!");
        return UsuarioBO.realizarLogin(username, password);

    }

}
