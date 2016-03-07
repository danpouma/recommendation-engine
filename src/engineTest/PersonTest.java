package engineTest;

import engine.Person;

/**
 *
 * @author dpoumakis
 */
public class PersonTest
{
    public static void main(String[] args)
    {
        Person person = new Person("dan", "poumakis", "male", 20);
        
        person.setFirstName("test");
        person.setLastName("test");
        person.setGender("male");
        person.setAge(21);
        
        if (person.getFirstName() == "test")
        {
            System.out.println("firstName: Pass");
        }
        else
        {
            System.out.println("firstName: Fail");
        }
        
        if (person.getLastName() == "test")
        {
            System.out.println("lastName: Pass");
        }
        else
        {
            System.out.println("lastName: Fail");
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
