/*
Build a system to be able to recommend books to a user. Think NetFlix or Amazon. 
You need to be able to enter book information, ratings, users etc. Use one of 
two basic models to find a recommendation.

Model #1: Find another user most like the current user and recommend 
books they liked.

Model #2: Rate the book for various facets (author, genre etc.) and find out 
how it matches to the readers past recommendations.

We will discuss this in class and there are several readings in the 
Recommendation Engine Folder.

You should build a minimal working version first and then think about revisions.
 */
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
        
        // Simple comparison - can make a class that does this in the end
        User user1;
        User user2;
        
        // Get users from list
        user1 = users.get(0);
        
        // Make this load data into another class
        MatchFinder matchFinder = new MatchFinder(user1, users);
        
        // Display users via gui
        EngineGui usersGUI = new EngineGui(users, books);
        usersGUI.showFrameDemo();
    }
}
