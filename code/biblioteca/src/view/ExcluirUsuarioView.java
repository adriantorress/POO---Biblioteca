package view;

import java.util.Scanner;
import bo.AdminBO;

public class ExcluirUsuarioView {

  public boolean exibirFormulario(Scanner scanner) {
    System.out.println("\n---- Excluir Usuário ----");
    System.out.println("---- 0 - Voltar ----");

    System.out.print("Usuário: ");
    String usuario = scanner.nextLine();
    if (usuario.equals("0")) {
      return false;
    }

    boolean isCamposVazios = usuario.isEmpty();
    boolean isUsuarioNaoCadastrado = AdminBO.isUsuarioNaoCadastrado(usuario);

    if (!isCamposVazios && isUsuarioNaoCadastrado) {
      AdminBO.excluirUsuario(usuario);
    }

    while (!(isCamposVazios && isUsuarioNaoCadastrado)) {
      System.out.println("\n---- Excluir Usuario ----");
      System.out.println("---- 0 - Voltar ----");

      System.out.print("Usuario: ");
      usuario = scanner.nextLine();
      if (usuario.equals("0")) {
        return false;
      }

      isCamposVazios = usuario.isEmpty();
      isUsuarioNaoCadastrado = AdminBO.isUsuarioNaoCadastrado(usuario);

      if (!isCamposVazios && isUsuarioNaoCadastrado) {
        AdminBO.excluirUsuario(usuario);
      }
    }
    return true;

  }
}
