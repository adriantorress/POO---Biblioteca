package view;

import bo.LoginBO;
import java.util.Scanner;

public class LoginView {
    public void exibirFormulario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- Login ----");
        System.out.print("Nome de usuário: ");
        String username = scanner.nextLine();
        System.out.print("Senha: ");
        String password = scanner.nextLine();

        scanner.close();

        LoginBO.realizarLogin(username, password);
    }
}
