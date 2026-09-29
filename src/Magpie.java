import java.util.HashMap;
import java.util.Locale;

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
     * Searches for a full word in a string. Checks substring before and after to ensure keyword is found.
     * @param statement - The full user input
     * @param goal - The keyword we are looking for
     * @return Index where the word starts, or -1 if it isn't found alone.
     */
    public int findKeyword(String statement, String goal) {
        /*
        This is possibly some of the worst code I've ever written
        I don't even know what I'm looking at
        I think I need my meds to understand java
        Good luck figuring out this
         */
        statement = statement.toLowerCase();
        goal = goal.toLowerCase();
        String before = "";
        String after = "";
        int index = 0;
        // me and the world against String.split()
        String[] statementSplit = statement.split(" ");
        for (int i = 0; i < statementSplit.length; i++) {
            if (statementSplit[i].contains(goal)) {
                index = statementSplit[i].indexOf(goal);
                if (MagpieRunner._DEBUG)
                    System.out.println(statementSplit[i] + " contains " + goal);
                // we now know that the goal is inside the word, now we need to check if its enclosed in a word
                if (statementSplit[i].endsWith(goal)) {
                    // we know that the goal is at the end
                    if (MagpieRunner._DEBUG)
                        System.out.println(goal + " is at the end of " + statementSplit[i]);
                    // we must now check before it
                    if (statementSplit[i].startsWith(goal)) {
                        // if it starts with it, then we have sucessfully completed and assured that it is the whole word
                        if (MagpieRunner._DEBUG)
                            System.out.println(goal + " is at the start of " + statementSplit[i]);
                        return statement.indexOf(goal);
                    } else {
                        if (MagpieRunner._DEBUG)
                            System.out.println("Ends > Starts: " + goal + " does not start with the current word");
                        return -1;
                    }
                } else if (statementSplit[i].startsWith(goal)) {
                    if (MagpieRunner._DEBUG)
                        System.out.println(goal + " is at the start of " + statementSplit[i]);
                    if (statementSplit[i].endsWith(goal)) {
                        // if it ends with it, then we have sucessfully completed and assured that it is the whole word
                        if (MagpieRunner._DEBUG)
                            System.out.println(goal + " is at the end of " + statementSplit[i]);
                        return statement.indexOf(goal);
                    } else {
                        if (MagpieRunner._DEBUG)
                            System.out.println("Starts > Ends: " + goal + " does not end with the current word");
                        return -1;
                    }
                }
            }
        }

        return 0;
    }

    /**
     * Takes a statement and transforms it into "What would it mean to (statement)?"
     * @param statement - the user inputted string
     * @return String with added text
     */
    public String transformIWantToStatement(String statement) {
        String[] wantTo = statement.toLowerCase().split(" ");
        int splitAt = 0;
        // this is a very janky way of doing this but its the best i can think of
        for (int i = 0; i < wantTo.length; i++) {
            if (wantTo[i].equals("i") || wantTo[i].equals("want") || wantTo[i].equals("to")) {
                if (MagpieRunner._DEBUG)
                    System.out.println(wantTo[i] + " is a I want to statement");
            } else if (splitAt > 1) {
                continue;
            } else {
                splitAt = i;
            }
        }
        // i've lost my mind bro what is this code
        String reassembledStr = "What would it mean to ";
        for (int i = splitAt; i < wantTo.length; i++) {
            if (splitAt == i) {
                reassembledStr += wantTo[i];
            } else {
                reassembledStr += wantTo[i] + " ";
            }

        }
        return reassembledStr + "?";
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
        // TODO: Implement findKeyword()
        statement = statement.toLowerCase();
        // First, we check for a blank statement
        if (statement.isBlank()) {
            return Responses.getResponse("context.emptyInput");
        } else if (statement.contains("i want to")) {
            return transformIWantToStatement(statement);
            // Then we move on to keyword scanning
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
        // If we can't find anything, resort to a random response
        return Responses.getRandomResponse("random");
    }
    
    /**
     * Creates a random response (i.e. "Interesting, tell me more" or "Hmmmmm...")
     * Must contain at least 4 random responses to choose from
     * @return a String
     */
    public String getRandomResponse() {
        return Responses.getRandomResponse("random");
    }
}
