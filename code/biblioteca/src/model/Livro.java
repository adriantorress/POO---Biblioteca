package model;


public class Livro {
  private String titulo;
  private String autor;
  private String anoPublicacao;
  private String categoria;
  private String quantidadeDisponivel;
  private String dataCadastro;
  private String status;

  public Livro(String titulo, String autor, String anoPublicacao,
      String categoria, String quantidadeDisponivel, String dataCadastro, String status) {
    this.titulo = titulo;
    this.autor = autor;
    this.anoPublicacao = anoPublicacao;
    this.categoria = categoria;
    this.quantidadeDisponivel = quantidadeDisponivel;
    this.status = status;
    this.dataCadastro = dataCadastro;
  }

  public String getTitulo() {
    return this.titulo;
  }

  public String getAutor() {
    return autor;
  }

  public String getAnoPublicacao() {
    return this.anoPublicacao;
  }

  public String getCategoria() {
    return this.categoria;
  }

  public String getQuantidadeDisponivel() {
    return this.quantidadeDisponivel;
  }

  public String getDataCadastro() {
    return this.dataCadastro;
  }

  public String getStatus() {
    return status;
  }
}