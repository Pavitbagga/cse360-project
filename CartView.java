package org.openjfx;

import java.util.ArrayList;

// import com.sun.prism.paint.Color;

// import javafx.event.ActionEvent;
// import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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
	VBox orderItemsList;
	Text yourCartText;
	Button cancelOrderButton;
	Button checkOutButton;
	Order thisOrder;
	GridPane grid;
	HBox buttonContainer;
	HBox itemsContainter;
	
	public CartView(int xSize, int ySize, ArrayList<Button> topButtons, String newPageTitle, Image newLogo, Order newOrder)
	{
		super (xSize, ySize, topButtons, newPageTitle, newLogo);
		
		grid = new GridPane();

		total = new Text("Total: $");
		yourCartText = new Text("YOUR CART");
		cancelOrderButton = new Button("Cancel Order");
		checkOutButton = new Button("Checkout");
		itemsContainter = new HBox();

		total.setFont(Font.font("Arial", FontWeight.BOLD,12));
		yourCartText.setFont(Font.font("Arial", FontWeight.BOLD,25));

		itemsContainter.setMaxHeight(80.0);
		itemsContainter.setPrefHeight(80.0);
		itemsContainter.setPrefWidth(100.0);
		itemsContainter.setMaxWidth(100.0);
		

		
		ColumnConstraints column1 = new ColumnConstraints();
		ColumnConstraints column2 = new ColumnConstraints();
		ColumnConstraints column3 = new ColumnConstraints();
		ColumnConstraints column4 = new ColumnConstraints();
		ColumnConstraints column5 = new ColumnConstraints();
		
		column1.setPercentWidth(20.0);
		column2.setPercentWidth(20.0);
		column3.setPercentWidth(20.0);
		column4.setPercentWidth(20.0);
		column5.setPercentWidth(25.0);

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

		
		grid.add(yourCartText, 1,0);
		grid.add(itemsContainter, 0, 1);
		grid.add(total, 5, 4);
		buttonContainer.getChildren().addAll(cancelOrderButton,checkOutButton);
		grid.add(buttonContainer, 5, 5);

		grid.setHgap(5);
		grid.setVgap(5);
		grid.setAlignment(Pos.CENTER);

		this.mainView.add(grid, 0, 1);
	}
	
	
	
	public void addAllItemsToCart(Order newOrder)
	{
		return;
	}
	
	public void removeAllItemsFromCart()
	{
		return;
	}
	
}


