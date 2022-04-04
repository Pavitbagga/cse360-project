

import java.util.ArrayList;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
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
    TextField firstNameTextField;
    TextField lastNameTextField;
    TextField emailTextField;
    TextField phoneNumTextField;
    TextField addressLine1TextField;
	TextField addressLine2TextField;
	TextField zipCodeTextField;
	TextField aptNumPoBoxTextField;
	TextField cityTextField;
	TextField stateTextField;
    TextField cardNumTextField;
    TextField cardExpDateTextField;
    TextField secCodeTextField;
    TextField couponCodeTextField;
    // Text registeredUsersOnlyText;
    Text firstNameText;
    Text lastNameText;
    Text emailText;
    Text phoneNumText;
    Text cardNumText;
    Text cardExpDateText;
    Text secCodeText;
    Text zipCodeText;
    Text addressLine1Text;
	Text addressLine2Text;
	Text aptNumPOBoxText;
	Text cityText;
	Text stateText;
    Text couponCodeText;
    HBox buttonBox;
    GridPane separationGrid;
    // CheckBox check;
    Text useSaveCardInfoText;
    Text itemsList;
    Text totalText;
    Button placeOrderButton;
    VBox placeOrderVBox;
    HBox couponTextHBox;

    int thisXSize;
    int thisYSize;

    Order item;

    ScrollPane itemScroll;
    public CheckoutView(int xSize,int ySize,ArrayList<Button> topButtons, String newPageTitle, Image newLogo, Order newOrder, String newPWD)
    {
        super(xSize, ySize, topButtons, newPageTitle, newLogo, newPWD);

        item = newOrder;

        thisXSize = xSize;
        thisYSize = ySize; 

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

        firstNameTextField = new TextField();
        lastNameTextField = new TextField();
        emailTextField = new TextField();
        phoneNumTextField = new TextField();

        // registeredUsersOnlyText = new Text("For Registered Users only: ");
        useSaveCardInfoText = new Text("Use saved card info");
        firstNameText = new Text("First Name: ");
        lastNameText = new Text("Last Name: ");
        emailText = new Text("Email: ");
        phoneNumText = new Text("Phone Number: ");
        addressLine1Text = new Text("Address Line 1: ");
		addressLine2Text = new Text("Address Line 2: ");
		zipCodeText = new Text("ZipCode: ");
		aptNumPOBoxText = new Text("Apt PO Box Number: ");
		cityText = new Text("City: ");
		stateText = new Text("State: ");
        cardNumText = new Text("Card Number: ");
        cardExpDateText = new Text("Expiration Date: ");
        secCodeText = new Text("Security Code: ");
        couponCodeText = new Text("Coupon Code ");


        cardNumTextField = new TextField();
        cardExpDateTextField = new TextField();
        secCodeTextField = new TextField();
        zipCodeTextField = new TextField();
        couponCodeTextField = new TextField();
        addressLine1TextField = new TextField();
		addressLine2TextField = new TextField();
		aptNumPoBoxTextField = new TextField();
		cityTextField = new TextField();
		stateTextField = new TextField();
        // couponCodeTextField.setMaxSize(200 , 200);
        // check = new CheckBox();
        totalText = new Text("Total: $");
        totalText.setFont(Font.font("Arial",FontWeight.SEMI_BOLD,20));

        checkOutGridPane.add(checkOutText, 0, 0);
        checkOutGridPane.add(logInButton, 0, 1);

        checkOutGridPane.add(firstNameText,0, 3);
        checkOutGridPane.add(firstNameTextField, 1, 3);
        checkOutGridPane.add(lastNameText,0, 4);
        checkOutGridPane.add(lastNameTextField, 1, 4);
        checkOutGridPane.add(emailText, 0, 5);
        checkOutGridPane.add(emailTextField,1, 5);
        checkOutGridPane.add(phoneNumText, 0, 6);
        checkOutGridPane.add(phoneNumTextField, 1, 6);
        checkOutGridPane.add(addressLine1Text, 0, 7);
        checkOutGridPane.add(addressLine1TextField, 1, 7);
        checkOutGridPane.add(addressLine2Text, 0, 8);
        checkOutGridPane.add(addressLine2TextField, 1, 8);
        checkOutGridPane.add(zipCodeText, 0, 9);
        checkOutGridPane.add(zipCodeTextField, 1, 9);
        checkOutGridPane.add(aptNumPOBoxText, 0, 10);
        checkOutGridPane.add(aptNumPoBoxTextField, 1, 10);
        checkOutGridPane.add(cityText, 0, 11);
        checkOutGridPane.add(cityTextField, 1, 11);
        checkOutGridPane.add(stateText, 0, 12);
        checkOutGridPane.add(stateTextField, 1, 12);         
        checkOutGridPane.setAlignment(Pos.TOP_LEFT);
        // checkOutGridPane.setGridLinesVisible(true);

        paymentInfoGridPane.add(paymentInfoText, 0, 0);
        // paymentInfoGridPane.add(registeredUsersOnlyText, 0, 1);
        paymentInfoGridPane.add(cardNumText, 0, 4);
        paymentInfoGridPane.add(cardNumTextField, 1, 4);
        paymentInfoGridPane.add(cardExpDateText, 0, 5);
        paymentInfoGridPane.add(cardExpDateTextField, 1, 5);
        paymentInfoGridPane.add(secCodeText, 0, 6);
        paymentInfoGridPane.add(secCodeTextField, 1, 6);
        paymentInfoGridPane.add(useSaveCardInfoText, 1, 2);
        // paymentInfoGridPane.setHalignment(check, HPos.RIGHT);
        // paymentInfoGridPane.add(check, 0, 2);
        // check.setAlignment(Pos.CENTER_RIGHT);
        paymentInfoGridPane.setAlignment(Pos.TOP_LEFT);
        // paymentInfoGridPane.setGridLinesVisible(true);

        itemsList = new Text("Cart Items");
        itemsList.setFont(Font.font("Arial",FontPosture.ITALIC,15));        
        cartText.setFont(Font.font("Arial",FontWeight.BOLD,25));
        cartItemsVBox.getChildren().add(cartText);
        cartItemsVBox.getChildren().add(itemsList);
        cartItemsVBox.setStyle("-fx-background-color: white;");
        couponCodeText.setTextAlignment(TextAlignment.LEFT);

        couponTextHBox = new HBox();
        couponTextHBox.getChildren().add(couponCodeText);
        couponTextHBox.getChildren().add(couponCodeTextField);
        couponTextHBox.setSpacing(5);
        couponTextHBox.setAlignment(Pos.BASELINE_LEFT);

        placeOrderVBox = new VBox();
        placeOrderVBox.setAlignment(Pos.TOP_LEFT);
        placeOrderVBox.setSpacing(5);
        placeOrderVBox.getChildren().add(totalText);
        placeOrderVBox.getChildren().add(editCartButton);
        placeOrderVBox.getChildren().add(cancelOrderButton);
        placeOrderVBox.getChildren().add(couponTextHBox);
        placeOrderVBox.getChildren().add(placeOrderButton);

        itemScroll = new ScrollPane();
        itemScroll.setContent(cartItemsVBox);
        
        


        separationGrid = new GridPane();
        super.columns.clear();
        super.rows.clear();
        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column15 = new ColumnConstraints();
		ColumnConstraints column2 = new ColumnConstraints();

        column1.setPercentWidth(40.0);
        column15.setPercentWidth(10.0);
		column2.setPercentWidth(50.0);
        
        columns.add(column1);
        columns.add(column15);
		columns.add(column2);

        RowConstraints row1 = new RowConstraints();
		RowConstraints row2 = new RowConstraints();

        row1.setPercentHeight(70.0);
		row2.setPercentHeight(30.0);

        rows.add(row1);
		rows.add(row2);  
        
        separationGrid.getRowConstraints().addAll(rows);
        separationGrid.getColumnConstraints().addAll(columns);

        separationGrid.add(checkOutGridPane, 0, 0, 1, 1);
        separationGrid.add(paymentInfoGridPane , 0 ,1, 1, 1);
        separationGrid.add(itemScroll, 1, 0, 2, 1);
        separationGrid.add(placeOrderVBox, 2, 1);

      
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
    public void addAllItemsToCart(Order newOrder, User curUser)
    {
        for(int i = 0; i < newOrder.getOrderContents().size(); i++){
            CheckoutCartItemView temp = new CheckoutCartItemView(newOrder.getOrderContents().get(i), thisXSize, thisYSize);
            cartItemsVBox.getChildren().add(temp);
        }
        if(curUser.getUserId() > -1){
            Customer temp = (Customer)curUser;
            firstNameTextField.setText(temp.getFirstName());
            lastNameTextField.setText(temp.getLastName());
            emailTextField.setText(temp.getEmail());
            phoneNumTextField.setText(temp.getPhoneNum());
            addressLine1TextField.setText(temp.getAddress().getStreetAddressLine1());
            addressLine2TextField.setText(temp.getAddress().getStreetAddressLine2());
            zipCodeTextField.setText(temp.getAddress().getZipcode());
            aptNumPoBoxTextField.setText(temp.getAddress().getApptNumPOBox());
            cityTextField.setText(temp.getAddress().getCity());
            stateTextField.setText(temp.getAddress().getState());
            cardExpDateTextField.setText(temp.getPaymentInfo().getExpiration());
            cardNumTextField.setText(temp.getPaymentInfo().getCardNum());
            secCodeTextField.setText(temp.getPaymentInfo().getSecurityCode());

            firstNameTextField.setEditable(false);
            lastNameTextField.setEditable(false);
            emailTextField.setEditable(false);
            phoneNumTextField.setEditable(false);
            addressLine1TextField.setEditable(false);
	        addressLine2TextField.setEditable(false);
	        zipCodeTextField.setEditable(false);
	        aptNumPoBoxTextField.setEditable(false);
	        cityTextField.setEditable(false);
	        stateTextField.setEditable(false);
            cardNumTextField.setEditable(false);
            cardExpDateTextField.setEditable(false);
            secCodeTextField.setEditable(false);
            couponCodeTextField.setEditable(false);
        }
    }
    public void removeAllItems()
    {
        cartItemsVBox.getChildren().clear();

        firstNameTextField.setEditable(true);
        lastNameTextField.setEditable(true);
        emailTextField.setEditable(true);
        phoneNumTextField.setEditable(true);
        addressLine1TextField.setEditable(true);
	    addressLine2TextField.setEditable(true);
	    zipCodeTextField.setEditable(true);
	    aptNumPoBoxTextField.setEditable(true);
	    cityTextField.setEditable(true);
	    stateTextField.setEditable(true);
        cardNumTextField.setEditable(true);
        cardExpDateTextField.setEditable(true);
        secCodeTextField.setEditable(true);
        couponCodeTextField.setEditable(true);

        firstNameTextField.setText("");
        lastNameTextField.setText("");
        emailTextField.setText("");
        phoneNumTextField.setText("");
        addressLine1TextField.setText("");
        addressLine2TextField.setText("");
        zipCodeTextField.setText("");
        aptNumPoBoxTextField.setText("");
        cityTextField.setText("");
        stateTextField.setText("");
        cardExpDateTextField.setText("");
        cardNumTextField.setText("");
        secCodeTextField.setText("");
    }

}
