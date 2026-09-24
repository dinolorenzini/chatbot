import java.util.HashMap;
import java.util.Map;

public class Responses {
    private static Map<String, String> responses = new HashMap<>();
    public static void main(String[] args) {
        // Put all responses
        // AI helped me out a bit with figuring out the data store, did not give code
        // I used HashMaps in the past for personal projects
        // Using a HashMap and a KV store will help improve the readability of code and improve the ability to easily change variables/Strings
        // Class: greeting | Desc: For all greetings
        responses.put("greeting.friend", "Hello my dearest friend!");
        responses.put("greeting.qotd", "You seem curious, whats the question of the day?");
        responses.put("greeting.attention", "Hey, I'm over here!");
        // Class: contain | Desc: For things that look for text that contains itself (non-random)
        responses.put("contain.negative", "Why so negative?");
        responses.put("contain.family", "Tell me more about your family!");
    }

    /**
     * Get a pre-defined response from the KV store in the responses class
     * @param key: the key of the response needed
     * @return String: the value of the response needed
     */
    public static String getResponse(String key) {
        return responses.get(key);
    }
    public static String getRandomResponse(String keyClass) {
        // check for a class, if it equals the correct class then we return a random from that class
        responses.forEach((key, value) -> {
            // forEach from JavaScript, needed, cannot iterate a HashMap with a for loop
            String[] splitKeys =  key.split("\\.");
            if (keyClass.equals(splitKeys[0])) {
                // If the class is correct, continue
                if (key.startsWith(splitKeys[0])) {
                    // if the key starts with the correct class, then we iterate through and find the amount of Strings
                    // For random selection, lets just do a math.random, and if the number is within a value, we'll randomly choose it
                    // If no value is choosen, we just choose the first in the index
                    int randomVal = (int)((Math.random() *  10) - 1);
                    if (randomVal >= 8) {
                        return responses.get(key);
                        break;
                    }
                }
            } else {
                // If class not found, return
                System.out.println("Responses | Class not found: " + keyClass);
            }
        });
    }
}
