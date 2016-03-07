package engine;

/**
 *
 * @author dpoumakis
 */
public class Book
{
    private String title;
    private Author author;
    private int isbn;
    
    public Book() 
    {
        title = "";
        author = new Author();
        isbn = 0;
    }
    
    public Book(String title, Author author, int isbn)
    {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle()
    {
        return title;
    }

    public Author getAuthor()
    {
        return author;
    }

    public int getIsbn()
    {
        return isbn;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setAuthor(Author author)
    {
        this.author = author;
    }

    public void setIsbn(int isbn)
    {
        this.isbn = isbn;
    }
    
    @Override
    public String toString()
    {
        return "Book{" + "title=" + title + ", author=" + author + ", isbn=" + isbn + '}';
    }
}
