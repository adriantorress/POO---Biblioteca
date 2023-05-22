import view.BibliotecaView;
import view.LoginView;
import view.CadastroView;
import view.UsuarioView;

import java.util.Scanner;

import model.Usuario;

public class BibliotecaApp {
    public static void main(String[] args) {
        BibliotecaView bibliotecaView = new BibliotecaView();
        LoginView loginView = new LoginView();
        CadastroView cadastroView = new CadastroView();

        Scanner scanner = new Scanner(System.in);
        String opcao;

        do {
            bibliotecaView.exibirMenu();

            while (!scanner.hasNextInt()) {
                System.out.println("\nOpção inválida. Tente novamente.");
                bibliotecaView.exibirMenu();
                scanner.next();
            }

            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    Usuario usuario = loginView.exibirFormulario(scanner);
                    if (usuario != null) {
                        UsuarioView userView = new UsuarioView(usuario);
                        userView.exibirMenu();
                        String newOpcao = userView.lerOpcao(scanner);
                        if (newOpcao.equals("0")) {
                            opcao = newOpcao;
                            System.out.println("\nEncerrando o programa...");
                        }
                    }
                    break;
                case "2":
                    cadastroView.exibirFormulario(scanner);
                    break;
                case "0":
                    System.out.println("\nEncerrando o programa...");
                    scanner.close();
                    break;
                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
            }
        } while (!opcao.equals("0"));
    }
}
