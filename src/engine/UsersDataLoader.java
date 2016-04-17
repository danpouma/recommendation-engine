package engine;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author dpoumakis
 */
public class UsersDataLoader
{
    File userRatingFile;
    FileInputStream instream;
    DataInputStream userData;
    String line;
    StringTokenizer stringTok;
    
    User user;
    ArrayList ratings;
        
    public UsersDataLoader()
    {
        try
        {
            userRatingFile = new File("src/UserData.txt");
            instream = new FileInputStream(userRatingFile);
            userData = new DataInputStream(instream);
            
            for (int i = 0; i < 55; i++)
            {   
                line = (String) userData.readLine();
                
                user = new User();
                
                stringTok = new StringTokenizer(line);
                
                // Get the user name
                user.setUsername(stringTok.nextToken(","));
                
                // Store names via arraylist for now
                ratings = new ArrayList();
                
                // Grab each rating
                while (stringTok.hasMoreTokens())
                {  
                    String rating = stringTok.nextToken(" ");
                    rating = rating.replace(",", "");
                    
                    if (rating == " " || rating == "")
                    {
                        // do nothing
                    }
                    else
                    {
                        // Add rating to arraylist
                        ratings.add(rating);
                    }                   
                }
                
                // Bug where first elem is nothing
                // this fixes it for now :P
                ratings.remove(0);
            }
            
            // Close the streams
            instream.close();
            userData.close();
        } 
        catch (Exception e)
        {
            System.out.println(e);
            System.out.println("Error");
        }
        
       // Output ratings
        System.out.println(user.getUsername());
        System.out.println(ratings.size());
        
        System.out.println("first elem: " + ratings.get(0));
        for (Object rating : ratings)
        {
            System.out.println(rating);
        } 
    }
}
