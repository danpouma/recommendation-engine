package engine;

import java.util.ArrayList;

/**
 *
 * @author dpoumakis
 */
public class Engine
{

    public static void main(String[] args)
    {
        // Create lists
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();

        // Load data
        BooksDataLoader bookData = new BooksDataLoader();
        UsersDataLoader userData = new UsersDataLoader();

        // Store data
        books = bookData.getBooks();
        users = userData.getUsers();

        // Output size of the lists... Should be 55 each
        System.out.println("Number of books: " + books.size());
        System.out.println("Number of users: " + users.size());
        

        // Make this load data into another class
        MatchFinder matchFinder = new MatchFinder(users);

        // Display users via gui
        EngineGui engineGUI = new EngineGui(users, books);
        engineGUI.showFrameDemo();
    }
}
