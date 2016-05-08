package engine;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dpoumakis
 */
public class UserDataStorage
{
    public UserDataStorage(ArrayList<User> users) throws IOException
    {
        FileWriter fileWriter = null;
        
        try
        {
            fileWriter = new FileWriter("src/UserData.txt");
        }
        catch (IOException ex)
        {
            Logger.getLogger(UserDataStorage.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (User user : users)
        {
            if (fileWriter != null)
            {
                try
                {
                    fileWriter.write(user.toString());
                    fileWriter.write('\n');
                }
                catch (IOException ex)
                {
                    Logger.getLogger(UserDataStorage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        fileWriter.close();

    }
}
