package vo;

public class Usuario {
  private int id;
  private String nome;
  private String username;

  public Usuario(int id, String nome, String username) {
    this.id = id;
    this.nome = nome;
    this.username = username;
  }

  public int getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public String getUsername() {
    return username;
  }
}