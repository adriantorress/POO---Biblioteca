import view.BibliotecaView;
import view.LoginView;
import view.CadastroView;
import view.UsuarioView;
import view.AdminView;

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
                    String cargo = usuario.getCargo();
                    if (usuario != null && cargo.equals("MEMBRO")) {
                        String userOpcao;
                        do {
                            UsuarioView userView = new UsuarioView(usuario);
                            userView.exibirMenu();
                            userOpcao = userView.lerOpcao(scanner);
                            switch (userOpcao) {
                                case "0":
                                    opcao = userOpcao;
                                    System.out.println("\nEncerrando o programa...");
                                    break;
                                case "1":
                                    break;
                                case "2":
                                    break;
                                case "3":
                                    break;
                                case "4":
                                    break;
                                case "5":
                                    System.out.println("\nSaindo...");
                                    break;
                                default:
                                    System.out.println("\nOpção inválida. Tente novamente.");
                            }
                        } while (!userOpcao.equals("0") && !userOpcao.equals("5"));
                    } else if (usuario != null && usuario.getCargo().equals("ADMINISTRADOR")) {
                        String adminOpcao;
                        do {
                            AdminView adminView = new AdminView(usuario);
                            adminView.exibirMenu();
                            adminOpcao = adminView.lerOpcao(scanner);
                            switch (adminOpcao) {
                                case "0":
                                    opcao = adminOpcao;
                                    System.out.println("\nEncerrando o programa...");
                                    break;
                                case "1":
                                    break;
                                case "2":
                                    break;
                                case "3":
                                    break;
                                case "4":
                                    break;
                                case "5":
                                    break;
                                case "6":
                                    break;
                                case "7":
                                    break;
                                case "8":
                                    System.out.println("\nSaindo...");
                                    break;
                                default:
                                    System.out.println("\nOpção inválida. Tente novamente.");
                            }
                        } while (!adminOpcao.equals("0") && !adminOpcao.equals("5"));
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
