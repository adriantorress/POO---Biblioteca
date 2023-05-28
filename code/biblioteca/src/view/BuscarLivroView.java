package view;
import java.util.Scanner;
import bo.AdminBO;
import model.Livro;

public class BuscarLivroView {
  
  public Livro exibirFormulario(Scanner scanner) {
    System.out.println("\n---- Buscar Usuário ----");
    System.out.println("---- 0 - Voltar ----");

    System.out.print("ISBN do Livro: ");
    String isbn = scanner.nextLine();
    if (isbn.equals("0")) {
      return null;
    }

    boolean isCamposVazios = isbn.isEmpty();

    if (!isCamposVazios) {
      return AdminBO.buscarLivro(isbn);
    }

    while (!isCamposVazios) {
      System.out.println("\n---- Buscar Usuario ----");
      System.out.println("---- 0 - Voltar ----");

      System.out.print("ISBN do Livro: ");
      isbn = scanner.nextLine();
      if (isbn.equals("0")) {
        return null;
      }

      isCamposVazios = isbn.isEmpty();
     

      if (!isCamposVazios) {
        return AdminBO.buscarLivro(isbn);
      }
    }
    
    return AdminBO.buscarLivro(isbn);

  }
}
