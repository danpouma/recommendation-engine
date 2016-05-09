/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class BookDataCollector
{
    public BookDataCollector(ArrayList<Book> books) throws IOException
    {
        FileWriter fileWriter = null;
        
        try
        {
            fileWriter = new FileWriter("./BookList.txt");
        }
        catch (IOException ex)
        {
            Logger.getLogger(UserDataCollector.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Book book : books)
        {
            if (fileWriter != null)
            {
                try
                {
                    fileWriter.write(book.toString());
                    fileWriter.write('\n');
                }
                catch (IOException ex)
                {
                    Logger.getLogger(BookDataCollector.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        fileWriter.close();

    }
}
