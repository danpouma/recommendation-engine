package engine;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author dpoumakis
 */
public class BooksDataLoader
{

    File userRatingFile;
    FileInputStream instream;
    DataInputStream bookData;
    String line;
    StringTokenizer stringTok;

    ArrayList<Book> books;

    public BooksDataLoader()
    {
        books = new ArrayList();

        try
        {
            userRatingFile = new File("./BookList.txt");
            instream = new FileInputStream(userRatingFile);
            bookData = new DataInputStream(instream);

            while (instream.available() > 0)
            {
                line = (String) bookData.readLine();

                Book book = new Book();

                stringTok = new StringTokenizer(line);

                // Get the authors name
                book.setAuthor(stringTok.nextToken(","));
                String title = stringTok.nextToken("\n");
                title = title.replace(",", "");

                book.setTitle(title);

                // Bug where first elem is nothing
                // this fixes it for now :P
                //ratings.remove(0);
                // Give ratings to user
                //user.setRatings(ratings);
                // Add book to books
                books.add(book);
            }

            // Close the streams
            instream.close();
            bookData.close();
        }
        catch (Exception e)
        {
            System.out.println("Error");
        }
    }

    public ArrayList<Book> getBooks()
    {
        return books;
    }

}
