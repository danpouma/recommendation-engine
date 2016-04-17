package engine;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 *
 * @author dpoumakis
 */
public class DataLoader
{
    File userRatingFile;
    File booksFile;
    
    FileInputStream userRatingStream;
    FileInputStream bookStream;
    
    DataInputStream userRatingDataFile;
    DataInputStream bookDataFile;

    String line;
    
    StringTokenizer stringTok;

    public DataLoader(ArrayList<User> users)
    {
        try
        {
            userRatingFile = new File("src/UserData.txt");
            booksFile = new File("src/BookList.txt");
            userRatingStream = new FileInputStream(userRatingFile);
            bookStream = new FileInputStream(booksFile);
            userRatingDataFile = new DataInputStream(userRatingStream);
            bookDataFile = new DataInputStream(bookStream);
            
            
            for (int i = 0; i < 55; i++)
            {
                line = (String) userRatingDataFile.readLine();
                
                User user = new User(line);
                
                line = (String) userRatingDataFile.readLine();
                
                stringTok = new StringTokenizer(line); 
                
                while (stringTok.hasMoreTokens())
                {
                    user.getRecommendations().addRating(stringTok.nextToken());        
                }
                
                String bookLine = (String) bookDataFile.readLine();
                Book book = new Book();
                stringTok = new StringTokenizer(bookLine);
                
                while (stringTok.hasMoreTokens())
                {
                    book.setAuthor(stringTok.nextToken(","));
                    String title = stringTok.nextToken("\n");
                    title = title.replace(",", "");
                    book.setTitle(title);
                }
                System.out.print(book.getAuthor() + "-->");
                System.out.println(book.getTitle());
                user.getRecommendations().addBook(book);
                users.add(user);
            }
            userRatingStream.close();
        } 
        catch (Exception e)
        {
            System.out.println(e);
            System.out.println("Error");
        }
        
        for (User user : users)
        {
            LinkedList ratings = user.getRecommendations().getRatings();
            System.out.print(user.getUsername() + "--> ");
            System.out.print(ratings.size());
            System.out.println(" ratings.");
        }

    }
}