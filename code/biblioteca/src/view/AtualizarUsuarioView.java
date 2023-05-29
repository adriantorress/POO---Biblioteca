package view;

import java.util.Scanner;
import bo.AdminBO;

import java.util.List;
import java.util.Arrays;

public class AtualizarUsuarioView {
  public String exibirMenu(Scanner scanner) {
    System.out.println("\n----- Atualizar - Usuário -----");
    System.out.println("---- 0 - Voltar ----");
    System.out.println();
    System.out.println("1. Atualizar Nome");
    System.out.println("2. Atualizar Username");
    System.out.println("3. Atualizar Senha");
    System.out.println("4. Atualizar Cargo");
    System.out.println("5. Atualizar Endereco");
    System.out.println("6. Atualizar Email");
    System.out.println("7. Atualizar Telefone");
    System.out.println("8. Atualizar Status");
    System.out.print("\nEscolha uma opção: ");

    String opcao = scanner.nextLine();
    return opcao;
  }

  public void exibirFormulario(Scanner scanner) {
    String opcao;
    boolean isCamposVazios;
    boolean isUsuarioCadastrado;
    String usuario;
    String novoValor;
    String[] options = new String[] { "0", "1", "2", "3", "4", "5", "6", "7" };
    List<String> options_list = Arrays.asList(options);

    do {
      System.out.println("\n---- Atualizar Usuário ----");
      System.out.println("---- 0 - Voltar ----");

      System.out.print("\nUsuário: ");
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

    if (!usuario.equals("0")) {
      do {
        opcao = exibirMenu(scanner);
        if (opcao.isEmpty()) {
          System.out.println("\nSelecione algo...");
        } else {
          switch (opcao) {
            case "0":
              break;
            case "1":
              System.out.print("\nNovo Nome: ");
              novoValor = scanner.nextLine();
              AdminBO.atualizarUsuario(usuario, "nome", novoValor);
              break;
            case "2":
              System.out.print("\nNovo Username: ");
              novoValor = scanner.nextLine();
              AdminBO.atualizarUsuario(usuario, "usuario", novoValor);
              break;
            case "3":
              System.out.print("\nNova Senha: ");
              novoValor = scanner.nextLine();
              AdminBO.atualizarUsuario(usuario, "senha", novoValor);
              break;

            case "4":
              System.out.print("\nNovo cargo: ");
              novoValor = scanner.nextLine();
              AdminBO.atualizarUsuario(usuario, "cargo", novoValor);
              break;
            case "5":
              System.out.print("\nNovo Endereço: ");
              novoValor = scanner.nextLine();
              AdminBO.atualizarUsuario(usuario, "endereco", novoValor);
              break;
            case "6":
              System.out.print("\nNova Email: ");
              novoValor = scanner.nextLine();
              AdminBO.atualizarUsuario(usuario, "email", novoValor);
              break;
            case "7":
              System.out.print("\nNovo Telefone: ");
              novoValor = scanner.nextLine();
              AdminBO.atualizarUsuario(usuario, "telefone", novoValor);
              break;
            case "8":
              System.out.print("\nNovo Status: ");
              novoValor = scanner.nextLine();
              AdminBO.atualizarUsuario(usuario, "status", novoValor);
              break;
            default:
              System.out.println("\nOpção inválida! tente novamente...");

          }
        }

      } while (opcao.isEmpty() || !options_list.contains(opcao));

    }

  }
}
