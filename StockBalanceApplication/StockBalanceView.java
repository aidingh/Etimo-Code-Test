import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 *  @author Aidin Ghassemloi
 * This class is the View class in the MVC-pattern.
 * This class holds static methods to return a proper output message depending on the user input commands specified by the user.
 * All functions return void and only prints a message in the console.
 * If a function takes input parameters, it can only be inventory name or inventory amount.
 */
public  class StockBalanceView {

    public static void printInventoryConfirmedMessage(String inventoryName, int inventoryAmount) {
        System.out.println("Inventory: " + inventoryName);
        System.out.println("Amount: " + inventoryAmount);
        System.out.println("Is now added to the inventory!");
    }

    public static void printEmptyStockMessage(){
        System.out.println("No items in inventory. Try adding a new inventory.");
        System.out.println("Input example: I SOAP 10");
        System.out.println("Please try again...or write U for usage information.");
    }

    public static void printCurrentStockBalanceMessage(String inventoryName, int inventoryAmount){
        System.out.println("Inventory: " + inventoryName + " | "  + " Amount: " + inventoryAmount);
    }

    public static void printInputToLargeMessage(){
        System.out.println("User input can not be greater than 3.");
        System.out.println("Input example: I SOAP 10");
        System.out.println("The input will add 10 amounts of SOAP.");
        System.out.println("Please try again...or write U for usage information.");
    }

    public static void printInventoryNameWasNotFoundMessage(){
        System.out.println("Inventory item was not found.");
        System.out.println("Please try again...or write U for usage information.");
    }

    public static void printInventoryIsEmptyMessage(){
        System.out.println("Inventory is empty.");
        System.out.println("Please try again...or write U for usage information.");
    }

    public static void printInventoryIsRemovedMessage(String inventoryName){
        System.out.println("Inventory: " + inventoryName + " " + "have been removed.");
    }

    public static void printInventorySearchIsFoundMessage(String inventoryName, int inventoryAmount){
        System.out.println("Inventory found!");
        System.out.println("Inventory: " + inventoryName + " Amount: " + inventoryAmount);
    }

    public static void printNegativeInventoryAmountMessage(int currentInventoryAmount, int newInventoryAmount){
        System.out.println("Wrong argument given. Current inventory amount is: " + currentInventoryAmount + "." + " Removing inventory amount with current value: " + newInventoryAmount + " will return a negative stock amount.");
        System.out.println("Please try again...or write U for usage information.");
    }

    public static void printClearInventoryMessage(){
        System.out.println("Inventory is now reset.");
    }

    public static void printInventoryAmountMessage(String inventoryName, int inventoryAmount){
        System.out.println("Inventory: " + inventoryName + " amount is now = " + inventoryAmount);
    }

    public static void printCommandErrorMessage(){
        System.out.println("The command given was not found or the syntax input is wrong.");
        System.out.println("Please try again...or write U for usage information.");
    }

    public static void printCommandInformationMessage(){
        try (BufferedReader br = new BufferedReader(new FileReader("StockBalanceApplication/StockBalanceApplicationCommands.txt"))) {
            String newline;
            while ((newline = br.readLine()) != null) {
                System.out.println(newline);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
