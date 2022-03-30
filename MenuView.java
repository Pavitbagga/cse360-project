package org.openjfx;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class MenuView extends BaseModel{
    HBox menuItems = new HBox();
    HBox searchButtons = new HBox();
    HBox searchBar = new HBox();
    TextField search = new TextField();
    Button searchEnter = new Button("search");
    GridPane contentView;

    public MenuView(int xSize, int ySize, ArrayList<Button> topButtons, String newPageTitle, Image newLogo) {

        super(xSize, ySize, topButtons, newPageTitle, newLogo);
        contentView = new GridPane();
        BorderPane root = new BorderPane();
        ScrollBar scroll = new ScrollBar();

        //scroll bar
        root.setCenter(scroll);
        scroll.setOrientation(Orientation.VERTICAL);


        ColumnConstraints col0 = new ColumnConstraints();
        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        ColumnConstraints col3 = new ColumnConstraints();


        col0.setPercentWidth(15.0);
        col1.setPercentWidth(60.0);
        col2.setPercentWidth(10.0);
        col3.setPercentWidth(15.0);


        columns.add(col0);
        columns.add(col1);
        columns.add(col2);
        columns.add(col3);


        RowConstraints row0 = new RowConstraints();
        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();
        RowConstraints row3 = new RowConstraints();


        row0.setPercentHeight(15.0);
        row1.setPercentHeight(60.0);
        row2.setPercentHeight(10.0);
        row3.setPercentHeight(15.0);


        rows.add(row0);
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);


        contentView.getRowConstraints().addAll(rows);
        contentView.getColumnConstraints().addAll(columns);


        searchBar.getChildren().addAll(search);
        searchButtons.getChildren().addAll(searchBar,searchEnter);

        contentView.add(searchBar,2,1);
        contentView.add(searchButtons,3,1);
        contentView.add(scroll,5,1);

        contentView.setHgap(5);
        contentView.setVgap(5);
        contentView.setAlignment(Pos.CENTER);

        this.mainView.add(contentView, 0, 1);
    }
}
