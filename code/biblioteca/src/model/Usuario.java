package model;

public class Usuario {
  private String nome;
  private String usuario;
  private String cargo;
  private String endereco;
  private String email;
  private String telefone;
  private String status;

  public Usuario(String usuario, String nome, String cargo, String endereco,
      String email, String telefone, String status) {
    this.usuario = usuario;
    this.nome = nome;
    this.cargo = cargo;
    this.endereco = endereco;
    this.email = email;
    this.status = status;
    this.telefone = telefone;
  }

  public String getUsuario() {
    return this.usuario;
  }

  public String getNome() {
    return nome;
  }

  public String getCargo() {
    return this.cargo;
  }

  public String getEndereco() {
    return this.endereco;
  }

  public String getEmail() {
    return this.email;
  }

  public String getTelefone() {
    return this.telefone;
  }

  public String getStatus() {
    return status;
  }
}