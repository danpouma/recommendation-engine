package engine;

/**
 *
 * @author dpoumakis
 */
public class User
{
    private final int id;
    private String username;
    private String gender;
    private int age;
    private static int counter = 0;
    private Recommendations recommendations;

    public User()
    {
        id = counter++;
        username = "";
        gender = "";
        age = 0;
        recommendations = new Recommendations(id);
    }
    
    public User(String username)
    {
        id = counter++;
        this.username = username;
        gender = "";
        age = 0;
        recommendations = new Recommendations(id);
    }
    
    public User(String username, String gender, int age)
    {
        id = counter++;
        this.username = username;
        this.gender = gender;
        this.age = age;
        recommendations = new Recommendations(id);
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
    
    public Recommendations getRecommendations()
    {
        return recommendations;
    }
    
    @Override
    public String toString()
    {
        return "Person{" + "username=" + username + ", gender=" + gender + ", age=" + age + '}';
    }
}
