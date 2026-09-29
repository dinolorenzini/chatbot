import java.util.Scanner;

public class QuickTest {
    public static void main(String[] args) {
        Magpie magpie = new Magpie();
        Scanner in = new Scanner(System.in);
        System.out.println("QuickTest >> Choose an option" +
                "\n1) Find Keyword" +
                "\n2) Transform I Want To");
        System.out.print(">");
        String input = in.nextLine();
        switch (input) {
            case "1":
                findKeywordTest(in, magpie);
            case "2":
                transformIWantToTest(in, magpie);
        }
    }
    public static void findKeywordTest(Scanner in, Magpie magpie) {
        System.out.println("Find Keyword Test");
        System.out.print("Enter statement: ");
        String statement = in.nextLine();
        System.out.print("Enter goal: ");
        String goal = in.nextLine();

        int goalSub = magpie.findKeyword(statement, goal);
        System.out.println(goalSub);
        if (goalSub >= 0)
            System.out.println(statement.substring(goalSub));
    }
    public static void transformIWantToTest(Scanner in, Magpie magpie) {

    }
}
