package engineTest;

import engine.AddBookGui;
import engine.AddUserGui;
import engine.Book;
import engine.BookDataCollector;
import engine.BooksDataLoader;
import engine.User;
import engine.UserDataCollector;
import engine.UsersDataLoader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dpoumakis
 */
public class AddBookGuiTest
{
    public static void main(String[] args)
    {
        UsersDataLoader usersLoader = new UsersDataLoader();
        ArrayList<User> users = usersLoader.getUsers();

        BooksDataLoader booksLoader = new BooksDataLoader();
        
        ArrayList<Book> books = booksLoader.getBooks();

        AddBookGui addBook = new AddBookGui(users, books);
        
        try
        {
            UserDataCollector userDataStore = new UserDataCollector(users);
            BookDataCollector bookDataStore = new BookDataCollector(books);
        }
        catch (IOException ex)
        {
            Logger.getLogger(AddBookGuiTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
