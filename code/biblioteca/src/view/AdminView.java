package view;

import java.util.Scanner;
import model.Usuario;

public class AdminView {
    private Usuario usuario;
    private Scanner scanner;

    public AdminView(Usuario usuario) {
        this.usuario = usuario;
    }

    public void exibirMenu() {
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
    }

    public String lerOpcao(Scanner scanner) {
        this.scanner = scanner;
        return scanner.nextLine();
    }

    public void boMethod(String option) {
        switch (option) {
            case "1":
                CadastroLivroView cadastroLivroView = new CadastroLivroView();
                cadastroLivroView.exibirFormulario(scanner);
                break;
            case "2":
                break;
            case "3":
                ExcluirLivroView excluirLivroView = new ExcluirLivroView();
                excluirLivroView.exibirFormulario(scanner);
                break;
            case "4":
                break;
            case "5":
                break;
            case "6":
                ExcluirUsuarioView excluirUsuarioView = new ExcluirUsuarioView();
                excluirUsuarioView.exibirFormulario(scanner);
                break;
            case "7":
                break;
        }
    }

}
