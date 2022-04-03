

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
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
    Button deleteItemButton;
    TextField searchBar;
    Group categoryGroup;
    Button cakeRadioButton;
    Button smoothieRadioButton;
    Button iceCreamRadioButton;
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

    MenuItem item;
    
    int selectedMode;
    int selectedCategory;

    public EditItemView(int xSize, int ySize, ArrayList<Button> topButtons, String newPageTitle, Image newLogo, String newPWD) {

        super(xSize, ySize, topButtons, newPageTitle, newLogo, newPWD);
        item = new MenuItem("", new Picture("cake.jpeg", "cake"), -1, -1, -1);

        selectedCategory = 0;
        selectedMode = 0;

        wholeView = new VBox();

        addNewItemButton = new Button("Add new item");
        deleteItemButton = new Button("Delete Item");
        editExistingItemButton = new Button("Edit existing item");
        searchGoButton = new Button("Go");
        createItemButton = new Button("Create item");
        searchBar = new TextField();
        categoryGroup = new Group();
        cakeRadioButton = new Button("Cake");
        smoothieRadioButton = new Button("Smoothie");
        iceCreamRadioButton = new Button("Ice cream");
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

        addEditButtonsHBox = new HBox(20);
        addEditButtonsHBox.setAlignment(Pos.CENTER);
        searchGoHBox = new HBox(20);
        searchGoHBox.setAlignment(Pos.CENTER);
        radioButtonsHBox = new HBox(20);
        radioButtonsHBox.setAlignment(Pos.CENTER);
        foodItemNameHBox = new HBox(20);
        foodItemNameHBox.setAlignment(Pos.CENTER);
        ingredientsListHBox = new HBox(20);
        ingredientsListHBox.setAlignment(Pos.CENTER);
        foodTagsListHbox = new HBox(20);
        foodTagsListHbox.setAlignment(Pos.CENTER);

        priceHBox = new HBox(20);
        priceHBox.setAlignment(Pos.CENTER);
        prepTimeHBox = new HBox(20);
        prepTimeHBox.setAlignment(Pos.CENTER);

        leftVBox = new VBox(20);
        leftVBox.setAlignment(Pos.CENTER);
        rightVBox = new VBox(20);
        rightVBox.setAlignment(Pos.CENTER);

        contentHBox = new HBox(20);
        contentHBox.setAlignment(Pos.CENTER);

        buttonsVBox = new VBox(20);
        buttonsVBox.setAlignment(Pos.CENTER);

        foodItemNameText.setText("Food Item Name: ");
        ingredientListText.setText("Ingredients List: ");
        foodTagsText.setText("Picture URL: ");
        priceText.setText("Price: ");
        prepTimeText.setText("Prep Time: ");

        addEditButtonsHBox.getChildren().addAll(addNewItemButton,editExistingItemButton, deleteItemButton);
        searchGoHBox.getChildren().addAll(searchBar,searchGoButton);
        radioButtonsHBox.getChildren().addAll(cakeRadioButton,iceCreamRadioButton,smoothieRadioButton);
        foodItemNameHBox.getChildren().addAll(foodItemNameText,foodItemNewName);
        ingredientsListHBox.getChildren().addAll(ingredientListText,ingredientListTextField);
        foodTagsListHbox.getChildren().addAll(foodTagsText,foodTagsTextField);

        cakeRadioButton.setStyle("-fx-background-color: #00FF00");
        smoothieRadioButton.setStyle("");
        iceCreamRadioButton.setStyle("");
        
        editExistingItemButton.setStyle("-fx-background-color: #00FF00");
        createItemButton.setStyle("");
        deleteItemButton.setStyle("");

        leftVBox.getChildren().addAll(addEditButtonsHBox,searchGoHBox,radioButtonsHBox,foodItemNameHBox,ingredientsListHBox,foodTagsListHbox);

        priceHBox.getChildren().addAll(priceText,newPriceTextField);
        prepTimeHBox.getChildren().addAll(prepTimeText,prepTimeTextField);

        rightVBox.getChildren().addAll(priceHBox,prepTimeHBox,createItemButton);

        contentHBox.getChildren().addAll(leftVBox,rightVBox);

        wholeView.getChildren().addAll(contentHBox);

        this.mainView.add(wholeView, 0, 1);


    }

    public void removeAllFields(){
        foodTagsTextField.setText("");
        searchBar.setText("");
        foodItemNewName.setText("");
        ingredientListTextField.setText("");
        foodTagsTextField.setText("");
        newPriceTextField.setText("");
        prepTimeTextField.setText("");

        foodTagsTextField.setEditable(true);
        searchBar.setEditable(true);
        foodItemNewName.setEditable(true);
        ingredientListTextField.setEditable(true);
        foodTagsTextField.setEditable(true);
        newPriceTextField.setEditable(true);
        prepTimeTextField.setEditable(true);
        item = new MenuItem("", new Picture("", ""), -1, -1, -1);



    }
}
