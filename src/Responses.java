import java.util.HashMap;
import java.util.Map;

public class Responses {
    /**
     * Possible classes:
     * - greeting
     * - context
     * - random
     * - system
     */
    public static Map<String, String> responses = new HashMap<>();
    /**
     * Initialize the program by adding all the stuff to the KV store
     */
    public static void initialize() {
        if (MagpieRunner._DEBUG)
            System.out.println("Initializing KV Response Store...");
        // Put all responses
        // AI helped me out a bit with figuring out the data store, did not give code
        // I used HashMaps in the past for personal projects
        // Using a HashMap and a KV store will help improve the readability of code and improve the ability to easily change variables/Strings
        // Class: greeting | Desc: For all greetings
        responses.put("greeting.friend", "Hello my dearest friend!");
        responses.put("greeting.qotd", "You seem curious, whats the question of the day?");
        responses.put("greeting.attention", "Hey, I'm over here!");
        responses.put("greeting.pizza", "Is that pizza?");
        responses.put("greeting.youagain", "Oh. You again.");
        responses.put("greeting.lazy", "I guess I'll help you. What's going on today?");
        responses.put("greeting.magpie", "Welcome to Magpie, what can I get for you?");
        // Class: context | Desc: For things that look for text that contains itself (non-random) (from user context)
        responses.put("context.negative", "Why so negative?");
        responses.put("context.family", "Tell me more about your family!");
        // Class: random | Desc: Random statements and questions
        responses.put("random.introduction", "Well, my name is Magpie. What is your name?");
        responses.put("random.howareyou", "Well looks like I've found myself stuck in a hole. How are you, anyway?");
        responses.put("random.three", "3");
        responses.put("random.four", "4");
        // Class: system | Desc: for things system related, such as errors
        responses.put("system.error", "Woah, Magpie encountered an error");
        responses.put("system.about", "I am Magpie. Emperor of the thirty islands.");
        responses.put("system.noCmdFound", "I didn't find a command. That's weird.");
        responses.put("system.ranNotFound", "Couldnt find random response");

        // testing stuff, will only print in debug
        if (MagpieRunner._DEBUG) {
            System.out.println("Random greeting string: " + getRandomResponse("greeting"));
            System.out.println("Random context string: " + getRandomResponse("context"));
            System.out.println("Random random string: " + getRandomResponse("random"));
            System.out.println("Random system string: " + getRandomResponse("system"));
        }
    }

    /**
     * Get a pre-defined response from the KV store in the responses hashmap
     * @param key: the key of the response needed
     * @return String: the value of the response needed
     */
    public static String getResponse(String key) {
        return responses.get(key);
    }
    public static String getRandomResponse(String keyClass) {
        int responsesNum = responses.size();
        int arrIncrement = 0;
        String[] matchingRetVals = new String[responsesNum];
        for (Map.Entry<String, String> entry : responses.entrySet()) {
            if (entry.getKey().split("\\.")[0].equals(keyClass)) {
                matchingRetVals[arrIncrement] = entry.getKey();
                arrIncrement += 1;
            }
        }
        if (MagpieRunner._DEBUG) {
            System.out.println("ResponsesKV | getRandomResponse called for class " + keyClass + " and found " + (arrIncrement + 1) + " matching classes.");
        }
        if (arrIncrement == 0) {
            return responses.get("system.ranNotFound");
        }
        int ranVal = (int)(Math.random() * responsesNum);
        while (matchingRetVals[ranVal] == null) {
            // gen a new random value if the return value was not found inside of the array
            ranVal = (int)(Math.random() * responsesNum);
        }
        return responses.get(matchingRetVals[ranVal]);
    }
}
