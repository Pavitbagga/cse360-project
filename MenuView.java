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
    VBox menuItems = new VBox();
    HBox searchButtons = new HBox();
    HBox searchBar = new HBox();
    TextField search = new TextField();
    Button searchEnter = new Button("search");
    GridPane contentView;
    ScrollPane scroll;
    int localXsize;
    int localYsize;

    public MenuView(int xSize, int ySize, ArrayList<Button> topButtons, String newPageTitle, Image newLogo, String newPWD) {

        super(xSize, ySize, topButtons, newPageTitle, newLogo, newPWD);


        localXsize = xSize;
        localYsize = ySize;
        contentView = new GridPane();
        scroll = new ScrollPane();


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
        row1.setPercentHeight(85.0);


        contentView.getRowConstraints().add(row0);
        contentView.getRowConstraints().add(row1);

        contentView.getColumnConstraints().add(col0);
        contentView.getColumnConstraints().add(col1);
        contentView.getColumnConstraints().add(col2);
        contentView.getColumnConstraints().add(col3);


        // contentView.getRowConstraints().addAll(rows);
        // contentView.getColumnConstraints().addAll(columns);

        contentView.add(search,1,0);
        contentView.add(searchEnter,2,0);
        contentView.add(scroll, 1, 1, 3, 1);

        scroll.setContent(menuItems);

        Text test1 = new Text("Test1");
        Text test2 = new Text("Test2");
        Text test3 = new Text("Test3");
        Text test4 = new Text("Test4");

        menuItems.getChildren().add(test1);
        menuItems.getChildren().add(test2);
        menuItems.getChildren().add(test3);
        menuItems.getChildren().add(test4);


        contentView.setHgap(5);
        contentView.setVgap(5);
        contentView.setAlignment(Pos.CENTER);

        // contentView.setGridLinesVisible(true);

        this.mainView.add(contentView, 0, 1);
    }

    public void addAll(ArrayList<MenuItemMiniView> menuList){
        for (int i = 0; i < menuList.size(); i++){
            
            this.menuItems.getChildren().add(menuList.get(i));
        }
    }

    public void removeAllItems(){

        this.menuItems.getChildren().clear();
    }
}
