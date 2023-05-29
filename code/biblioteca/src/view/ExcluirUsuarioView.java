package view;

import java.util.Scanner;
import bo.AdminBO;

public class ExcluirUsuarioView {

  public void exibirFormulario(Scanner scanner) {
    boolean isCamposVazios;
    boolean isUsuarioCadastrado;
    String usuario;
    do {
      System.out.println("\n---- Excluir Usuário ----");
      System.out.println("---- 0 - Voltar ----");

      System.out.print("Usuário: ");
      usuario = scanner.nextLine();
      if (usuario.equals("0")) {
        break;
      }

      isCamposVazios = usuario.isEmpty();
      isUsuarioCadastrado = AdminBO.isUsuarioCadastrado(usuario);

      if (isCamposVazios) {
        System.out.println("\nPreencha o campo!");
      }

      else if (!isUsuarioCadastrado) {
        System.out.println("\nUsuário não encontrado!");
      }

    } while (isCamposVazios || !isUsuarioCadastrado);

    if (!usuario.equals("0"))
      AdminBO.excluirUsuario(usuario);

  }
}
