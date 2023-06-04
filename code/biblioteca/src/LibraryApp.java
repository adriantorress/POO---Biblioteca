import view.LibraryView;
import view.RegisterUserView;
import view.UserView;
import view.AdminView;
import bo.Library;
import model.User;
import model.Member;

import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryView libraryView = new LibraryView();
        AdminView adminView = null;
        UserView userView = null;
        RegisterUserView registerView = new RegisterUserView();
        User user = null;
        boolean isRunning = true;

        while (isRunning) {
            String option = libraryView.showMenu(scanner);
            switch (option) {
                case "1":
                    user = login(scanner);
                    if (user != null && user.isAdmin()) {
                        adminView = new AdminView();
                    } else if (user != null && user.isMember()) {
                        userView = new UserView((Member) user);
                    }
                    break;
                case "2":
                    registerView.showForm(scanner);
                    break;
                case "0":
                    isRunning = false;
                    System.out.println("\nBiblioteca fechada. Até logo!");
                    break;
                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
            }
            if (userView != null && user != null && user.isMember()) {
                while (isRunning) {
                    option = userView.showMenu(scanner);
                    if (option.equals("5")) {
                        user = null;
                        System.out.println("\nLogout realizado com sucesso!");
                        break;
                    } else if (option.equals("0")) {
                        isRunning = false;
                        System.out.println("\nBiblioteca fechada. Até logo!");
                        break;
                    } else {
                        userView.callBoMethod(option);
                    }
                }
            } else if (adminView != null && user != null && user.isAdmin()) {
                while (isRunning) {
                    option = adminView.showMenu(scanner);
                    if (option.equals("10")) {
                        user = null;
                        System.out.println("\nLogout realizado com sucesso!");
                        break;
                    } else if (option.equals("0")) {
                        isRunning = false;
                        System.out.println("\nBiblioteca fechada. Até logo!");
                        break;
                    } else {
                        adminView.callBoMethod(option);
                    }
                }
            }
        }
        scanner.close();
    }

    private static User login(Scanner scanner) {
        boolean isEmpty = true;
        boolean isRegistered = false;
        String username = null;
        String password = null;
        User user = null;
        while (isEmpty || !isRegistered) {
            System.out.print("\n0 - Voltar");
            System.out.print("\nLogin");
            System.out.println();
            System.out.print("Usuário: ");
            username = scanner.nextLine();
            if (username.equals("0")) {
                return null;
            }
            System.out.print("Senha: ");
            password = scanner.nextLine();
            isEmpty = username.isEmpty() || password.isEmpty();
            if (isEmpty) {
                System.out.println("\nUsuário ou senha não preenchidos!");
                continue;
            }
            user = Library.login(username, password);
            if (user != null) {
                isRegistered = true;
                System.out.printf("\nBem-vindo, %s!\n", user.getName());
            } else {
                System.out.println("\nUsuário ou senha inválidos!");
            }
        }
        return user;
    }
}
