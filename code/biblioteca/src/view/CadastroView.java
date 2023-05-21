package view;

import bo.CadastroBO;
import java.util.Scanner;

public class CadastroView {
    public void exibirFormulario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- Cadastro ----");
        System.out.print("Nome de usuário: ");
        String username = scanner.nextLine();
        System.out.print("Senha: ");
        String password = scanner.nextLine();

        scanner.close();
        
        if (CadastroBO.isCamposVazios(username, password)
        && CadastroBO.isUsuarioNaoCadastrado(username)) {
            
        };
        
    }
}
