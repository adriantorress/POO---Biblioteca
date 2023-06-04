package view;

import java.util.Scanner;

public class AdminView {
    private Scanner scanner;

    public String showMenu(Scanner scanner) {
        String option = null;
        boolean isEmpty = true;
        while (isEmpty) {
            System.out.println("\nAdministração");
            System.out.println("1. Cadastrar livro");
            System.out.println("2. Atualizar livro");
            System.out.println("3. Excluir livro");
            System.out.println("4. Buscar livro");
            System.out.println("5. Todos os livros");
            System.out.println("6. Atualizar usuário");
            System.out.println("7. Excluir usuário");
            System.out.println("8. Buscar usuário");
            System.out.println("9. Todos os usuários");
            System.out.println("10. Deslogar");
            System.out.println("0. Finalizar Programa");
            System.out.print("\nEscolha uma opção: ");
            option = scanner.nextLine();
            isEmpty = option.isEmpty();
            if (isEmpty) {
                System.out.println("\nSelecione algo...");
                continue;
            } else {
                this.scanner = scanner;
                break;
            }
        }
        return option;
    }

    public void callBoMethod(String option) {
        switch (option) {
            case "1":
                RegisterBookView signUpBookView = new RegisterBookView();
                signUpBookView.showForm(scanner);
                break;
            case "2":
                UpdateBookView updateBookView = new UpdateBookView();
                updateBookView.showForm(scanner);
                break;
            case "3":
                DeleteBookView deleteBookView = new DeleteBookView();
                deleteBookView.showForm(scanner);
                break;
            case "4":
                FindBookView findBookView = new FindBookView();
                findBookView.showForm(scanner);
                break;
            case "5":
                FindBooksView findBooksView = new FindBooksView();
                findBooksView.showBooks();
                break;
            case "6":
                UpdateUserView updateUserView = new UpdateUserView();
                updateUserView.showForm(scanner);
                break;
            case "7":
                DeleteUserView deleteUserView = new DeleteUserView();
                deleteUserView.showForm(scanner);
                break;
            case "8":
                FindUserView findUserView = new FindUserView();
                findUserView.showForm(scanner);
                break;
            case "9":
            FindUsersView findUsersView = new FindUsersView();
            findUsersView.showUsers();
        }
    }
}
