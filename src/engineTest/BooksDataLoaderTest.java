package engineTest;

import engine.Book;
import engine.BooksDataLoader;

/**
 *
 * @author dpoumakis
 */
public class BooksDataLoaderTest
{
    public static void main(String[] args)
    {
        BooksDataLoader loader = new BooksDataLoader();
        
        for (Book book : loader.getBooks())
        {
            System.out.print(book.getTitle() + " by... ");
            System.out.println(book.getAuthor());
        }
    }
}
