package view;

import java.util.Scanner;
import bo.AdminBO;
import model.Usuario;

public class AtualizarUsuarioView {

  public String exibirMenu(Scanner scanner) {
    System.out.println("\n----- Atualizar - Usuário -----");
    System.out.println("---- 0 - Voltar ----");
    System.out.println();
    System.out.println("1. Atualizar Nome");
    System.out.println("2. Atualizar Username");
    System.out.println("3. Atualizar Cargo");
    System.out.println("4. Atualizar Endereco");
    System.out.println("5. Atualizar Email");
    System.out.println("6. Atualizar Telefone");
    System.out.println("7. Atualizar Status");
    System.out.print("\nEscolha uma opção: ");

    String opcao = scanner.nextLine();
    return opcao;
  }

  public Usuario exibirFormulario(Scanner scanner) {
    String opcao;
    boolean isCamposVazios;
    boolean isUsuarioCadastrado;
    String usuario;

    do {
      System.out.println("\n---- Atualizar Usuário ----");
      System.out.println("---- 0 - Voltar ----");

      System.out.print("\nUsuário: ");
      usuario = scanner.nextLine();
      if (usuario.equals("0")) {
        return null;
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

    do {
    if (!isCamposVazios && isUsuarioCadastrado) {
      opcao = exibirMenu(scanner);
      switch (opcao) {
        case "0":
          return null;
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
        default:
          System.out.println("\nOpção inválida! tente novamente...");
      }
    }

  } while (!isCamposVazios && isUsuarioCadastrado);

    return AdminBO.buscarUsuario(usuario);

  }
}
