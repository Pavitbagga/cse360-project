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
    public MenuView(int xSize, int ySize, ArrayList<Button> topButtons, String newPageTitle, Image newLogo) {

        super(xSize, ySize, topButtons, newPageTitle, newLogo);
        BorderPane root = new BorderPane();
        ScrollPane scroll = new ScrollPane();
        menuItems = new HBox();
        root.setCenter(scroll);
        scroll.setContent(menuItems);

        this.mainView.add(menuItems, 0, 1);
    }
}