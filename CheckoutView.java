import java.nio.file.ClosedWatchServiceException;
import java.util.ArrayList;

import javafx.css.converter.LadderConverter;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class CheckoutView extends BaseModel
{
    Text checkOutText;
    Text cartText;
    Button logInButton;
    Button editCartButton;
    Button cancelOrderButton;
    Text paymentInfoText;
    GridPane checkOutGridPane;
    GridPane paymentInfoGridPane;
    VBox cartItemsVBox;
    GridPane cartGridPane;
    TextField nameTextField;
    TextField emailTextField;
    TextField phoneNumTextField;
    Text registeredUsersOnlyText;
    TextField cardNumTextField;
    TextField cardExpDateTextField;
    TextField secCodeTextField;
    TextField zipCodeTextField;
    TextField couponCodeTextField;
    Text nameText;
    Text emailText;
    Text phoneNumText;
    Text cardNumText;
    Text cardExpDateText;
    Text secCodeText;
    Text zipCodeText;
    Text couponCodeText;
    HBox buttonBox;
    GridPane separationGrid;
    CheckBox check;
    Text useSaveCardInfoText;
    Text itemsList;
    Text totalText;
    Button placeOrderButton;
    VBox placeOrderVBox;
    public CheckoutView(int xSize,int ySize,ArrayList<Button> topButtons, String newPageTitle, Image newLogo, Order newOrder)
    {
        super(xSize, ySize, topButtons, newPageTitle, newLogo);

        cartGridPane = new GridPane();
        checkOutGridPane = new GridPane();
        paymentInfoGridPane = new GridPane();
        
        checkOutText = new Text("CHECKOUT");
        checkOutText.setFont(Font.font("Arial",FontWeight.BOLD,20));
        cartText = new Text("CART");
        logInButton = new Button("Log In");
        editCartButton = new Button("Edit Cart");
        cancelOrderButton = new Button("Cancel Order");
        placeOrderButton = new Button("PLACE YOUR ORDER");
        paymentInfoText = new Text("PAYMENT INFO");
        paymentInfoText.setFont(Font.font("Arial",FontWeight.BOLD,20));
        cartItemsVBox = new VBox();

        nameTextField = new TextField();
        emailTextField = new TextField();
        phoneNumTextField = new TextField();

        registeredUsersOnlyText = new Text("For Registered Users only: ");
        useSaveCardInfoText = new Text("Use saved card info");
        nameText = new Text("Name: ");
        emailText = new Text("Email: ");
        phoneNumText = new Text("Phone Number: ");
        cardNumText = new Text("Card Number: ");
        cardExpDateText = new Text("Expiration Date: ");
        secCodeText = new Text("Security Code: ");
        zipCodeText = new Text("Zip Code: ");
        couponCodeText = new Text("Coupon Code ");


        cardNumTextField = new TextField();
        cardExpDateTextField = new TextField();
        secCodeTextField = new TextField();
        zipCodeTextField = new TextField();
        couponCodeTextField = new TextField();
        check = new CheckBox();
        totalText = new Text("Total: $");
        totalText.setFont(Font.font("Arial",FontWeight.SEMI_BOLD,20));

        checkOutGridPane.add(checkOutText, 0, 0);
        checkOutGridPane.add(logInButton, 1, 1);
        checkOutGridPane.add(nameText,2, 3);
        checkOutGridPane.add(nameTextField, 3, 3);
        checkOutGridPane.add(emailText, 2, 4);
        checkOutGridPane.add(emailTextField,3, 4);
        checkOutGridPane.add(phoneNumText, 2, 5);
        checkOutGridPane.add(phoneNumTextField, 3, 5);     
        checkOutGridPane.setAlignment(Pos.TOP_LEFT);
        // checkOutGridPane.setGridLinesVisible(true);

        paymentInfoGridPane.add(paymentInfoText, 0, 0);
        paymentInfoGridPane.add(registeredUsersOnlyText, 0, 1);
        paymentInfoGridPane.add(cardNumText, 1, 4);
        paymentInfoGridPane.add(cardNumTextField, 2, 4);
        paymentInfoGridPane.add(cardExpDateText, 1, 5);
        paymentInfoGridPane.add(cardExpDateTextField, 2, 5);
        paymentInfoGridPane.add(secCodeText, 1, 6);
        paymentInfoGridPane.add(secCodeTextField, 2, 6);
        paymentInfoGridPane.add(zipCodeText, 1, 7);
        paymentInfoGridPane.add(zipCodeTextField, 2, 7);
        paymentInfoGridPane.add(useSaveCardInfoText, 1, 2);
        paymentInfoGridPane.setHalignment(check, HPos.RIGHT);
        paymentInfoGridPane.add(check, 0, 2);
        paymentInfoGridPane.setAlignment(Pos.TOP_LEFT);
        // paymentInfoGridPane.setGridLinesVisible(true);

        itemsList = new Text("Cart Items");
        itemsList.setFont(Font.font("Arial",FontPosture.ITALIC,15));        
        cartText.setFont(Font.font("Arial",FontWeight.BOLD,25));
        cartItemsVBox.getChildren().add(cartText);
        cartItemsVBox.getChildren().add(itemsList);
        cartItemsVBox.setStyle("-fx-background-color: white;");
        couponCodeText.setTextAlignment(TextAlignment.LEFT);

        placeOrderVBox = new VBox();
        placeOrderVBox.setAlignment(Pos.TOP_RIGHT);
        placeOrderVBox.setSpacing(5);
        placeOrderVBox.getChildren().add(totalText);
        placeOrderVBox.getChildren().add(editCartButton);
        placeOrderVBox.getChildren().add(cancelOrderButton);
        placeOrderVBox.getChildren().add(couponCodeText);
        placeOrderVBox.getChildren().add(couponCodeTextField);
        placeOrderVBox.getChildren().add(placeOrderButton);
        
        


        separationGrid = new GridPane();
        super.columns.clear();
        super.rows.clear();
        ColumnConstraints column1 = new ColumnConstraints();
		ColumnConstraints column2 = new ColumnConstraints();

        column1.setPercentWidth(50.0);
		column2.setPercentWidth(50.0);
        
        columns.add(column1);
		columns.add(column2);

        RowConstraints row1 = new RowConstraints();
		RowConstraints row2 = new RowConstraints();

        row1.setPercentHeight(55.0);
		row2.setPercentHeight(45.0);

        rows.add(row1);
		rows.add(row2);  
        
        separationGrid.getRowConstraints().addAll(rows);
        separationGrid.getColumnConstraints().addAll(columns);

        separationGrid.add(checkOutGridPane, 0, 0);
        separationGrid.add(paymentInfoGridPane , 0,1);
        separationGrid.add(cartItemsVBox, 1, 0);
        separationGrid.add(placeOrderVBox, 1, 1);

      
        separationGrid.setVgap(5);
        separationGrid.setHgap(5);
        // separationGrid.setGridLinesVisible(true);

        // this.mainView.setGridLinesVisible(true);
        this.mainView.setVgap(10);
        this.mainView.setHgap(10);
        this.mainView.add(separationGrid,0,1);
        this.mainView.setAlignment(Pos.CENTER);
        // this.mainView.add(paymentInfoGridPane, 0, 2);
         


    }
    public void addAllItemsToCart()
    {

    }
    public void removeAllItems()
    {
        
    }

}
