package engine;

/**
 *
 * @author dpoumakis
 */
public class Book
{
    private String title;
    private int genre;
    private String author;
    
    public Book() 
    {
        title = "";
        author = "";
    }
    
    public Book(String author, String title)
    {
        this.author = author;
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    
    public int getGenre()
    {
        return genre;
    }
    
    public String getAuthor()
    {
        return author;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public void setGenre(int genre)
    {
        this.genre = genre;
    }
    
    public void setAuthor(String author)
    {
        this.author = author;
    }

    @Override
    public String toString()
    {
        return "Book{" + "title=" + title + ", genre=" + genre + ", author=" + author + '}';
    }
}
