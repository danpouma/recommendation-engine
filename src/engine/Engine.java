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
        //user2 = users.get(1);
        
        int matches = 0;
        for (int people = 1; people < 55; people++)
        {
            // Comparing user1 to every other person
            user2 = users.get(people);
            for (int rating = 0; rating < 55; rating++)
            {   
                
                ArrayList user1Ratings = user1.getRatings();
                ArrayList user2Ratings = user2.getRatings();

                if (user1Ratings.get(rating).equals(user2Ratings.get(rating)))
                {
                    matches++;
                }
                else
                {
                    // do nothing
                }
            }
            
            System.out.println("Matches found: " + matches);
            matches = 0;
        }
    }
}
