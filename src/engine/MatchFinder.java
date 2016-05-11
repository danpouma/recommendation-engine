package engine;

import java.util.ArrayList;

/**
 *
 * @author dpoumakis
 */
public class MatchFinder
{

    public MatchFinder(ArrayList<User> users)
    {
        for (User currentUser : users)
        {
            User topMatch = null;
            int topMatches = 0;
            for (User otherUser : users)
            {
                int matches = 0;
                for (int rating = 0; rating < otherUser.getRatings().size(); rating++)
                {
                    if (!currentUser.getUsername().equals(otherUser.getUsername()))
                    {   
                        if (currentUser.getRatings().get(rating).equals(otherUser.getRatings().get(rating)))
                        {
                            matches++;
                        }
                    }
                }
                
                if ( matches > topMatches)
                {
                    topMatch = otherUser;
                    topMatches = matches;
                }
                else
                {
                    //System.out.println("y8");
                }
                
            }
            
            currentUser.setMostSimilar(topMatch);
        }
    }
}
