package view;

import java.util.Scanner;
import model.Usuario;

public class AdminView {
    private Scanner scanner;
    private Usuario usuario;

    public AdminView(Usuario usuario) {
        this.usuario = usuario;
    }

    public void exibirMenu() {
        System.out.println("----- Biblioteca - Administração -----");
        System.out.printf("\n----- Olá %s -----", this.usuario.getNome());
        System.out.println();
        System.out.println("1. Cadastrar livro");
        System.out.println("2. Atualizar livro");
        System.out.println("3. Excluir livro");
        System.out.println("4. Buscar livro");
        System.out.println("2. Atualizar usuário");
        System.out.println("3. Excluir usuário");
        System.out.println("4. Buscar usuário");
        System.out.println("5. Deslogar");
        System.out.println("0. Finalizar Programa");
        System.out.print("Escolha uma opção: ");
    }

    public String lerOpcao(Scanner scanner) {
        return scanner.nextLine();
    }
}
