package engineTest;

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
public class UserDataCollectorTest
{
    public static void main(String[] args)
    {
        UsersDataLoader loader = new UsersDataLoader();
        
        ArrayList<User> users = loader.getUsers();
        
        try
        {
            UserDataCollector dataStore = new UserDataCollector(users);
        }
        catch (IOException ex)
        {
            Logger.getLogger(UserDataCollectorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
