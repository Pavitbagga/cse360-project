
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
    //public GridPane grid;
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
    //ImageView food;
    //Image foodItem;
    HBox addSubBox = new HBox();

    public MenuItemView(int xSize, int ySize, ArrayList<Button> topButtons, String newPageTitle, Image newLogo) {

        super(xSize, ySize, topButtons, newPageTitle, newLogo);

        contentView = (GridPane) super.getRoot();

        amount.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        foodName.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        ingredients.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        contentView.add(foodName, 1, 0);
        contentView.add(ingredients,1,2);
        contentView.add(amount,1,4);
        contentView.add(regular,2,1);
        contentView.add(medium,2,2);
        contentView.add(large,2,3);
        addSubBox.getChildren().addAll(minus, quantity, plus);
        contentView.add(addSubBox,2,4);
        contentView.add(addToCart,2,5);

        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        ColumnConstraints col3 = new ColumnConstraints();
        col1.setPercentWidth(40.0);
        col2.setPercentWidth(30.0);
        col3.setPercentWidth(30.0);


        columns.add(col1);
        columns.add(col2);
        columns.add(col3);

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

        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        rows.add(row5);

        contentView.getRowConstraints().addAll(rows);
        contentView.getColumnConstraints().addAll(columns);

        contentView.setHgap(5);
        contentView.setVgap(5);
        contentView.setAlignment(Pos.CENTER);

        this.mainView.add(contentView, 0, 1);
    }
}

