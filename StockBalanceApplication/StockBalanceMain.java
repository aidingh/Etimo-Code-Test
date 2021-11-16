
import java.util.Scanner;
/**
 * @author Aidin Ghassemloi
 * Main function to run console application.
 * Application follows an MVC-pattern
 */
public class StockBalanceMain {
    /** main method
     * @param args String[]
     */
    public static void main(String[] args) {
        System.out.println("Application in progress...");
        UserInputController inputHandler = new UserInputController();
        StockBalanceView.printCommandInformationMessage();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter input: ");

        while (sc.hasNext()) {
            if(sc.hasNextLine()){
                inputHandler.parseUserInput(sc.nextLine());
            }
            else {
                inputHandler.parseUserInput(sc.next());
            }
        }
    }
}
