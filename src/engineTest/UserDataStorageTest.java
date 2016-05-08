package engineTest;

import engine.User;
import engine.UserDataStorage;
import engine.UsersDataLoader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dpoumakis
 */
public class UserDataStorageTest
{
    public static void main(String[] args)
    {
        UsersDataLoader loader = new UsersDataLoader();
        
        ArrayList<User> users = loader.getUsers();
        
        try
        {
            UserDataStorage dataStore = new UserDataStorage(users);
        }
        catch (IOException ex)
        {
            Logger.getLogger(UserDataStorageTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
