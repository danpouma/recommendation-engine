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

    ArrayList users;
    ArrayList ratings;

    public UsersDataLoader()
    {
        users = new ArrayList();

        try
        {
            userRatingFile = new File("./UserData.txt");
            instream = new FileInputStream(userRatingFile);
            userData = new DataInputStream(instream);

            while (instream.available() > 0)
            {
                line = (String) userData.readLine();

                User user = new User();

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

                // Give ratings to user
                user.setRatings(ratings);

                // Add user to users
                users.add(user);
            }

            // Close the streams
            instream.close();
            userData.close();
        }
        catch (Exception e)
        {
            System.out.println("Error");
        }
    }

    public ArrayList getUsers()
    {
        return users;
    }

    public ArrayList getRatings()
    {
        return ratings;
    }
}
