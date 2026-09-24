import java.util.Scanner;
public class MagpieRunner
{
    public static boolean _DEBUG = false;
    /**
     * 1) Create a while loop so the program should continue to run as long as the word "Bye"       			
     *    doesn't appear.
     */
    public static void main(String[] args)
    {
        // Initializations
        Magpie maggie = new Magpie();
        Scanner in = new Scanner(System.in);
        Responses.initialize();
        String statement = "";

        if (_DEBUG)
            System.out.println(Responses.getResponse("greeting.friend"));

        // Greeting
        System.out.println(maggie.getGreeting());

        // Loop Scanner
        while (!statement.toLowerCase().equals("bye")) {
            statement = in.nextLine();
            System.out.println("You said: " + statement);
        }
    }

}