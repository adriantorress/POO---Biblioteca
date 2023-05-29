package view;

import java.util.Scanner;
import bo.AdminBO;
import java.util.List;
import java.util.Arrays;

public class AtualizarLivroView {

  public String exibirMenu(Scanner scanner) {
    System.out.println("\n----- Atualizar - Livro -----");
    System.out.println("---- 0 - Voltar ----");
    System.out.println();
    System.out.println("1. Atualizar Titulo");
    System.out.println("2. Atualizar Autor");
    System.out.println("3. Atualizar Isbn");
    System.out.println("4. Atualizar Ano de Publicacao");
    System.out.println("5. Atualizar Categoria");
    System.out.println("6. Atualizar Quantidade Disponivel");
    System.out.println("7. Atualizar Status");
    System.out.print("\nEscolha uma opção: ");

    String opcao = scanner.nextLine();
    return opcao;
  }

  public void exibirFormulario(Scanner scanner) {
    String opcao;
    boolean isCamposVazios;
    boolean isLivroCadastrado;
    String livro;
    String novoValor;
    String[] options = new String[] { "0", "1", "2", "3", "4", "5", "6", "7" };
    List<String> options_list = Arrays.asList(options);

    do {
      System.out.println("\n---- Atualizar Livro ----");
      System.out.println("---- 0 - Voltar ----");

      System.out.print("\nISBN do Livro: ");
      livro = scanner.nextLine();
      if (livro.equals("0")) {
        break;
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

    if (!livro.equals("0")) {
      do {
        opcao = exibirMenu(scanner);
        if (opcao.isEmpty()) {
          System.out.println("\nSelecione algo...");
        } else {
          switch (opcao) {
            case "0":
              break;
            case "1":
              System.out.print("\nNovo Titulo: ");
              novoValor = scanner.nextLine();
              AdminBO.atualizarLivro(livro, "titulo", novoValor);
              break;
            case "2":
              System.out.print("\nNovo Autor: ");
              novoValor = scanner.nextLine();
              AdminBO.atualizarLivro(livro, "autor", novoValor);
              break;
            case "3":
              System.out.print("\nNovo ISBN: ");
              novoValor = scanner.nextLine();
              AdminBO.atualizarLivro(livro, "isbn", novoValor);
              break;

            case "4":
              System.out.print("\nNovo Ano de Publicacao: ");
              int novoValorInteiro = scanner.nextInt();
              AdminBO.atualizarLivro(livro, "ano_publicacao", novoValorInteiro);
              break;
            case "5":
              System.out.print("\nNovo Categoria: ");
              novoValor = scanner.nextLine();
              AdminBO.atualizarLivro(livro, "categoria", novoValor);
              break;
            case "6":
              System.out.print("\nNova Quantidade Disponivel: ");
              novoValorInteiro = scanner.nextInt();
              AdminBO.atualizarLivro(livro, "quantidade_disponivel", novoValorInteiro);
              break;
            case "7":
              System.out.print("\nNovo Status: ");
              novoValor = scanner.nextLine();
              AdminBO.atualizarLivro(livro, "status", novoValor);
              break;
            default:
              System.out.println("\nOpção inválida! tente novamente...");
          }
        }
      } while (opcao.isEmpty() || !options_list.contains(opcao));
    }
  }
}
