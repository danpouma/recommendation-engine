package engine;

/**
 *
 * @author dpoumakis
 */
public class Person
{
    private final int id;
    private String username;
    private String gender;
    private int age;
    private static int counter = 0;

    public Person()
    {
        id = counter++;
        username = "";
        gender = "";
        age = 0;
    }
    
    public Person(String username, String gender, int age)
    {
        id = counter++;
        this.username = username;
        this.gender = gender;
        this.age = age;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }


    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
    
    public int getId()
    {
        return id;
    }
    
    public String getUsername()
    {
        return username;
    }

    public String getGender()
    {
        return gender;
    }

    public int getAge()
    {
        return age;
    }
    
    @Override
    public String toString()
    {
        return "Person{" + "username=" + username + ", gender=" + gender + ", age=" + age + '}';
    }
}
