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
    File file;
    FileInputStream instream;
    DataInputStream dataFile;

    String line;
    StringTokenizer stringTok;

    public DataLoader(ArrayList<User> users)
    {
        try
        {
            file = new File("src/UserData.txt");
            instream = new FileInputStream(file);
            dataFile = new DataInputStream(instream);
            
            for (int i = 0; i < 55; i++)
            {
                line = (String) dataFile.readLine();
                
                User user = new User(line);
                
                line = (String) dataFile.readLine();
                
                stringTok = new StringTokenizer(line); 
                
                while (stringTok.hasMoreTokens())
                {
                    user.getRecommendations().addRating(stringTok.nextToken());        
                }
                
                users.add(user);
            }
            instream.close();
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