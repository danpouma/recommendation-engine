/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engineTest;

import engine.Book;
import engine.BookDataCollector;
import engine.BooksDataLoader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dpoumakis
 */
public class BookDataCollectorTest
{
    public static void main(String[] args)
    {
        BooksDataLoader loader = new BooksDataLoader();
        
        ArrayList<Book> books = loader.getBooks();
        
        try
        {
            BookDataCollector dataStore = new BookDataCollector(books);
        }
        catch (IOException ex)
        {
            Logger.getLogger(UserDataCollectorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
