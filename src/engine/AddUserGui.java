package engine;

import java.util.ArrayList;
import javax.swing.*;

public class AddUserGui
{

    public AddUserGui(ArrayList<User> users, ArrayList<Book> books)
    {
        String username = "";
        boolean validUsername = false;

        do
        {
            username = (String) JOptionPane.showInputDialog(
                    null,
                    "Enter username",
                    "Add a new user",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "Enter username...");
            if (username != null && !alreadyTaken(username, users))
            {
                validUsername = true;
            }
            else
            {
                validUsername = false;
            }
        } while (!validUsername);

        User user = new User(username);

        // Set each rating to 0 by default
        for (int bookRating = 0; bookRating < books.size(); bookRating++)
        {
            user.addRating(0);
        }

        users.add(user);
    }

    private boolean alreadyTaken(String username, ArrayList<User> users)
    {
        boolean alreadyTaken = false;

        for (User user : users)
        {
            if (user.getUsername().equals(username))
            {
                alreadyTaken = true;
            }
        }

        return alreadyTaken;
    }
}
