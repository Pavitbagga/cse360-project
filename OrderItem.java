
import java.io.Serializable;

public class OrderItem  implements Serializable{

    private MenuItem item;
    private String specialInstructions;
    private int size;
    private int quantity;
    private int price;

    public OrderItem(MenuItem item, String specialInstructions, int size, int quantity, int price) {
        this.item = item;
        this.specialInstructions = specialInstructions;
        this.size = size;
        this.quantity = quantity;
        this.price = item.getPrice() * quantity;
    }

    public boolean setSpecialInstructions(String newSpecialInstructions) {
        this.specialInstructions = newSpecialInstructions;
        return true;
    }

    public boolean setSize(int newSize) {
        this.size = newSize;
        return true;
    }

    public boolean setQuantity(int newQuantity) {
        if (newQuantity==0) {
            return false;
        }
        else {
            this.quantity = newQuantity;
            this.price = item.getPrice() * quantity;
            return true;
        }
    }

    public boolean setPrice(int newPrice) {
        this.price = newPrice;
        return true;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public int getSize() {
        return size;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public MenuItem getItem() {
        return item;
    }
}

