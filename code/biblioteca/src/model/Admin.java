package model;

import dao.UserDAO;
import dao.BookDAO;
import java.util.List;

public class Admin extends User {

  public Admin(String username, String name, String address,
      String email, String phone, String status) {
    super(username, name, "ADMINISTRADOR");
  }

  public static boolean registerBook(String title, String author, String isbn, String publicationYear,
      String category) {
    if (!BookDAO.verifyRegistered(isbn))
      return BookDAO.register(title, author, isbn, publicationYear, category);
    return false;
  }

  public static boolean updateBook(String isbn, String attribute, String newValue) {
    return BookDAO.update(isbn, attribute, newValue);
  }

  public static boolean updateBook(String isbn, String attribute, int newValue) {
    return BookDAO.update(isbn, attribute, newValue);
  }

  public static boolean deleteBook(String isbn) {
    return BookDAO.delete(isbn);
  }

  public static Book findBook(String book) {
    if (BookDAO.verifyRegistered(book)) {
      return BookDAO.findOne(book);
    }
    return null;
  }

  public static List<Book> findBooks() {
    return BookDAO.find();
  }

  public static boolean updateUser(String username, String attribute, String newValue) {
    return UserDAO.update(username, attribute, newValue);
  }

  public static boolean deleteUser(String username) {
    return UserDAO.delete(username);
  }

  public static User findUser(String username) {
    if (UserDAO.verifyRegistered(username))
      return UserDAO.findOne(username);
    return null;
  }

  public static List<User> findUsers() {
    return UserDAO.find();
  }
}
