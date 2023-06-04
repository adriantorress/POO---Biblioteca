package model;

public class Book {
  private String title;
  private String author;
  private String publicationYear;
  private String category;
  private String availableQuantity;
  private String registerDate;
  private String status;
  private String isbn;


  public Book(String title, String author, String isbn,String publicationYear,
      String category, String availableQuantity, String registerDate, String status) {
    this.title = title;
    this.author = author;
    this.isbn = isbn;
    this.publicationYear = publicationYear;
    this.category = category;
    this.availableQuantity = availableQuantity;
    this.status = status;
    this.registerDate = registerDate;
  }

  public Book(String title, String isbn, String availableQuantity) {
    this.title = title;
    this.isbn = isbn;
    this.availableQuantity = availableQuantity;
  }

  public Book(String title, String isbn, String author, String publicationYear, String category) {
    this.title = title;
    this.author = author;
    this.isbn = isbn;
    this.publicationYear = publicationYear;
    this.category = category;
  }

  public String getTitle() {
    return this.title;
  }

  public String getIsbn() {
    return this.isbn;
  }

  public String getAuthor() {
    return this.author;
  }

  public String getPublicationYear() {
    return this.publicationYear;
  }

  public String getCategory() {
    return this.category;
  }

  public String getAvailableQuantity() {
    return this.availableQuantity;
  }

  public String getRegisterDate() {
    return this.registerDate;
  }

  public String getStatus() {
    return this.status;
  }
}