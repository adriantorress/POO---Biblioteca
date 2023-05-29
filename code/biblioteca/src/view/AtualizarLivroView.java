package view;
import java.util.Scanner;
import bo.AdminBO;
import model.Livro;


public class AtualizarLivroView {

  public String exibirMenu(Scanner scanner) {
    System.out.println("\n----- Atualizar - Livro -----");
    System.out.println("---- 0 - Voltar ----");
    System.out.println();
    System.out.println("1. Atualizar Titulo");
    System.out.println("2. Atualizar Autor");
    System.out.println("3. Atualizar Cargo");
    System.out.println("4. Atualizar Isbn");
    System.out.println("5. Atualizar Ano de Publicacao");
    System.out.println("6. Atualizar Quantidade Disponivel");
    System.out.println("7. Atualizar Status");
    System.out.print("\nEscolha uma opção: ");

    String opcao = scanner.nextLine();
    return opcao;
  }

  public Livro exibirFormulario(Scanner scanner) {
    String opcao;
    boolean isCamposVazios;
    boolean isLivroCadastrado;
    String livro;

    do {
      System.out.println("\n---- Atualizar Livro ----");
      System.out.println("---- 0 - Voltar ----");

      System.out.print("\nISBN do Livro: ");
      livro = scanner.nextLine();
      if (livro.equals("0")) {
        return null;
      }

      isCamposVazios = livro.isEmpty();
      isLivroCadastrado = AdminBO.verificarLivroCadastrado(livro);

      if (isCamposVazios) {
        System.out.println("\nPreencha o campo!");
      }

      else if (!isLivroCadastrado) {
        System.out.println("\nLivro não encontrado!");
      }
    } while (isCamposVazios || !isLivroCadastrado);

    do {
    if (!isCamposVazios && isLivroCadastrado) {
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

  } while (!isCamposVazios && isLivroCadastrado);

    return AdminBO.buscarLivro(livro);

  }
}
