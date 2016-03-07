package engine;

/**
 *
 * @author dpoumakis
 */
public class Person
{
    private String firstName;
    private String lastName;
    private String gender;

    public Person()
    {
        firstName = "";
        lastName = "";
        gender = "";
        age = 0;
    }
    
    public Person(String firstName, String lastName, String gender, int age)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getGender()
    {
        return gender;
    }

    public int getAge()
    {
        return age;
    }
    private int age;
    
    @Override
    public String toString()
    {
        return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", age=" + age + '}';
    }
}
