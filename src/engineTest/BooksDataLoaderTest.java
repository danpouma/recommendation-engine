package engineTest;

import engine.Book;
import engine.BooksDataLoader;
import java.util.ArrayList;

/**
 *
 * @author dpoumakis
 */
public class BooksDataLoaderTest
{
    public static void main(String[] args)
    {
        BooksDataLoader loader = new BooksDataLoader();
        
        ArrayList<Book> books = loader.getBooks();
        
        System.out.println("Number of books: " + books.size());
        for (Book book : books)
        {
            System.out.print(book.getTitle() + " by... ");
            System.out.println(book.getAuthor());
        }
    }
}
