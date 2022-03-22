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
import javafx.stage.Stage;

public class EditItemView extends Scene {

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

    HBox contentHBox;

    VBox buttonsVBox;

    HBox topHBox;

    ImageView topLogoView;

    VBox wholeView;

    public EditItemView(Stage stage, int xSize, int ySize, Button[] topButtons, String newPageTitle, Image newLogo) {

        super(new GridPane(),xSize,ySize,Color.web("FFFFFF"));

        wholeView = (VBox) super.getRoot();

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
        topHBox = new HBox();

        topLogoView = new ImageView();

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

        leftVBox.getChildren().addAll(addEditButtonsHBox,searchGoHBox,radioButtonsHBox,foodItemNameHBox,ingredientsListHBox,foodTagsListHbox);

        priceHBox.getChildren().addAll(priceText,newPriceTextField);
        prepTimeHBox.getChildren().addAll(prepTimeText,prepTimeTextField);

        rightVBox.getChildren().addAll(priceHBox,prepTimeHBox,createItemButton);

        contentHBox.getChildren().addAll(leftVBox,rightVBox);

        for (Button b : topButtons) {
            buttonsVBox.getChildren().add(b);
        }

        topLogoView.setImage(newLogo);
        topHBox.getChildren().addAll(topLogoView,buttonsVBox);

        wholeView.getChildren().addAll(topHBox,contentHBox);





















    }
}
