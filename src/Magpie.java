import java.util.HashMap;

public class Magpie
{
    /**
     * @return a simple response to get a conversation going, (i.e. "Top of the morning lad, do you want to have a conversation?")
     */
    public String getGreeting()
    {
        return Responses.getRandomResponse("greeting");
    }

    /**
    *
    * Detect if the exact word is inside of the phrase
    *
    */
    public int findKeyword(String statement, String goal) {
        return 0;
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
    public String getContextualizedResponse(String statement)
    {
        if (statement.isBlank()) {
            return Responses.getResponse("context.emptyInput");
        } else if (statement.contains("no")) {
            return Responses.getResponse("context.negative");
        } else if (statement.contains("mother") || statement.contains("brother") || statement.contains("sister") || statement.contains("father")) {
            return Responses.getResponse("context.family");
        } else if (statement.contains("math")) {
            return Responses.getResponse("context.math");
        } else if (statement.contains("hit")) {
            return Responses.getResponse("context.hit");
        } else if (statement.contains("wuest")) {
            return Responses.getResponse("context.wuest");
        }
        // if nothing is found
        return Responses.getResponse("system.noCmdFound");
    }
    
    /**
     * Creates a random response (i.e. "Interesting, tell me more" or "Hmmmmm...")
     * Must contain at least 4 random responses to choose from
     * @return a String
     */
    public String getRandomResponse()
    {
        return Responses.getRandomResponse("random");
    }
}
