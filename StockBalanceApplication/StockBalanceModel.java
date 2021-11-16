/**
 * @author Aidin Ghassemloi
 * This class is the Model class in the MVC-pattern.
 * This class has the setter and getters generated if needed.
 * The model is also an object type for the stock balance list.
 * With this model more parameters and detail can be added for any inventory item.
 * An example is to add inventory locations or anything usable.
 */
public class StockBalanceModel {
    public String inventoryName;
    public int inventoryAmount;

    public StockBalanceModel(String inventoryName, int inventoryAmount){
        this.inventoryName = inventoryName;
        this.inventoryAmount = inventoryAmount;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public int getInventoryAmount() {
        return inventoryAmount;
    }

    public void setInventoryAmount(int inventoryAmount) {
        this.inventoryAmount = inventoryAmount;
    }
}
