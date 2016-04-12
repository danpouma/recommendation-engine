package engine;

import java.util.LinkedList;

/**
 *
 * @author dpoumakis
 */
public class Recommendations
{
    private int id;
    private int userId;
    private LinkedList books;

    public Recommendations(int id, int userId)
    {
        this.id = id;
        this.userId = userId;
        books = new LinkedList();
    }
    
    public void addBook(Book book)
    {
        books.add(book);
    }
    
    // Remove by index
    public void removeBook(int index)
    {
        books.remove(index);
    }
    
    // Remove by book
    public void removeBook(Book book)
    {
        // Will need to wrap in conditions
        books.remove(book);
    }
    
    // Replace by index
    public void replaceBook(int index)
    {
        // add logic from lab #4
    }
    
    //Replace by book
    public void replaceBook(Book book)
    {
        // add logic from lab #4
    }

    public int getId()
    {
        return id;
    }

    public int getUserId()
    {
        return userId;
    }

    public LinkedList getBooks()
    {
        return books;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public void setBooks(LinkedList books)
    {
        this.books = books;
    }
}
