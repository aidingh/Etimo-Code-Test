import java.util.*;
/**
 * @author Aidin Ghassemloi
 * This class is the Controller class in the MVC-pattern.
 * This class contains all the logical functions for the application.
 */

public class StockBalanceController {

    public static List<StockBalanceModel> balanceList = new ArrayList<>();

    /**
     * Adds inventory name and inventory amount into a ArrayList data structure of an object type.
     * To check if an item is already added a binary search is conducted.
     * If the inventory exists, the amount will add up in the inventory.
     * If the item does not exist, the inventory item will be added to the list and sorted in alphabetical order.
     * <p>
     * This function does not return any values, but will give the user a response if the inventory item is added.
     * The responses are from StockBalanceView class that prints the proper response.
     *
     * Time complexity.
     * Worst case: O(log n)
     * Best case: O(1)
     *
     * @param  inventoryName  Inventory name added as an input from the user.
     * @param  inventoryAmount Inventory amount that the user have specified as input.
     */
    public static void addNewStockInventory(String inventoryName, int inventoryAmount){
        if(binarySearchInventoryName(inventoryName) >= 0){
            balanceList.get(binarySearchInventoryName(inventoryName)).inventoryAmount = balanceList.get(binarySearchInventoryName(inventoryName)).inventoryAmount + inventoryAmount;
            StockBalanceView.printInventoryAmountMessage(balanceList.get(binarySearchInventoryName(inventoryName)).inventoryName, balanceList.get(binarySearchInventoryName(inventoryName)).inventoryAmount);
            return;
        }
        balanceList.add(new StockBalanceModel(inventoryName, inventoryAmount));
        StockBalanceView.printInventoryConfirmedMessage(inventoryName, inventoryAmount);
        sortInventoryNameInAlphabeticOrder();
    }

    /**
     * Removes inventory amount from the specified inventory name.
     * To check if an item is already added a binary search is conducted.
     * If the inventory exists, the amount will be reduced.
     * If the item does not exist, an error response will occur.
     * If the inventory amount is equal to 0, the inventory will be removed.
     * If the current amount is lesser than the new amount it will trigger an error message.
     * <p>
     * This function does not return any values, but will give the user a response if the inventory item is reduced.
     * The responses are from StockBalanceView class that prints the proper response.
     * The function does not return any values because it is in a Controller class and the responses back to the user is made by the View class.
     * This is because the project is applied to an MVC-pattern.
     *
     * Time complexity.
     * Worst case: O(log n)
     * Best case: O(1)
     *
     * @param  inventoryName  Inventory name added as an input from the user.
     * @param  inventoryAmount Inventory amount that the user have specified as input.
     */
    public static void removeStockInventory(String inventoryName, int inventoryAmount){
        if(binarySearchInventoryName(inventoryName) >= 0){
            if(balanceList.get(binarySearchInventoryName(inventoryName)).inventoryAmount < inventoryAmount){
                StockBalanceView.printNegativeInventoryAmountMessage(balanceList.get(binarySearchInventoryName(inventoryName)).inventoryAmount, inventoryAmount);
            }
            else{
                balanceList.get(binarySearchInventoryName(inventoryName)).inventoryAmount = balanceList.get(binarySearchInventoryName(inventoryName)).inventoryAmount - inventoryAmount;
                StockBalanceView.printCurrentStockBalanceMessage(balanceList.get(binarySearchInventoryName(inventoryName)).inventoryName, balanceList.get(binarySearchInventoryName(inventoryName)).inventoryAmount);
                if(balanceList.get(binarySearchInventoryName(inventoryName)).inventoryAmount == 0){
                    balanceList.remove(binarySearchInventoryName(inventoryName));
                }
            }
        }
        else{
            StockBalanceView.printEmptyStockMessage();
        }
    }

    /**
     * Sorts the list in alphabetic order.
     * The sorting is done before doing a binary search.  As it works best on a sorted list.
     * Also, the list is sorted so the user can understand the result better.
     */
    public static void sortInventoryNameInAlphabeticOrder(){
        balanceList.sort(Comparator.comparing(StockBalanceModel::getInventoryName));
    }

    /**
     * The function makes a binary search of the inventory names that are in the stock balance list.
     *
     * Time complexity: O(log n)
     *
     * @param  inventoryName  Inventory name added as an input from the user.
     * @return an integer >= 0 if an item is found or an integer < 0 if an item is not found.
     */
    public static int binarySearchInventoryName(String inventoryName){
        return Collections.binarySearch(balanceList, new StockBalanceModel(inventoryName, 0), Comparator.comparing(StockBalanceModel::getInventoryName));
    }

    /**
     * Search for an inventory name with the binary search function.
     * If the inventory name exists, the user will get a successful message prompted back.
     * If the item does not exist, an error message will be printed to the user.
     * <p>
     * This function does not return any values, but will give the user a response if the searched inventory item is found.
     * The responses are from StockBalanceView class that prints the proper response.
     * The function does not return any values because it is in a Controller class and the responses back to the user is made by the View class.
     * This is because the project is applied to an MVC-pattern.
     *
     * Time complexity.
     * Worst case: O(log n)
     *
     * @param  inventoryName  Inventory name added as an input from the user.
     */
    public static void searchInventoryName(String inventoryName){
        if(binarySearchInventoryName(inventoryName) >= 0){
            StockBalanceView.printInventorySearchIsFoundMessage(balanceList.get(binarySearchInventoryName(inventoryName)).inventoryName, balanceList.get(binarySearchInventoryName(inventoryName)).inventoryAmount);
        }
        else{
            StockBalanceView.printInventoryNameWasNotFoundMessage();
        }
    }

    /**
     * Removes for an inventory from the stock balance list.
     * If the balance list is empty, the user will get a message prompted back that the list is empty.
     * If the balance list is not empty a search is made to find the index of the inventory item by a binary search. And then removes the inventory item.
     * <p>
     * This function does not return any values, but will give the user a response if the inventory item is added.
     * The responses are from StockBalanceView class that prints the proper response.
     * The function does not return any values because it is in a Controller class and the responses back to the user is made by the View class.
     * This is because the project is applied to an MVC-pattern.
     *
     * Time complexity.
     * Worst case: O(log n)
     *
     * @param  inventoryName  Inventory name added as an input from the user.
     */
    public static void removeByInventoryName(String inventoryName){
        if(balanceList.isEmpty()){
            StockBalanceView.printInventoryIsEmptyMessage();
        }
        else{
            if(binarySearchInventoryName(inventoryName) >= 0){
                balanceList.remove(binarySearchInventoryName(inventoryName));
                StockBalanceView.printInventoryIsRemovedMessage(inventoryName);
            }
            else{
                StockBalanceView.printInventoryNameWasNotFoundMessage();
            }
        }
    }

    /**
     * Clear the stock balance list, so the user can reset the inventory to start over.
     * When the list is cleared the user will be prompted with a message that the command have been executed.
     *
     * Time complexity.
     * Worst case: O(n)
     */
    public static void clearStockBalance(){
        balanceList.clear();
        StockBalanceView.printClearInventoryMessage();
    }

    /**
     * This function will display a matrix formed print of all the inventory names and amounts.
     * If the stock balance list is empty, an error message will be printed by the View class.
     *
     * Time complexity.
     * Worst case: O(n)
     *
     */
    public static void displayStockBalance(){
        if(balanceList.isEmpty()){
            StockBalanceView.printEmptyStockMessage();
        }
        else{
            System.out.println("Listing the current stock balance... ");
            for (StockBalanceModel stockBalanceModel : balanceList) {
                StockBalanceView.printCurrentStockBalanceMessage(stockBalanceModel.inventoryName, stockBalanceModel.inventoryAmount);
            }
        }
    }
}
