
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class OrderItemView extends GridPane{

    Button markAsComplete;
    Button cancel;

    Text customerNameLabel;
    Text customerName;
    Text waitTimeLabel;
    Text waitTime;
    Text totalPriceLabel;
    Text totalPrice;
    Text orderLabel;

    ScrollPane itemsScroll;
    VBox itemsBox;

    Order item;



    OrderItemView(Order newOrder) {

        ColumnConstraints c1 = new ColumnConstraints();
        ColumnConstraints c2 = new ColumnConstraints();
        ColumnConstraints c3 = new ColumnConstraints();
        ColumnConstraints c4 = new ColumnConstraints();
        ColumnConstraints c5 = new ColumnConstraints();
        ColumnConstraints c6 = new ColumnConstraints();
        ColumnConstraints c7 = new ColumnConstraints();

        c1.setPercentWidth(14.0);
        c2.setPercentWidth(14.0);
        c3.setPercentWidth(14.0);
        c4.setPercentWidth(14.0);
        c5.setPercentWidth(14.0);
        c6.setPercentWidth(14.0);
        c7.setPercentWidth(14.0);

        this.getColumnConstraints().add(c1);
        this.getColumnConstraints().add(c2);
        this.getColumnConstraints().add(c3);
        this.getColumnConstraints().add(c4);
        this.getColumnConstraints().add(c5);
        this.getColumnConstraints().add(c6);
        this.getColumnConstraints().add(c7);

        RowConstraints r1 = new RowConstraints();
        RowConstraints r2 = new RowConstraints();
        RowConstraints r3 = new RowConstraints();

        r1.setPercentHeight(20.0);
        r2.setPercentHeight(20.0);
        r3.setPercentHeight(60.0);

        this.getRowConstraints().add(r1);
        this.getRowConstraints().add(r2);
        this.getRowConstraints().add(r3);

        item = newOrder;


        customerNameLabel = new Text("Customer Name: ");
        customerName = new Text();

        waitTimeLabel = new Text("Wait Time: ");
        waitTime = new Text();

        totalPriceLabel = new Text("Total Price");
        totalPrice = new Text();

        orderLabel = new Text("Order");

        itemsBox = new VBox();
        itemsScroll = new ScrollPane();

        itemsScroll.setContent(itemsBox);

        markAsComplete = new Button("Mark as Completed");
        cancel = new Button("Cancel Order");


        this.add(customerNameLabel, 0, 0);
        this.add(customerName, 1, 0);

        this.add(waitTimeLabel, 2, 0);
        this.add(waitTime, 3, 0);
        this.add(totalPriceLabel, 4, 0);
        this.add(totalPrice, 5, 0);

        this.add(markAsComplete, 6, 0);

        this.add(orderLabel, 0, 1);
        this.add(itemsScroll, 1, 1, 5, 2);

        this.add(cancel, 6, 1);

        // TODO get sizing to display properly

        customerName.setText(newOrder.getOrderer().getFirstName() + " "  + newOrder.getOrderer().getLastName());
            totalPrice.setText("" + newOrder.getTotalPrice());
            waitTime.setText("" + newOrder.getWaitTime());
            for(int i = 0; i < newOrder.getOrderContents().size(); i++){
                HBox tempItem = new HBox();
                Text tempName = new Text("Item: " + newOrder.getOrderContents().get(i).getItem().getName()+ "    ");
                Text tempSize = new Text("Size: " + newOrder.getOrderContents().get(i).getSize()+ "    ");
                Text tempQuantity = new Text("Quantity: " + newOrder.getOrderContents().get(i).getQuantity() + "    ");

                tempItem.getChildren().add(tempName);
                tempItem.getChildren().add(tempSize);
                tempItem.getChildren().add(tempQuantity);

                itemsBox.getChildren().add(tempItem);
            }
        
            // TODO get width right

    }


    
}
