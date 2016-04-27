package engineTest;

import engine.Book;
import engine.BooksDataLoader;
import engine.User;
import engine.UsersDataLoader;
import engine.UsersGui;
import java.util.ArrayList;

/**
 *
 * @author dpoumakis
 */
public class UsersGuiTest
{
    public static void main(String[] args)
    {
        UsersDataLoader loader = new UsersDataLoader();
        BooksDataLoader bookLoader = new BooksDataLoader();
        
        ArrayList<User> users = loader.getUsers();
        ArrayList<Book> books = bookLoader.getBooks();
        
        
        UsersGui usersGUI = new UsersGui(users, books);
        
        usersGUI.showFrameDemo();
    }
}
