package engine;

import java.util.ArrayList;

/**
 *
 * @author dpoumakis
 */
public class MatchFinder
{
     public MatchFinder(User user, ArrayList<User> users)
     {
         for (int person = 1; person < users.size(); person++)
         {
             User currentUser = users.get(person);
             
             ArrayList userRatings = user.getRatings();
             ArrayList currentUserRatings = currentUser.getRatings();
             
             int numberOfRatings = currentUserRatings.size();
             
             int matches = 0;
             for (int rating = 0; rating < numberOfRatings; rating++)
             {
                if (userRatings.get(rating).equals(currentUserRatings.get(rating)))
                {
                    matches++;
                }
                else
                {
                    // do nothing
                }
             }
             System.out.println("Matches: " + matches);
             matches = 0;
          }
     }
}
