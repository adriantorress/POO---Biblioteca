package model;

public class Loan {
    private String user;
    private String loanDate;
    private String title;
    private String returnDate;
    private String status;
    private String isbn;

    public Loan(String user, String isbn) {
        this.user = user;
        this.isbn = isbn;
    }

    public Loan(String title, String isbn,
            String loanDate, String returnDate, String status) {
        this.title = title;
        this.isbn = isbn;
        this.loanDate = loanDate;
        this.status = status;
        this.returnDate = returnDate;
    }

    public String getUser() {
        return this.user;
    }

    public String getTitle() {
        return this.title;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public String getLoanDate() {
        return this.loanDate;
    }

    public String getReturnDate() {
        return this.returnDate;
    }

    public String getStatus() {
        return this.status;
    }

}