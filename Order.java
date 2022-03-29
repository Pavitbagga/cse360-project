import java.util.*;

public class Order {
    private int orderNum;
    private Customer orderer;
    private ArrayList<OrderItem> orderContents = new ArrayList<>();
    private int orderTime = 0;
    private boolean cancelled;
    private User cancelledBy;
    private int totalPrice = 0;
    private boolean completed;
    private int placeInLine;

    public Order(int orderNum, Customer orderer) {
        this.orderNum = orderNum;
        this.orderer = orderer;
    }

    public boolean setCancelled(boolean newStatus) {
        this.cancelled = newStatus;
        return true;
    }

    public boolean setCancelledBy(User canceller) {
        this.cancelledBy = canceller;
        return true;
    }

    public boolean setCompleted(boolean newStatus) {
        this.completed = newStatus;
        return true;
    }

    public boolean setPlaceInLine(int newPlace) {
        this.placeInLine = newPlace;
        return true;
    }

    public boolean addOrderItem(OrderItem newItem) {
        this.orderContents.add(newItem);
        this.totalPrice = this.totalPrice + newItem.getPrice();
        this.orderTime = this.orderTime + (newItem.getItem().getPrepTime())*(newItem.getQuantity());
        return true;
    }

    public boolean removeOrderItem(OrderItem item) {
        return orderContents.remove(item);
    }

    public int getOrderNum() {
        return orderNum;
    }

    public Customer getOrderer() {
        return orderer;
    }

    public int getOrderTime() {
        return orderTime;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public User getCancelledBy() {
        return cancelledBy;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public ArrayList<Integer> getPricePerItem() {
        ArrayList<Integer> individualPrices = new ArrayList<>();
        for (OrderItem o : orderContents) {
            individualPrices.add(o.getPrice());
        }
        return individualPrices;
    }

    public boolean isCompleted() {
        return completed;
    }

    public int getPlaceInLine() {
        return placeInLine;
    }

    public ArrayList<OrderItem> getOrderContents() {
        return orderContents;
    }


}
