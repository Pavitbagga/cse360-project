import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class EditItemView extends BaseModel {

    Button addNewItemButton;
    Button editExistingItemButton;
    Button searchGoButton;
    Button createItemButton;
    TextField searchBar;
    Group categoryGroup;
    RadioButton cakeRadioButton;
    RadioButton smoothieRadioButton;
    RadioButton iceCreamRadioButton;
    Text foodItemNameText;
    TextField foodItemNewName;
    Text ingredientListText;
    TextField ingredientListTextField;
    Text foodTagsText;
    TextField foodTagsTextField;
    Text priceText;
    TextField newPriceTextField;
    Text prepTimeText;
    TextField prepTimeTextField;

    HBox addEditButtonsHBox;
    HBox searchGoHBox;
    HBox radioButtonsHBox;
    HBox foodItemNameHBox;
    HBox ingredientsListHBox;
    HBox foodTagsListHbox;

    VBox leftVBox;

    HBox priceHBox;
    HBox prepTimeHBox;

    VBox rightVBox;

    HBox wholeView;

    public EditItemView(int xSize, int ySize, ArrayList<Button> buttonList, String newPageTitle, Image newLogo) {

        super(new GridPane(),xSize,ySize,Color.web("FFFFFF"));

        wholeView = (HBox) super.getRoot();

        //elements of the scene
        addNewItemButton = new Button();
        editExistingItemButton = new Button();
        searchGoButton = new Button();
        createItemButton = new Button();
        searchBar = new TextField();
        categoryGroup = new Group();
        cakeRadioButton = new RadioButton();
        smoothieRadioButton = new RadioButton();
        iceCreamRadioButton = new RadioButton();
        foodItemNameText = new Text();
        foodItemNewName = new TextField();
        ingredientListText = new Text();
        ingredientListTextField = new TextField();
        foodTagsText = new Text();
        foodTagsTextField = new TextField();
        priceText = new Text();
        newPriceTextField = new TextField();
        prepTimeText = new Text();
        prepTimeTextField = new TextField();

        //hboxes on the left
        addEditButtonsHBox = new HBox();
        searchGoHBox = new HBox();
        radioButtonsHBox = new HBox();
        foodItemNameHBox = new HBox();
        ingredientsListHBox = new HBox();
        foodTagsListHbox = new HBox();

        //hboxes for the left
        priceHBox = new HBox();
        prepTimeHBox = new HBox();

        leftVBox = new VBox();
        rightVBox = new VBox();

        //set text for labels
        foodItemNameText.setText("Food Item Name: ");
        ingredientListText.setText("Ingredients List: ");
        foodTagsText.setText("Food Tags List: ");
        priceText.setText("Price: ");
        prepTimeText.setText("Prep Time: ");

        //add to the left hboxes
        addEditButtonsHBox.getChildren().addAll(addNewItemButton,editExistingItemButton);
        searchGoHBox.getChildren().addAll(searchBar,searchGoButton);
        radioButtonsHBox.getChildren().addAll(cakeRadioButton,iceCreamRadioButton,smoothieRadioButton);
        foodItemNameHBox.getChildren().addAll(foodItemNameText,foodItemNewName);
        ingredientsListHBox.getChildren().addAll(ingredientListText,ingredientListTextField);
        foodTagsListHbox.getChildren().addAll(foodTagsText,foodTagsTextField);

        //add all of the left hboxes to the left vbox
        leftVBox.getChildren().addAll(addEditButtonsHBox,searchGoHBox,radioButtonsHBox,foodItemNameHBox,ingredientsListHBox,foodTagsListHbox);

        //add to the right hboxes
        priceHBox.getChildren().addAll(priceText,newPriceTextField);
        prepTimeHBox.getChildren().addAll(prepTimeText,prepTimeTextField);

        //add the right hboxes to the right vbox
        rightVBox.getChildren().addAll(priceHBox,prepTimeHBox,createItemButton);

        //add both vboxes to the scene?
        wholeView.getChildren().addAll(leftVBox,rightVBox);

    }
}
