package engineTest;

import engine.Author;

/**
 *
 * @author dpoumakis
 */
public class AuthorTest
{
    public static void main(String[] args)
    {
        Author person = new Author("danpouma", "male", 20);
        
        person.setUsername("test");
        person.setGender("male");
        person.setAge(21);
        
        if (person.getUsername() == "test")
        {
            System.out.println("username: Pass");
        }
        else
        {
            System.out.println("username: Fail");
        }
        
        
        if (person.getGender() == "male")
        {
            System.out.println("gender: Pass");
        }
        else
        {
            System.out.println("gender: Fail");
        }
        
        if (person.getAge() == 21)
        {
            System.out.println("age: Pass");
        }
        else
        {
            System.out.println("age: Fail");
        }
    }
}
