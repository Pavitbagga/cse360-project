
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import java.util.ArrayList;
import javafx.scene.input.MouseEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class OrdersView extends BaseModel {

    VBox ordersBox;
    int num;




    void addOrderNode(Order newOrder) {
        OrderNode grid = new OrderNode(newOrder);
       

        ordersBox.getChildren().add(grid);

    }

    public void addAllOrders(ArrayList<Order> orders) {
        for (int i = 0; i < orders.size(); i++) {
            addOrderNode(orders.get(i));
        }
    }
    OrdersView(Stage stage, int xSize, int ySize, ArrayList<Button> buttonList, String newPageTitle, Image newLogo, ArrayList<Order> orders) {
        super(xSize,  ySize, buttonList, newPageTitle, newLogo);
        ordersBox = new VBox();
        this.mainView.add(ordersBox, 0, 1);
        num = 0;

        
        
        
    }


}
