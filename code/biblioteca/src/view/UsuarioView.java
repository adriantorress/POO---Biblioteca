package view;

import java.util.Scanner;

import model.Usuario;
import bo.UsuarioBO;
import model.Livro;
import java.util.List;
import bo.EmprestimoBO;
import model.Emprestimo;

public class UsuarioView {
  private Usuario usuario;
  private Scanner scanner;

  public UsuarioView(Usuario usuario) {
    this.usuario = usuario;
  }

  public String exibirMenu(Scanner scanner) {
    String opcao;
    boolean isCamposVazios;
    do {
      System.out.println("\n----- Biblioteca - Membro -----");
      System.out.printf("\n----- Olá %s -----", this.usuario.getNome());
      System.out.println();
      System.out.println();
      System.out.println("1. Novo Empréstimo");
      System.out.println("2. Meus Empréstimos");
      System.out.println("3. Livros Disponíveis");
      System.out.println("4. Devolver Livros");
      System.out.println("5. Deslogar");
      System.out.println("0. Finalizar Programa");
      System.out.print("\nEscolha uma opção: ");

      opcao = scanner.nextLine();

      isCamposVazios = opcao.isEmpty();

      if (isCamposVazios) {
        System.out.println("\nSelecione algo...");
      }
    } while (isCamposVazios);
    this.scanner = scanner;
    return opcao;

  }

  public void boMethod(String option) {
    switch (option) {
      case "1":
        EmprestimoLivroView emprestimoLivroView = new EmprestimoLivroView();
        emprestimoLivroView.exibirFormulario(scanner, usuario);
        break;
      case "2":
        List<Emprestimo> listaEmprestimos = UsuarioBO.meusEmprestimos(usuario);
        System.out.println();
        if (listaEmprestimos.size() > 0) {
          System.out.println("Meus Empréstimos:");
          for (Emprestimo emprestimo : listaEmprestimos) {
            System.out.println();
            System.out.printf("Título: %s", emprestimo.getTitulo());
            System.out.println();
            System.out.println("-------------------");
            System.out.println();

            System.out.printf("ISBN: %s", emprestimo.getIsbn());
            System.out.println();
            System.out.println("-------------------");
            System.out.println();

            System.out.printf("Data do Empréstimo: %s", emprestimo.getDataEmprestimo());
            System.out.println();
            System.out.println("-------------------");
            System.out.println();

            System.out.printf("Data de Devolução: %s", emprestimo.getDataDevolucao());
            System.out.println();
            System.out.println("-------------------");
            System.out.println();

            System.out.printf("Status: %s", emprestimo.getStatus());
            System.out.println();
            System.out.println("-------------------");
            System.out.println();
            System.out.println();
            System.out.println("--------------------------------------------------------------------------");
            System.out.println();
          }
        } else {
          System.out.println("Você não possui nenhum Empréstimo!");
        }
        break;
      case "3":
        List<Livro> livrosDisponiveis = EmprestimoBO.livrosDisponiveis();
        System.out.println();
        if (livrosDisponiveis.size() > 0) {
          System.out.println("Livros Disponíveis:");
          for (Livro livro : livrosDisponiveis) {

            System.out.println();
            System.out.printf("ISBN: %s", livro.getIsbn());

            System.out.printf("\nTitulo: %s", livro.getTitulo());
            System.out.println();

            System.out.printf("Autor: %s", livro.getAutor());
            System.out.println();

            System.out.printf("Ano de Publicacao: %s", livro.getAnoPublicacao());
            System.out.println();

            System.out.printf("Categoria: %s", livro.getCategoria());
            System.out.println();
          }
        } else {
          System.out.println("Nenhum Livro Disponível!");
        }
        break;
      case "4":
        List<Emprestimo> lEmprestimos = UsuarioBO.meusEmprestimos(usuario);
        System.out.println();

        if (lEmprestimos.size() > 0) {
          System.out.println("Meus Empréstimos:");
          for (Emprestimo emprestimo : lEmprestimos) {
            System.out.println();
            System.out.printf("Título: %s", emprestimo.getTitulo());
            System.out.println();

            System.out.printf("ISBN: %s", emprestimo.getIsbn());
            System.out.println();
            System.out.println("-------------------");
            System.out.println();
          }
          System.out.println();
          System.out.println();
          DevolverLivroView devolverLivroView = new DevolverLivroView();
          devolverLivroView.exibirFormulario(scanner, usuario.getUsuario());
        } else {
          System.out.println("Você não possui nenhum Empréstimo!");
        }

        break;

    }
  }

}
