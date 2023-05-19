package view;
import java.util.Scanner;

public class BibliotecarioView {
    private Scanner scanner;

    public BibliotecarioView() {
        scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        System.out.println("----- Bibliotecario -----");
        System.out.println("1. Cadastrar membro");
        System.out.println("2. Atualizar membro");
        System.out.println("3. Excluir membro");
        System.out.println("4. Buscar membro");
        System.out.println("5. Cadastrar livro");
        System.out.println("6. Atualizar livro");
        System.out.println("7. Excluir livro");
        System.out.println("8. Buscar livro");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public int lerOpcao() {
        return scanner.nextInt();
    }
}
