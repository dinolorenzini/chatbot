import java.util.HashMap;

public class Magpie
{
    /**
     * @return a simple response to get a conversation going, (i.e. "Top of the morning lad, do you want to have a conversation?")
     */
    public String getGreeting()
    {
        String[] greetings = {"Hello my dearest friend!", "You seem curious, whats the question of the day?", "Hey, I'm over here!", "Is that pizza?", "Oh. You again.", "Well, I mean I guess. How can I help you.", "Welcome to Magpie, what can I get for you?"};
        int greetingsLength = greetings.length;
        int greetingSelector = (int)(Math.random() * (greetingsLength + 1);
        return greetings[greetingSelector];
    }
    
    /**
     * Gives a response to a user statement, the response should meet the following 3 conditions:
     * 1) If the statement contains "no" the response should be "Why so negative".
     * 2) If the statement contains "mother", "brother", "sister", "father" the response should be "Tell me more about your family"
     * 3) If the statement doesn't meet conditions 1 and 2 the response calls the getRandomResponse() method to obtain a random response.
     * 
     * @param statement: the user entered statement
     * 
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        if (statement.contains("no")) {
            return getResponse("contain.negative");
        } else if (statement.contains("mother") || statement.contains("brother") || statement.contains("sister") || statement.contains("father")) {
            return getResponse("contain.family");
        }
    }
    
    /**
     * Creates a random response (i.e. "Interesting, tell me more" or "Hmmmmm...")
     * Must contain at least 4 random responses to choose from
     * @return a String
     */
    public String getRandomResponse()
    {
        
    }
}
