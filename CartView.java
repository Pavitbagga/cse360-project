import java.util.ArrayList;

// import com.sun.prism.paint.Color;

// import javafx.event.ActionEvent;
// import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.layout.Border;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class CartView extends BaseModel
{
	Text total;
	Text vboxText;
	VBox orderItemsList;
	Text yourCartText;
	Button cancelOrderButton;
	Button checkOutButton;
	Order thisOrder;
	GridPane grid;
	Customer javaChip;

	


	
	public CartView(int xSize, int ySize, ArrayList<Button> topButtons, String newPageTitle, Image newLogo, Order newOrder)
	{
		super (xSize, ySize, topButtons, newPageTitle, newLogo);
		
		grid = new GridPane();
		grid.setGridLinesVisible(true);
		total = new Text("Total: $");
		yourCartText = new Text("YOUR CART");
		cancelOrderButton = new Button("Cancel Order");
		checkOutButton = new Button("Checkout");
		vboxText = new Text("Items List");
		
		orderItemsList = new VBox();
		
		javaChip = new Customer("Java", "Chip", "JavaChip","cookie",1,"JavaChip@gmail.com","12345678");
		thisOrder = new Order(2,javaChip);


		total.setFont(Font.font("Arial", FontWeight.BOLD,20));
		yourCartText.setFont(Font.font("Arial", FontWeight.BOLD,25));
		vboxText.setFont(Font.font("Times New Roman", FontPosture.ITALIC,18));

		

		// orderItemsList.setMaxSize(1000, 1000);
		// orderItemsList.setPrefSize(1000, 1000);
		
		// orderItemsList.getChildren().add(scroll);
		

		// Rectangle rect = new Rectangle(200,200,Color.RED);
		ScrollPane scroll = new ScrollPane();
		orderItemsList.setStyle("-fx-background-color: white;");
		orderItemsList.setPrefSize(900.0,700.0 );
		orderItemsList.getChildren().add(vboxText);
		scroll.setContent(orderItemsList);
		// orderItemsList.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID,CornerRadii.EMPTY, new BorderWidths(5))));
		
		

		
		ColumnConstraints column1 = new ColumnConstraints();
		ColumnConstraints column2 = new ColumnConstraints();
		ColumnConstraints column3 = new ColumnConstraints();
		ColumnConstraints column4 = new ColumnConstraints();
		ColumnConstraints column5 = new ColumnConstraints();
		
		column1.setPercentWidth(20.0);
		column2.setPercentWidth(20.0);
		column3.setPercentWidth(23.0);
		column4.setPercentWidth(27.0);
		column5.setPercentWidth(20.0);

		columns.add(column1);
		columns.add(column2);
		columns.add(column3);
		columns.add(column4);
		columns.add(column5);
		

		RowConstraints row1 = new RowConstraints();
		RowConstraints row2 = new RowConstraints();
		RowConstraints row3 = new RowConstraints();
		RowConstraints row4 = new RowConstraints();
		RowConstraints row5 = new RowConstraints();

		row1.setPercentHeight(30.0);
		row2.setPercentHeight(30.0);
		row3.setPercentHeight(30.0);
		row4.setPercentHeight(30.0);
		row5.setPercentHeight(30.0);

		rows.add(row1);
		rows.add(row2);
		rows.add(row3);
		rows.add(row4);
		rows.add(row5);

		grid.getRowConstraints().addAll(rows);
		grid.getColumnConstraints().addAll(columns);



		// orderItemsList.getChildren().addAll(scroll);
		// VBox.setVgrow(scroll, Priority.ALWAYS);

		grid.add(yourCartText, 1,0);
		grid.add(scroll, 0, 1,8,4);
		grid.add(total, 5, 5);
		// grid.add(scroll, 2, 5);
		grid.add(checkOutButton,6,6);
		grid.add(cancelOrderButton, 5, 6);
		
	

		grid.setHgap(5);
		grid.setVgap(5);
		grid.setAlignment(Pos.CENTER);

		this.mainView.add(grid, 0, 1);
	}
	
	
	
	public void addAllItemsToCart(Order newOrder)
	{
		return;
		int orderCount = newOrder.getOrderNum();
		Picture pic = new Picture("C:/Users/pavit/OneDrive/Desktop/CSE 360/CSE360/src/Hamburger.jpg", "Hamburger");
		MenuItem menu = new MenuItem("HamBurger", pic, 7,15,2);
		OrderItem newItem = new OrderItem(menu,"no lettuce",2,3,7);
		
		
		
		for(int i = 0; i < orderCount; i++)
		{
			newOrder.addOrderItem(newItem);
			
		}
	}
	
	public void removeAllItemsFromCart()
	{
		return;
	}
	
}

