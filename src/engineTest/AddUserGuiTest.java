/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engineTest;

import engine.Book;
import engine.BooksDataLoader;
import engine.AddUserGui;
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
public class AddUserGuiTest
{

    public static void main(String[] args)
    {
        UsersDataLoader usersLoader = new UsersDataLoader();
        ArrayList<User> users = usersLoader.getUsers();

        BooksDataLoader booksLoader = new BooksDataLoader();
        ArrayList<Book> books = booksLoader.getBooks();

        AddUserGui addUser = new AddUserGui(users, books);
        
        // Try and store data into text file :)
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
