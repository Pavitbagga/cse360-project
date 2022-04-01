
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

import java.util.ArrayList;



public class OrderView extends BaseModel {

    ScrollPane orders;

    VBox orderVbox;

    public OrderView(int xSize, int ySize, ArrayList<Button> topButtons, String newPageTitle, Image newLogo) {

        super(xSize, ySize, topButtons, newPageTitle, newLogo);

        orders = new ScrollPane();
        orderVbox = new VBox();

        orders.setContent(orderVbox);

        this.mainView.add(orders,0,1);


    }

    public void addAllOrders(ArrayList<Order> newOrders) {
        for (Order o : newOrders) {
            OrderItemView newOrderItemView = new OrderItemView(o);
            orderVbox.getChildren().add(newOrderItemView);
            orders.setContent(orderVbox);
        }
    }

    public void removeAllOrders() {
        orderVbox.getChildren().clear();
        orders.setContent(orderVbox);
    }

}
