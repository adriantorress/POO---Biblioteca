package view;

import bo.CadastroBO;
import java.util.Scanner;

public class CadastroView {
    public boolean exibirFormulario(Scanner scanner) {

        System.out.println("\n---- Cadastro ----");
        System.out.println("---- 0 - Voltar ----");
        System.out.print("Nome: ");
        String name = scanner.nextLine();
        if (name.equals("0")) {
            return false;
        }
        System.out.print("Usuário: ");
        String username = scanner.nextLine();
        System.out.print("Senha: ");
        String password = scanner.nextLine();

        boolean isCamposVazios = CadastroBO.isCamposVazios(name, username, password);
        boolean isUsuarioNaoCadastrado = CadastroBO.isUsuarioNaoCadastrado(username);

        if (isCamposVazios && isUsuarioNaoCadastrado) {
            CadastroBO.cadastrarUsuario(name, username, password);
        }

        while (!(isCamposVazios && isUsuarioNaoCadastrado)) {
            System.out.println("\n---- Cadastro ----");
            System.out.print("Nome: ");
            name = scanner.nextLine();
            if (name.equals("0")) {
                return false;
            }
            System.out.print("Usuário: ");
            username = scanner.nextLine();
            System.out.print("Senha: ");
            password = scanner.nextLine();

            isCamposVazios = CadastroBO.isCamposVazios(name, username, password);
            isUsuarioNaoCadastrado = CadastroBO.isUsuarioNaoCadastrado(username);

            if (isCamposVazios && isUsuarioNaoCadastrado) {
                CadastroBO.cadastrarUsuario(name, username, password);
            }
        }

        return true;
    }
}
