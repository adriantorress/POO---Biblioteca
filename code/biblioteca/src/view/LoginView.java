package view;

import bo.LoginBO;

import java.util.Scanner;
import vo.Usuario;

public class LoginView {

    String username;

    public Usuario exibirFormulario(Scanner scanner) {

        System.out.println("\n---- Login ----");
        System.out.println("---- 0 - Voltar ----");
        System.out.print("Nome de usuário: ");
        username = scanner.nextLine();
        if (username.equals("0")) {
            return null;
        }
        ;
        System.out.print("Senha: ");
        String password = scanner.nextLine();

        Usuario usuario = LoginBO.realizarLogin(username, password);

        while (usuario == null) {
            System.out.println("\n---- Login ----");
            System.out.print("Nome de usuário: ");
            username = scanner.nextLine();
            if (username.equals("0")) {
                return null;
            }
            ;
            System.out.print("Senha: ");
            password = scanner.nextLine();
            usuario = LoginBO.realizarLogin(username, password);
        }

        return usuario;

    }

}
