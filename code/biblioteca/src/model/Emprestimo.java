package model;

public class Emprestimo {
    private String usuario;
    private String dataEmprestimo;
    private String titulo;
    private String dataDevolucao;
    private String status;
    private String isbn;

    public Emprestimo(String user, String isbn) {
        this.usuario = user;
        this.isbn = isbn;
    }

    public Emprestimo(String titulo, String isbn,
            String dataEmprestimo, String dataDevolucao, String status) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.dataEmprestimo = dataEmprestimo;
        this.status = status;
        this.dataDevolucao = dataDevolucao;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getIsbn() {
        return this.isbn;
    }


    public String getDataEmprestimo() {
        return this.dataEmprestimo;
    }

    public String getDataDevolucao() {
        return this.dataDevolucao;
    }

    public String getStatus() {
        return status;
    }

}