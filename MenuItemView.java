package org.openjfx;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class MenuItemView extends BaseModel{

    public GridPane contentView;
    Button regular = new Button("Regular");
    Button medium = new Button("Medium");
    Button large = new Button("Large");
    Button addToCart = new Button("ADD TO CART");
    Button plus = new Button("+");
    Button minus = new Button("-");
    Text quantity;
    Text amount;
    Text ingredients;
    Text foodName;
    ImageView food;
    Image foodItem;
    HBox addSubBox = new HBox();
    VBox sizing = new VBox();

    public MenuItemView(int xSize, int ySize, ArrayList<Button> topButtons, String newPageTitle, Image newLogo, MenuItem newMenuItem) {

        super(xSize, ySize, topButtons, newPageTitle, newLogo);
        contentView = new GridPane();
        foodName = new Text("Food Item Name: " + newMenuItem.getName());
        amount = new Text("$   " + newMenuItem.getPrice());
        quantity = new Text("     1     ");
        ingredients = new Text();
        String s = "Ingredients: ";
        for (int i = 0; i < newMenuItem.getIngredients().size(); i++){
            s += newMenuItem.getIngredients().get(i) + " \n";
        }
        ingredients.setText(s);

        amount.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        foodName.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        ingredients.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        ColumnConstraints col0 = new ColumnConstraints();
        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        ColumnConstraints col3 = new ColumnConstraints();

        col0.setPercentWidth(40.0);
        col1.setPercentWidth(10.0);
        col2.setPercentWidth(30.0);
        col3.setPercentWidth(20.0);

        columns.add(col0);
        columns.add(col1);
        columns.add(col2);
        columns.add(col3);

        RowConstraints row0 = new RowConstraints();
        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();
        RowConstraints row3 = new RowConstraints();
        RowConstraints row4 = new RowConstraints();
        RowConstraints row5 = new RowConstraints();

        row1.setPercentHeight(17.0);
        row2.setPercentHeight(17.0);
        row3.setPercentHeight(17.0);
        row4.setPercentHeight(17.0);
        row5.setPercentHeight(17.0);

        rows.add(row0);
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        rows.add(row5);

        contentView.getRowConstraints().addAll(rows);
        contentView.getColumnConstraints().addAll(columns);

        sizing.getChildren().addAll(regular,medium,large);

        try{
            InputStream in = new FileInputStream(newMenuItem.getPicture().getUrl());
            foodItem = new Image(in);
            food = new ImageView();
            food.setImage(foodItem);
            food.setFitWidth(xSize*.40);
            food.setFitHeight(ySize*.30);
            food.setPreserveRatio(true);
            contentView.add(food,0,1, 1, 3);
        }
        catch(Exception E){
            System.out.println("image not found");
            System.out.print(E.toString());
        }


        contentView.add(foodName, 0, 0);
        contentView.add(ingredients,1,1);
        contentView.add(amount,1,3);

        addSubBox.getChildren().addAll(minus, quantity, plus);
        contentView.add(addSubBox,2,2);
        contentView.add(sizing,2,1);
        contentView.add(addToCart,2,4);
        //contentView.setGridLinesVisible(true);

        contentView.setHgap(5);
        contentView.setVgap(5);
        contentView.setAlignment(Pos.CENTER);

        this.mainView.add(contentView, 0, 1);
    }
}
