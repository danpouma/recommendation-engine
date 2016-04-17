package engineTest;

import engine.User;
import engine.UsersDataLoader;
import java.util.ArrayList;
/**
 *
 * @author dpoumakis
 */
public class UsersDataLoaderTest
{
    public static void main(String[] args)
    {
        UsersDataLoader loader = new UsersDataLoader();
        
        ArrayList<User> users = loader.getUsers();
        
        for (int i = 0; i < users.size(); i++)
        {
            System.out.print(users.get(i).getUsername() + " => ");
            System.out.println(users.get(i).getRatings().size());
        }
    }
}
 