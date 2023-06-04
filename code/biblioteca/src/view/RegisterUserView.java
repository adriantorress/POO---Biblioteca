package view;

import bo.Library;
import java.util.Scanner;

public class RegisterUserView {
    public void showForm(Scanner scanner) {
        String name;
        String username;
        String password;
        boolean isEmpty = true;
        boolean isRegistered = true;
        boolean user = false;
        while (isEmpty || isRegistered || !user) {
            System.out.println("\n0 - Voltar");
            System.out.println("\nCadastre-se");
            System.out.print("Nome: ");
            name = scanner.nextLine();
            if (name.equals("0")) {
                break;
            }
            System.out.print("Usuário: ");
            username = scanner.nextLine();
            System.out.print("Senha: ");
            password = scanner.nextLine();
            isEmpty = name.isEmpty() || username.isEmpty() || password.isEmpty();
            isRegistered = Library.verifyUserRegistered(username);
            if (isEmpty) {
                System.out.println("\nPreencha todos os campos!");
                continue;
            } else if (isRegistered) {
                System.out.println("\nUsuário já cadastrado!");
                continue;
            }
            user = Library.register(name, username, password);
            if (user) {
                System.out.println("\nUsuário cadastrado com sucesso!");
            } else {
                System.out.println("\nErro ao cadastrar usuário!");
            }
        }
    }
}
