/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dpoumakis
 */
public class AddBookGui
{

    public AddBookGui(ArrayList<User> users, ArrayList<Book> books)
    {
        String authorName = "";
        boolean validAuthorName = false;
        do
        {
            authorName = (String) JOptionPane.showInputDialog(
                    null,
                    "Enter name of author",
                    "Add a new author",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "Enter name of book...");
            if (authorName != null)
            {
                validAuthorName = true;
            }
            else
            {
                validAuthorName = false;
            }
        } while (!validAuthorName);

        String bookName = "";
        boolean validBookName = false;

        do
        {
            bookName = (String) JOptionPane.showInputDialog(
                    null,
                    "Enter name of  book",
                    "Add a new book",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "Enter name of book...");
            if (bookName != null && !userAlreadyTaken(bookName, users))
            {
                validBookName = true;
            }
            else
            {
                validBookName = false;
            }
        } while (!validBookName);

        Book book = new Book(authorName, bookName);

        // Adding rating for each user 
        for (User user : users)
        {
            user.addRating(0);
        }

        books.add(book);
    }

    private boolean userAlreadyTaken(String username, ArrayList<User> users)
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

    private boolean bookAlreadyTaken(String bookName, ArrayList<Book> books)
    {
        boolean alreadyTaken = false;

        for (Book book : books)
        {
            if (book.getTitle().equals(bookName))
            {
                alreadyTaken = true;
            }
        }

        return alreadyTaken;
    }
}
