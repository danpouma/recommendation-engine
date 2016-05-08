/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engineTest;

import engine.Book;
import engine.BooksDataLoader;
import engine.NewUserGui;
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
public class NewUserGuiTest
{

    public static void main(String[] args)
    {
        UsersDataLoader usersLoader = new UsersDataLoader();
        ArrayList<User> users = usersLoader.getUsers();

        BooksDataLoader booksLoader = new BooksDataLoader();
        ArrayList<Book> books = booksLoader.getBooks();

        NewUserGui addUser = new NewUserGui(users, books);
        
        // Try and store data into text file :)
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
