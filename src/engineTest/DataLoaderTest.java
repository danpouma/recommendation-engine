package engineTest;

import engine.DataLoader;
import engine.User;
import java.util.ArrayList;

/**
 *
 * @author dpoumakis
 */
public class DataLoaderTest
{
    public static void main(String[] args)
    {
        ArrayList<User> users = new ArrayList<>();
        
        DataLoader loader = new DataLoader(users);
    }
}
