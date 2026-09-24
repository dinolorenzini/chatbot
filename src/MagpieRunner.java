import java.util.Scanner;
public class MagpieRunner
{
    /**
     * 1) Create a while loop so the program should continue to run as long as the word "Bye"       			
     *    doesn't appear.
     */
    public static void main(String[] args)
    {
        Magpie maggie = new Magpie();      
        System.out.println(maggie.getGreeting());
        while (true) {
            Scanner in = new Scanner(System.in);
            String statement = in.nextLine();
        }
    }

}