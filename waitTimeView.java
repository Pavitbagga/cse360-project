package org.openjfx;


import javafx.scene.image.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.*;
import java.lang.*;
// import javafx.application.Application;
import javafx.scene.text.*;
import javafx.geometry.Pos;
// import javafx.scene.Group;
// import javafx.scene.Scene;
// import javafx.stage.Stage;
// import javafx.scene.paint.Color;
// import javafx.event.ActionEvent;
import javafx.scene.control.Button;


public class waitTimeView extends BaseModel
{
	Text waitTimeText;
	Text readyTimeText;
	Text readyTime;
	Text ordersText;
	Text minutesText;
	Text numberOrdersText;
	Text numberOrders;
	int minutes,placeInLine;
	GridPane grid;
	VBox waitVBox,numOrderVBox;
	
	public waitTimeView(int xSize, int ySize,  ArrayList<Button> topButtons, String newPageTitle, Image newLogo, String newPWD)
	{
		super(xSize, ySize, topButtons, newPageTitle, newLogo, newPWD);
		
		

		waitTimeText = new Text("WAIT TIME");
		waitTimeText.setFont(Font.font("Arial", FontWeight.BOLD,25));
		
		readyTimeText = new Text("Your Order will be ready in:\n");
		readyTimeText.setFont(Font.font("Arial",FontWeight.NORMAL,18));
		readyTime = new Text();
		readyTime.setFont(Font.font("Arial",FontWeight.BOLD,45));

		ordersText = new Text("Orders");
		ordersText.setFont(Font.font("Arial",FontWeight.NORMAL,18));
		minutesText = new Text("Minutes");
		minutesText.setFont(Font.font("Arial",FontWeight.NORMAL,18));

		numberOrdersText = new Text("Number of Orders before yours:\n");
		numberOrdersText.setFont(Font.font("Arial", FontWeight.NORMAL,18));
		numberOrders = new Text();
		numberOrders.setFont(Font.font("Arial", FontWeight.BOLD,45));

		grid = new GridPane();
		// grid.setGridLinesVisible(true);

		waitVBox = new VBox();
		waitVBox.setStyle("-fx-background-color: lightgrey;");
		waitVBox.getChildren().add(readyTimeText);
		waitVBox.getChildren().add(readyTime);
		waitVBox.getChildren().add(minutesText);
		waitVBox.setAlignment(Pos.CENTER);
		
		

		numOrderVBox = new VBox();
		numOrderVBox.setStyle("-fx-background-color: lightgrey;");
		numOrderVBox.getChildren().add(numberOrdersText);
		numOrderVBox.getChildren().add(numberOrders);
		numOrderVBox.getChildren().add(ordersText);
		numOrderVBox.setAlignment(Pos.CENTER);
		
		

		ColumnConstraints column1 = new ColumnConstraints();
		ColumnConstraints column2 = new ColumnConstraints();
		// ColumnConstraints column3 = new ColumnConstraints();
		// ColumnConstraints column4 = new ColumnConstraints();
		// ColumnConstraints column5 = new ColumnConstraints();
		
		column1.setPercentWidth(60.0);
		column2.setPercentWidth(20.0);
		// column3.setPercentWidth(20.0);
		// column4.setPercentWidth(27.0);
		// column5.setPercentWidth(20.0);

		columns.add(column1);
		columns.add(column2);
		// columns.add(column3);
		// columns.add(column4);
		// columns.add(column5);
		

		RowConstraints row1 = new RowConstraints();
		RowConstraints row2 = new RowConstraints();
		RowConstraints row3 = new RowConstraints();

		row1.setPercentHeight(30.0);
		row2.setPercentHeight(50.0);
		row3.setPercentHeight(20.0);

		rows.add(row1);
		rows.add(row2);
		rows.add(row3);


		grid.getRowConstraints().addAll(rows);
		grid.getColumnConstraints().addAll(columns);

		grid.add(waitTimeText, 1, 0);
		grid.add(waitVBox, 1, 1);
		grid.add(numOrderVBox,3,1);



		grid.setHgap(5);
		grid.setVgap(5);
		grid.setAlignment(Pos.CENTER);

		this.mainView.add(grid, 0, 1);
		

	}



	
}
