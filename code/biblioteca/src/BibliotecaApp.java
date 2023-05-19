import view.BibliotecaView;
import view.LoginView;
import view.CadastroView;

public class BibliotecaApp {
    public static void main(String[] args) {
        BibliotecaView bibliotecaView = new BibliotecaView();
        LoginView loginView = new LoginView();
        CadastroView cadastroView = new CadastroView();

        int opcao;
        do {
            bibliotecaView.exibirMenu();
            opcao = bibliotecaView.lerOpcao();

            switch (opcao) {
                case 1:
                loginView.exibirFormulario();
                    break;
                case 2:
                cadastroView.exibirFormulario();
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }
}
