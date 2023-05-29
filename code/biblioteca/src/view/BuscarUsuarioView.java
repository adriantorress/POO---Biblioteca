package view;

import java.util.Scanner;
import bo.AdminBO;
import model.Usuario;

public class BuscarUsuarioView {

  public Usuario exibirFormulario(Scanner scanner) {
    boolean isCamposVazios;
    String usuario;
    boolean isUsuarioCadastrado;
    do {
      System.out.println("\n---- Buscar Usuário ----");
      System.out.println("---- 0 - Voltar ----");

      System.out.print("\nUsuário: ");
      usuario = scanner.nextLine();
      if (usuario.equals("0")) {
        return null;
      }

      isCamposVazios = usuario.isEmpty();
      isUsuarioCadastrado = AdminBO.verificarUsuarioCadastrado(usuario);
      if (isCamposVazios)
        System.out.println("\nPreencha o campo...");
      else if (!isUsuarioCadastrado)
        System.out.println("\nUsuário não encontrado!");

    } while (isCamposVazios || !isUsuarioCadastrado);

    return AdminBO.buscarUsuario(usuario);

  }
}
