package view;

import bo.CadastroBO;
import java.util.Scanner;

public class CadastroView {
    public static void exibirFormulario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- Cadastro ----");
        System.out.print("Nome de usuário: ");
        String username = scanner.nextLine();
        System.out.print("Senha: ");
        String password = scanner.nextLine();

        scanner.close();
        
        CadastroBO.cadastrarUsuario(username, password);
    }
}
