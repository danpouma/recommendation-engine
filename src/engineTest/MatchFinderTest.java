package engineTest;

import engine.MatchFinder;
import engine.User;
import engine.UsersDataLoader;
import java.util.ArrayList;

/**
 *
 * @author dpoumakis
 */
public class MatchFinderTest
{
    public static void main(String[] args)
    {
        User user;
        ArrayList<User> users = new ArrayList<>();
        UsersDataLoader userData = new UsersDataLoader();
        users = userData.getUsers();
        
        user = users.get(0);
        
        MatchFinder matchFinder;
        matchFinder = new MatchFinder(user, users);
    }
}
