package view;
import java.util.Scanner;

public class AdminView {
    private Scanner scanner;

    public AdminView() {
        scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        System.out.println("----- Biblioteca -----");
        System.out.println("1. Cadastrar livro");
        System.out.println("2. Atualizar livro");
        System.out.println("3. Excluir livro");
        System.out.println("4. Buscar livro");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public int lerOpcao() {
        return scanner.nextInt();
    }
}
