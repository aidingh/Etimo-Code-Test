
import java.util.Arrays;
import java.util.Locale;
/**
 * @author Aidin Ghassemloi
 * This class is the User Input Controller class in the MVC-pattern.
 * This class will handle all inputs defined by the user.
 * This class also deals with exceptions, if the user defines its input as incorrect it gets a message from the view class or an exception will the catched.
 */
public class UserInputController {

    /**
     * Splits the user input by the space char.
     * If the user input is greater than 3 an error message will shown.
     * If the user input is strict 3, then the user have specified a three pair command.
     * If the user input is strict 2, then the user have specified a two pair command.
     * If the user input is strict 1, then the user have specified a single command.
     *
     * @param  userInput  An input defined by the user and split by the space character.
     */
    public void parseUserInput(String userInput) {
        String[] inputData = userInput.split(" ");
        System.out.println(Arrays.toString(inputData));

        if (inputData.length > 3) {
            StockBalanceView.printInputToLargeMessage();
        }
        else if (inputData.length == 2) {
            twoPairCommandHandler(inputData);
        }
        else if (inputData.length == 1) {
            singeCommandHandler(inputData);
        }
        else if (inputData.length == 3) {
            threePairCommandHandler(inputData);
        }
    }

    /**
     * If the command is a single char and the char is a specified command in the program, it will be handled accordingly.
     * After a command is executed the user will be notified with a message from the view class.
     * @param  inputData  A String array with user defined command and parameters.
     */
    public void singeCommandHandler(String[] inputData){
        switch (inputData[0].toUpperCase(Locale.ROOT)) {
            case "L":
                StockBalanceController.displayStockBalance();
                break;
            case "D":
                StockBalanceController.clearStockBalance();
                break;
            case "U":
                StockBalanceView.printCommandInformationMessage();
                break;
            case "EXIT":
                System.exit(0);
                break;
            default:
                StockBalanceView.printCommandErrorMessage();
                break;
        }
    }
    /**
     * If the command is two chars and the second char is not a number, then the command can be executed.
     * After a command is executed the user will be notified with a message from the view class.
     * @param  inputData  A String array with user defined command and parameters.
     */
    public void twoPairCommandHandler(String[] inputData){
        if(inputData[0].toUpperCase(Locale.ROOT).equals("R") && !isInteger(inputData[1])){
            StockBalanceController.removeByInventoryName(inputData[1]);
        }
        else if(inputData[0].toUpperCase(Locale.ROOT).equals("SR")){
            StockBalanceController.searchInventoryName(inputData[1]);
        }
        else{
            StockBalanceView.printCommandErrorMessage();
        }
    }

    /**
     * If the command is three chars and the second char is not a number and the last command is an integer then the command can be executed.
     * Also, the last command must be greater than 0. The application does not deal with negative numbers
     * After a command is executed the user will be notified with a message from the view class.
     * @param  inputData  A String array with user defined command and parameters.
     */
    public void threePairCommandHandler(String[] inputData){
        if (inputData[0].toUpperCase(Locale.ROOT).equals("I") && isInteger(inputData[2]) && !isInteger(inputData[1]) && Integer.parseInt(inputData[2]) >= 0) {
            StockBalanceController.addNewStockInventory(inputData[1], Integer.parseInt(inputData[2]));
        }
        else if (inputData[0].toUpperCase(Locale.ROOT).equals("S") && isInteger(inputData[2]) && !isInteger(inputData[1]) && Integer.parseInt(inputData[2]) >= 0) {
            StockBalanceController.removeStockInventory(inputData[1], Integer.parseInt(inputData[2]));
        }
        else{
            StockBalanceView.printCommandErrorMessage();
        }
    }

    /**
     * Method checks if the provided string parameter is a number or not.
     * @param  commandParam  A string to check if the string is an integer or not.
     */
    public static boolean isInteger(String commandParam) {
        try {
            Integer.parseInt(commandParam);
        } catch(NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }
}
