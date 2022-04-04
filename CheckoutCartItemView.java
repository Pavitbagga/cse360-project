

import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;

public class CheckoutCartItemView extends GridPane{

    Text title;
    HBox quantityBox;
    Text quantityLabel;
    Text quantity;


    HBox priceBox;
    Text priceLabel;
    Text price;
    Text ingredientsLabel;
    ScrollPane ingredientsScroll;
    HBox ingredientLabelBox;
    Text size;
    Text sizeLabel;
    HBox sizeBox;

    Text ingredientsList;

    OrderItem item;

    public CheckoutCartItemView(OrderItem newItem, int xSize, int ySize){


        item = newItem;

        title = new Text(item.getItem().getName());
        quantityBox = new HBox();
        quantityLabel = new Text("Quantity: ");
        quantity = new Text("" + item.getQuantity());

        priceBox = new HBox();
        priceLabel = new Text("Price: ");
        price = new Text("" + item.getPrice());
        ingredientsLabel = new Text("Ingredients: ");
        ingredientsList = new Text();
        ingredientsScroll = new ScrollPane();
        ingredientLabelBox = new HBox();

        size = new Text();
        sizeLabel = new Text("Size: ");
        if(newItem.getSize() == 0){
            size.setText("Regular");
        }
        else if(newItem.getSize() == 1){
            size.setText("Medium");
        }

        else if(newItem.getSize() == 2){
            size.setText("Large");
        }

        sizeBox = new HBox();
        sizeBox.getChildren().add(sizeLabel);
        sizeBox.getChildren().add(size);

        String s = "";
        for (int i = 0; i < item.getItem().getIngredients().size(); i++){
            s += item.getItem().getIngredients().get(i) + "\n";
        }
        ingredientsList.setText(s);
        ingredientLabelBox.getChildren().add(ingredientsLabel);

        ingredientsScroll.setContent(ingredientsList);

        quantityBox.getChildren().addAll(quantityLabel);
        quantityBox.getChildren().addAll(quantity);

        priceBox.getChildren().add(priceLabel);
        priceBox.getChildren().add(price);

        ColumnConstraints c1 = new ColumnConstraints();
        ColumnConstraints c2 = new ColumnConstraints();
        ColumnConstraints c3 = new ColumnConstraints();
        ColumnConstraints c4 = new ColumnConstraints();

        c1.setPercentWidth(30.0);
        c2.setPercentWidth(17.5);
        c3.setPercentWidth(17.5);
        c4.setPercentWidth(30.0);

        this.getColumnConstraints().add(c1);
        this.getColumnConstraints().add(c2);
        this.getColumnConstraints().add(c3);
        this.getColumnConstraints().add(c4);


        RowConstraints r1 = new RowConstraints();
        RowConstraints r2 = new RowConstraints();

        r1.setPercentHeight(50.0);
        r2.setPercentHeight(50.0);




        this.getRowConstraints().add(r1);
        this.getRowConstraints().add(r2);

        this.add(title, 0, 0);
        this.add(quantityBox, 0, 1);

        this.add(ingredientLabelBox, 2, 0);
        this.add(ingredientsScroll, 3, 0, 1, 2);

        ingredientLabelBox.setAlignment(Pos.CENTER_RIGHT);

        this.add(priceBox, 1, 0);
        this.add(sizeBox, 1, 1);

        this.prefWidth(xSize * .3);
    }
    
}
