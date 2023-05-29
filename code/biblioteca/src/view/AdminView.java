package view;

import java.util.Scanner;
import model.Usuario;
import model.Livro;

public class AdminView {
    private Usuario usuario;
    private Scanner scanner;

    public AdminView(Usuario usuario) {
        this.usuario = usuario;
    }

    public String exibirMenu(Scanner scanner) {
        String opcao;
        boolean isCamposVazios;
        do {
            System.out.println("\n----- Biblioteca - Administração -----");
            System.out.printf("\n----- Olá %s -----", this.usuario.getNome());
            System.out.println();
            System.out.println();
            System.out.println("1. Cadastrar livro");
            System.out.println("2. Atualizar livro");
            System.out.println("3. Excluir livro");
            System.out.println("4. Buscar livro");
            System.out.println("5. Atualizar usuário");
            System.out.println("6. Excluir usuário");
            System.out.println("7. Buscar usuário");
            System.out.println("8. Deslogar");
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
                CadastroLivroView cadastroLivroView = new CadastroLivroView();
                cadastroLivroView.exibirFormulario(scanner);
                break;
            case "2":
                AtualizarLivroView atualizarLivroView = new AtualizarLivroView();
                atualizarLivroView.exibirFormulario(scanner);
                break;
            case "3":
                ExcluirLivroView excluirLivroView = new ExcluirLivroView();
                excluirLivroView.exibirFormulario(scanner);
                break;
            case "4":
                BuscarLivroView buscarLivroView = new BuscarLivroView();
                Livro book = buscarLivroView.exibirFormulario(scanner);

                if (book != null) {

                    System.out.printf("\nTitulo: %s", book.getTitulo());
                    System.out.println("");

                    System.out.printf("Autor: %s", book.getAutor());
                    System.out.println("");

                    System.out.printf("Ano de Publicacao: %s", book.getAnoPublicacao());
                    System.out.println("");

                    System.out.printf("Categoria: %s", book.getCategoria());
                    System.out.println("");

                    System.out.printf("Quantidade Disponivel: %s", book.getQuantidadeDisponivel());
                    System.out.println("");

                    System.out.printf("Data de Cadastro: %s", book.getDataCadastro());
                    System.out.println("");

                    System.out.printf("Status: %s", book.getStatus());
                    System.out.println("");
                } else {
                    System.out.println("\nLivro não encontrado");
                }
                break;
            case "5":
                AtualizarUsuarioView atualizarUsuarioView = new AtualizarUsuarioView();
                atualizarUsuarioView.exibirFormulario(scanner);
                break;
            case "6":
                ExcluirUsuarioView excluirUsuarioView = new ExcluirUsuarioView();
                excluirUsuarioView.exibirFormulario(scanner);
                break;
            case "7":
                BuscarUsuarioView buscarUsuarioView = new BuscarUsuarioView();
                Usuario user = buscarUsuarioView.exibirFormulario(scanner);

                if (user != null) {

                    System.out.printf("\nNome: %s", user.getNome());
                    System.out.println("");

                    System.out.printf("Cargo: %s", user.getCargo());
                    System.out.println("");

                    System.out.printf("Endereço: %s", user.getEndereco());
                    System.out.println("");

                    System.out.printf("E-mail: %s", user.getEmail());
                    System.out.println("");

                    System.out.printf("Telefone: %s", user.getTelefone());
                    System.out.println("");

                    System.out.printf("Status: %s", user.getStatus());
                    System.out.println("");
                } else {

                    System.out.println("\nUsuário não encontrado");
                }
                break;
        }
    }

}
