package org.openjfx;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

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
    Text ingredientsList;
    Text foodName;
    ImageView food;
    Image foodItem;
    HBox addSubBox = new HBox();
    VBox sizing = new VBox();
    HBox textBox = new HBox();
    ScrollPane ingScroll;

    int buttonSelected;

    public MenuItemView(int xSize, int ySize, ArrayList<Button> topButtons, String newPageTitle, Image newLogo, MenuItem newMenuItem) {

        super(xSize, ySize, topButtons, newPageTitle, newLogo);
        
        
        
        buttonSelected = 0;
        regular.setStyle("-fx-background-color: #00FF00");



        contentView = new GridPane();
        ingScroll = new ScrollPane();
        foodName = new Text("Food Item Name: " + newMenuItem.getName());
        amount = new Text("$   " + newMenuItem.getPrice());
        quantity = new Text("     1     ");
        ingredients = new Text("Ingredients:");
        ingredientsList = new Text();
        String s = "";
        for (int i = 0; i < newMenuItem.getIngredients().size(); i++){
            s += "-" + newMenuItem.getIngredients().get(i) + " \n";
        }
        ingredientsList.setText(s);

        ingScroll.setContent(ingredientsList);

        // amount.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        // foodName.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        // ingredients.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        ColumnConstraints col0 = new ColumnConstraints();
        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();

        col0.setPercentWidth(40.0);
        col1.setPercentWidth(30.0);
        col2.setPercentWidth(30.0);

        columns.add(col0);
        columns.add(col1);
        columns.add(col2);

        RowConstraints row0 = new RowConstraints();
        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();
        RowConstraints row3 = new RowConstraints();
        RowConstraints row4 = new RowConstraints();

        row0.setPercentHeight(20.0);
        row1.setPercentHeight(20.0);
        row2.setPercentHeight(20.0);
        row3.setPercentHeight(20.0);
        row4.setPercentHeight(20.0);

        rows.add(row0);
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);

        contentView.getRowConstraints().add(row0);
        contentView.getRowConstraints().add(row1);
        contentView.getRowConstraints().add(row2);
        contentView.getRowConstraints().add(row3);
        contentView.getRowConstraints().add(row4);
        contentView.getColumnConstraints().add(col0);
        contentView.getColumnConstraints().add(col1);
        contentView.getColumnConstraints().add(col2);

        sizing.getChildren().addAll(regular,medium,large);

        regular.setAlignment(Pos.CENTER);
        medium.setAlignment(Pos.CENTER);
        large.setAlignment(Pos.CENTER);

        sizing.setAlignment(Pos.CENTER);

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

        textBox.getChildren().add(ingredients);

        contentView.add(textBox,1,1);
        contentView.add(ingScroll,1,2);
        textBox.setAlignment(Pos.BOTTOM_LEFT);
        


        contentView.add(amount,1,3);

        addSubBox.getChildren().addAll(minus, quantity, plus);

        addSubBox.setAlignment(Pos.CENTER);

        contentView.add(addSubBox,2,2);
        contentView.add(sizing,2,1);
        contentView.add(addToCart,2,4);
        // contentView.setGridLinesVisible(true);

        contentView.setHgap(5);
        contentView.setVgap(5);
        // contentView.setAlignment(Pos.CENTER);



        this.mainView.add(contentView, 0, 1);
    }
}
