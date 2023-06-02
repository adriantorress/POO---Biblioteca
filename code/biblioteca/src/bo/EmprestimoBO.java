package bo;

import model.Usuario;
import dao.EmprestimoDAO;
import model.Livro;
import java.util.List;

public class EmprestimoBO {
  public static boolean realizarEmprestimo(Usuario usuario, String isbn) {
    boolean isAtivo = usuario.getStatus().equals("ATIVO");
    boolean isQuantidadeDisponivel = (Integer.parseInt(AdminBO.buscarLivro(isbn).getQuantidadeDisponivel())) > 0;
    if (!isAtivo)
      System.out.println("Usuário não ativo!");
    if (!isQuantidadeDisponivel)
      System.out.println("Livro indisponível");

    if (isAtivo && isQuantidadeDisponivel) {
      EmprestimoDAO.realizarEmprestimo(usuario, isbn);
      EmprestimoDAO.atualizarLivro(isbn, "-", "INDISPONIVEL");
      return true;
    } else {
      return false;
    }
  }

  public static boolean devolverLivro(String usuario, String isbn) {
    EmprestimoDAO.devolverLivro(usuario, isbn);
    EmprestimoDAO.atualizarLivro(isbn, "+", "DISPONIVEL");
    return true;

  }

  public static boolean verificarEmprestimo(String usuario, String isbn) {
    if (EmprestimoDAO.verificarEmprestimo(usuario, isbn)) {
      return true;
    }
    return false;
  }

  public static List<Livro> livrosDisponiveis() {
    return EmprestimoDAO.livrosDisponiveis();
  }
}
