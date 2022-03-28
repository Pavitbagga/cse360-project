import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.awt.*;
import java.util.ArrayList;

public class MenuView extends BaseModel{
    HBox menuItems;
    HBox wholeView;
    HBox searchButtons;
    HBox searchBar;
    TextField search;
    Button searchEnter;

    public MenuView(int xSize, int ySize, ArrayList<Button> topButtons, String newPageTitle, Image newLogo) {

        super(xSize, ySize, topButtons, newPageTitle, newLogo);

        wholeView = new HBox();
        BorderPane root = new BorderPane();
        ScrollPane scroll = new ScrollPane();

        //scroll bar
        menuItems = new HBox();
        root.setCenter(scroll);
        scroll.setContent(menuItems);

        //search bar
        searchBar = new HBox();
        search = new TextField();
        searchEnter = new Button("search");
        searchButtons = new HBox();

        searchBar.getChildren().addAll(search);
        searchButtons.getChildren().addAll(searchBar,searchEnter);
        wholeView.getChildren().addAll(searchButtons,menuItems,scroll);

        this.mainView.add(wholeView, 0, 1);
    }
}