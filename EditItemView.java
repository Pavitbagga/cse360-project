
import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

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

    ToggleGroup radioToggle;

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

    HBox contentHBox;

    VBox buttonsVBox;

    VBox wholeView;

    public EditItemView(int xSize, int ySize, ArrayList<Button> topButtons, String newPageTitle, Image newLogo) {

        super(xSize, ySize, topButtons, newPageTitle, newLogo);

        wholeView = new VBox();

        addNewItemButton = new Button("Add new item");
        editExistingItemButton = new Button("Edit existing item");
        searchGoButton = new Button("Go");
        createItemButton = new Button("Create item");
        searchBar = new TextField();
        categoryGroup = new Group();
        cakeRadioButton = new RadioButton("Cake");
        smoothieRadioButton = new RadioButton("Smoothie");
        iceCreamRadioButton = new RadioButton("Ice cream");
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

        radioToggle = new ToggleGroup();

        addEditButtonsHBox = new HBox();
        searchGoHBox = new HBox();
        radioButtonsHBox = new HBox();
        foodItemNameHBox = new HBox();
        ingredientsListHBox = new HBox();
        foodTagsListHbox = new HBox();

        priceHBox = new HBox();
        prepTimeHBox = new HBox();

        leftVBox = new VBox();
        rightVBox = new VBox();

        contentHBox = new HBox();

        buttonsVBox = new VBox();

        foodItemNameText.setText("Food Item Name: ");
        ingredientListText.setText("Ingredients List: ");
        foodTagsText.setText("Food Tags List: ");
        priceText.setText("Price: ");
        prepTimeText.setText("Prep Time: ");

        addEditButtonsHBox.getChildren().addAll(addNewItemButton,editExistingItemButton);
        searchGoHBox.getChildren().addAll(searchBar,searchGoButton);
        radioButtonsHBox.getChildren().addAll(cakeRadioButton,iceCreamRadioButton,smoothieRadioButton);
        foodItemNameHBox.getChildren().addAll(foodItemNameText,foodItemNewName);
        ingredientsListHBox.getChildren().addAll(ingredientListText,ingredientListTextField);
        foodTagsListHbox.getChildren().addAll(foodTagsText,foodTagsTextField);

        cakeRadioButton.setToggleGroup(radioToggle);
        smoothieRadioButton.setToggleGroup(radioToggle);
        iceCreamRadioButton.setToggleGroup(radioToggle);

        leftVBox.getChildren().addAll(addEditButtonsHBox,searchGoHBox,radioButtonsHBox,foodItemNameHBox,ingredientsListHBox,foodTagsListHbox);

        priceHBox.getChildren().addAll(priceText,newPriceTextField);
        prepTimeHBox.getChildren().addAll(prepTimeText,prepTimeTextField);

        rightVBox.getChildren().addAll(priceHBox,prepTimeHBox,createItemButton);

        contentHBox.getChildren().addAll(leftVBox,rightVBox);

        wholeView.getChildren().addAll(contentHBox);

        this.mainView.add(wholeView, 0, 1);


    }
}
