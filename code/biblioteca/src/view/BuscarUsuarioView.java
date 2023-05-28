package view;

import java.util.Scanner;
import bo.AdminBO;
import model.Usuario;

public class BuscarUsuarioView {

  public Usuario exibirFormulario(Scanner scanner) {
    System.out.println("\n---- Buscar Usuário ----");
    System.out.println("---- 0 - Voltar ----");

    System.out.print("Usuário: ");
    String usuario = scanner.nextLine();
    if (usuario.equals("0")) {
      return null;
    }

    boolean isCamposVazios = usuario.isEmpty();
  

    if (!isCamposVazios) {
      return AdminBO.buscarUsuario(usuario);
    }

    while (!isCamposVazios) {
      System.out.println("\n---- Buscar Usuario ----");
      System.out.println("---- 0 - Voltar ----");

      System.out.print("Usuario: ");
      usuario = scanner.nextLine();
      if (usuario.equals("0")) {
        return null;
      }

      isCamposVazios = usuario.isEmpty();


      if (!isCamposVazios) {
        return AdminBO.buscarUsuario(usuario);
      }
    }
    
    return AdminBO.buscarUsuario(usuario);

  }
}
