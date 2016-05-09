package engine;

import java.util.ArrayList;

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
    private ArrayList ratings;
    private Recommendations recommendations;

    public User()
    {
        id = counter++;
        username = "";
        gender = "";
        age = 0;
        ratings = new ArrayList();
        recommendations = new Recommendations(id);
    }

    public User(String username)
    {
        id = counter++;
        this.username = username;
        gender = "";
        age = 0;
        ratings = new ArrayList();
        recommendations = new Recommendations(id);
    }

    public User(String username, String gender, int age)
    {
        id = counter++;
        this.username = username;
        this.gender = gender;
        this.age = age;
        ratings = new ArrayList();
        recommendations = new Recommendations(id);
    }

    public ArrayList getRatings()
    {
        return ratings;
    }

    public void setRatings(ArrayList ratings)
    {
        this.ratings = ratings;
    }

    // Make sure this works
    public void addRating(Object rating)
    {
        ratings.add(rating);
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
        String ratingsOutput = "";

        for (Object rating : ratings)
        {
            ratingsOutput += rating.toString() + " ";
        }

        return username + ", " + ratingsOutput;
    }
}
