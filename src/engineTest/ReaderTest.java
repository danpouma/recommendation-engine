package engineTest;

import engine.Author;

/**
 *
 * @author dpoumakis
 */
public class ReaderTest
{
    public static void main(String[] args)
    {
        Author author = new Author("dan", "poumakis", "male", 20);
        
        author.setFirstName("test");
        author.setLastName("test");
        author.setGender("male");
        author.setAge(21);
        
        if (author.getFirstName() == "test")
        {
            System.out.println("firstName: Pass");
        }
        else
        {
            System.out.println("firstName: Fail");
        }
        
        if (author.getLastName() == "test")
        {
            System.out.println("lastName: Pass");
        }
        else
        {
            System.out.println("lastName: Fail");
        }
        
        if (author.getGender() == "male")
        {
            System.out.println("gender: Pass");
        }
        else
        {
            System.out.println("gender: Fail");
        }
        
        if (author.getAge() == 21)
        {
            System.out.println("age: Pass");
        }
        else
        {
            System.out.println("age: Fail");
        }
    }
}
