package engineTest;

import engine.User;
import engine.UsersDataLoader;
import engine.UsersGui;
import java.util.ArrayList;

/**
 *
 * @author dpoumakis
 */
public class UsersGuiTest
{
    public static void main(String[] args)
    {
        UsersDataLoader loader = new UsersDataLoader();
        
        ArrayList<User> users = loader.getUsers();
        
        UsersGui usersGUI = new UsersGui(users);
        
        usersGUI.showFrameDemo();
    }
}
