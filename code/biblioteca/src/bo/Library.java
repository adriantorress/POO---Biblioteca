package bo;

import dao.UserDAO;
import model.Book;
import model.User;
import dao.BookDAO;
import dao.LoanDAO;
import java.util.List;

public class Library {

    public static User login(String username, String password) {
        boolean credentials = UserDAO.checkCredentials(username, password);
        if (credentials)
            return UserDAO.catchOne(username);
        return null;
    }

    public static boolean register(String name, String username, String password) {
        if (!verifyUserRegistered(username))
            return UserDAO.register(name, username, password);
        return false;
    }

    public static boolean checkCredentials(String username, String password) {
        return UserDAO.checkCredentials(username, password);
    }

    public static boolean verifyUserRegistered(String username) {
        return UserDAO.verifyRegistered(username);
    }

    public static boolean verifyBookRegistered(String isbn) {
        return BookDAO.verifyRegistered(isbn);
    }

    public static boolean verifyLoan(String username, String isbn) {
        return LoanDAO.verify(username, isbn);
    }

    public static List<Book> availableBooks() {
        return BookDAO.availables();
    }
}
