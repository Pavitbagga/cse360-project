

import java.util.ArrayList;

// import com.sun.prism.paint.Color;

// import javafx.event.ActionEvent;
// import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;


public class CartView extends BaseModel
{
	Text total;
	Text totalLabel;
	VBox orderItemsList;
	Text yourCartText;
	Button cancelOrderButton;
	Button checkOutButton;
	GridPane grid;
	HBox buttonContainer;
	VBox itemsContainter;
	int insideXSize;
	int insideYSize;
	ScrollPane itemsScroll;
	
	public CartView(int xSize, int ySize, ArrayList<Button> topButtons, String newPageTitle, Image newLogo, Order newOrder, String newPWD)
	{
		super (xSize, ySize, topButtons, newPageTitle, newLogo, newPWD);
		
		insideXSize = xSize;
		insideYSize = ySize;

		grid = new GridPane();

		totalLabel = new Text("Total: $: ");
		total = new Text();
		yourCartText = new Text("YOUR CART");
		cancelOrderButton = new Button("Cancel Order");
		checkOutButton = new Button("Checkout");
		itemsContainter = new VBox();
		itemsScroll = new ScrollPane();

		total.setFont(Font.font("Arial", FontWeight.BOLD,12));
		yourCartText.setFont(Font.font("Arial", FontWeight.BOLD,25));




		// System.out.println("Got to here 1 CartView");

		
		ColumnConstraints column1 = new ColumnConstraints();
		ColumnConstraints column2 = new ColumnConstraints();
		ColumnConstraints column3 = new ColumnConstraints();
		ColumnConstraints column4 = new ColumnConstraints();
		
		column1.setPercentWidth(20.0);
		column2.setPercentWidth(50.0);
		column3.setPercentWidth(15.0);
		column4.setPercentWidth(15.0);

		grid.getColumnConstraints().add(column1);
		grid.getColumnConstraints().add(column2);
		grid.getColumnConstraints().add(column3);
		grid.getColumnConstraints().add(column4);
		

		RowConstraints row1 = new RowConstraints();
		RowConstraints row2 = new RowConstraints();
		RowConstraints row3 = new RowConstraints();
		RowConstraints row4 = new RowConstraints();

		row1.setPercentHeight(15.0);
		row2.setPercentHeight(50.0);
		row3.setPercentHeight(15.0);
		row4.setPercentHeight(15.0);


		grid.getRowConstraints().add(row1);
		grid.getRowConstraints().add(row2);
		grid.getRowConstraints().add(row3);

		itemsScroll.setContent(itemsContainter);

		// System.out.println("Got to here 2 CartView");
		
		grid.add(yourCartText, 0,0);
		grid.add(itemsScroll, 0, 1, 4, 1);
		grid.add(totalLabel, 2, 2);
		grid.add(total, 3, 2);
		grid.add(cancelOrderButton, 2, 3);
		grid.add(checkOutButton, 3, 3);

		// System.out.println("Got to here 3 CartView");

		grid.setHgap(5);
		grid.setVgap(5);
		grid.setAlignment(Pos.CENTER);

		this.mainView.add(grid, 0, 1);
	}
	
	
	
	
	
}


