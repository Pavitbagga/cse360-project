// Coded by Katelyn Vanderwolde
// Last Modified 3/28/22
// NewProfile allows user to create account with certain information,
// such as name, location, contact, and payment.



import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.image.Image;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;

import java.util.ArrayList;




public class NewProfileView extends BaseModel{

	Text firstNameText;
	Text lastNameText;
	Text userNameText;
	Text passwordText;
	Text emailText;
	Text phoneNumberText;
	Text addressLine1Text;
	Text addressLine2Text;
	Text zipCodeText;
	Text aptNumPOBoxText;
	Text cityText;
	Text stateText;
	Text cardNumText;
	Text cardExpDateText;
	Text securityNumText;
	Text errorMessage;

	TextField firstNameTextField;
	TextField lastNameTextField;
	TextField userNameTextField;
	TextField passwordTextField;
	TextField emailTextField;
	TextField phoneNumberTextField;
	TextField addressLine1TextField;
	TextField addressLine2TextField;
	TextField zipCodeTextField;
	TextField aptNumPoBoxTextField;
	TextField cityTextField;
	TextField stateTextField;
	TextField cardNumTextField;
	TextField cardExpDateTextField;
	TextField securityNumTextField;

	ColumnConstraints c1;
	ColumnConstraints c2;

	RowConstraints r1;
	RowConstraints r2;
	RowConstraints r3;
	RowConstraints r4;
	RowConstraints r5;
	RowConstraints r6;
	RowConstraints r7;
	RowConstraints r8;
	RowConstraints r9;
	RowConstraints r10;
	RowConstraints r11;
	RowConstraints r12;
	RowConstraints r13;
	RowConstraints r14;
	RowConstraints r15;
	RowConstraints r16;
	RowConstraints r17;


	Button createAccountButton;
	HBox buttonHBox;
	int selectedButton;

	GridPane grid;

	Button restaurantRadio;
	Button customerRadio;



	public NewProfileView(int xSize, int ySize, ArrayList<Button> topButtons, String newPageTitle, Image newLogo, String newPWD) {
		super(xSize, ySize, topButtons, newPageTitle, newLogo, newPWD);


		grid = new GridPane();

		buttonHBox = new HBox(ySize * 0.15);

		// Initialized Text


		firstNameText = new Text("First Name: ");
		lastNameText = new Text("Last Name: ");

		userNameText = new Text("Username: ");
		passwordText = new Text("Password: ");

		emailText = new Text("Email ID: ");
		phoneNumberText = new Text("Phone Number: ");


		addressLine1Text = new Text("Primary Address: ");
		addressLine2Text = new Text("Secondary Address: ");
		zipCodeText = new Text("ZipCode: ");
		aptNumPOBoxText = new Text("Apt PO Box Number: ");
		cityText = new Text("City: ");
		stateText = new Text("State: ");

		cardNumText = new Text("Card Number: ");
		cardExpDateText = new Text("Card Expiration Date: ");
		securityNumText = new Text("Security Number (CCV): ");

		errorMessage = new Text("");

		// Initialized TextFields
		firstNameTextField = new TextField();
		lastNameTextField = new TextField();

		userNameTextField = new TextField();
		passwordTextField = new TextField();


		emailTextField = new TextField();
		phoneNumberTextField = new TextField();


		addressLine1TextField = new TextField();
		addressLine2TextField = new TextField();
		zipCodeTextField = new TextField();
		aptNumPoBoxTextField = new TextField();
		cityTextField = new TextField();
		stateTextField = new TextField();
		cardNumTextField = new TextField();
		cardExpDateTextField = new TextField();
		securityNumTextField = new TextField();


		// Columns and rows
		c1 = new ColumnConstraints();
		c2 = new ColumnConstraints();
		c1.setPercentWidth(30.0);
		c2.setPercentWidth(60.0);

		r1 = new RowConstraints();
		r2 = new RowConstraints();
		r3 = new RowConstraints();
		r4 = new RowConstraints();
		r5 = new RowConstraints();
		r6 = new RowConstraints();
		r7 = new RowConstraints();
		r8 = new RowConstraints();
		r9 = new RowConstraints();
		r10 = new RowConstraints();
		r11 = new RowConstraints();
		r12 = new RowConstraints();
		r13 = new RowConstraints();
		r14 = new RowConstraints();
		r15 = new RowConstraints();
		r16 = new RowConstraints();
		r17 = new RowConstraints();


		r1.setPercentHeight(5.7);
		r2.setPercentHeight(5.7);
		r3.setPercentHeight(5.7);
		r4.setPercentHeight(5.7);
		r5.setPercentHeight(5.7);
		r6.setPercentHeight(5.7);
		r7.setPercentHeight(5.7);
		r8.setPercentHeight(5.7);
		r9.setPercentHeight(5.7);
		r10.setPercentHeight(5.7);
		r11.setPercentHeight(5.7);
		r12.setPercentHeight(5.7);
		r13.setPercentHeight(5.7);
		r14.setPercentHeight(5.7);
		r15.setPercentHeight(5.7);
		r16.setPercentHeight(5.7);
		r17.setPercentHeight(5.7);



		grid.getColumnConstraints().add(c1);
		grid.getColumnConstraints().add(c2);

		grid.getRowConstraints().add(r1);
		grid.getRowConstraints().add(r2);
		grid.getRowConstraints().add(r3);
		grid.getRowConstraints().add(r4);
		grid.getRowConstraints().add(r4);
		grid.getRowConstraints().add(r5);
		grid.getRowConstraints().add(r6);
		grid.getRowConstraints().add(r7);
		grid.getRowConstraints().add(r8);
		grid.getRowConstraints().add(r9);
		grid.getRowConstraints().add(r10);
		grid.getRowConstraints().add(r11);
		grid.getRowConstraints().add(r12);
		grid.getRowConstraints().add(r13);
		grid.getRowConstraints().add(r14);
		grid.getRowConstraints().add(r15);
		grid.getRowConstraints().add(r16);
		grid.getRowConstraints().add(r17);


		// Initialized Buttons
		createAccountButton = new Button("CREATE ACCOUNT");
		restaurantRadio = new Button("Restaurant User");
		customerRadio = new Button("Customer");
		selectedButton = 0;
		customerRadio.setStyle("-fx-background-color: #00FF00");


		buttonHBox.getChildren().add(customerRadio);
		buttonHBox.getChildren().add(restaurantRadio);

		grid.add(errorMessage, 0, 0);
		grid.add(firstNameText, 0, 1);
		grid.add(lastNameText, 0, 2);
		grid.add(userNameText, 0, 3);
		grid.add(passwordText, 0, 4);
		grid.add(emailText, 0, 5);
		grid.add(phoneNumberText, 0, 6);
		grid.add(addressLine1Text, 0, 7);
		grid.add(addressLine2Text, 0, 8);
		grid.add(zipCodeText, 0, 9);
		grid.add(aptNumPOBoxText, 0, 10);
		grid.add(cityText, 0, 11);
		grid.add(stateText, 0, 12);
		grid.add(cardNumText, 0, 13);
		grid.add(cardExpDateText, 0, 14);
		grid.add(securityNumText, 0, 15);

		grid.add(buttonHBox, 1, 0);
		grid.add(firstNameTextField, 1, 1);
		grid.add(lastNameTextField, 1, 2);
		grid.add(userNameTextField, 1, 3);
		grid.add(passwordTextField, 1, 4);
		grid.add(emailTextField, 1, 5);
		grid.add(phoneNumberTextField, 1, 6);
		grid.add(addressLine1TextField, 1, 7);
		grid.add(addressLine2TextField, 1, 8);
		grid.add(zipCodeTextField, 1, 9);
		grid.add(aptNumPoBoxTextField, 1, 10);
		grid.add(cityTextField, 1, 11);
		grid.add(stateTextField, 1, 12);
		grid.add(cardNumTextField, 1, 13);
		grid.add(cardExpDateTextField, 1, 14);
		grid.add(securityNumTextField, 1, 15);
		grid.add(createAccountButton, 1, 16);

		this.mainView.add(grid, 0, 1);


	}


	public void removeAllFromNewProfile() {
		errorMessage.setText("");
		for(int i = 17; i < grid.getChildren().size() - 1; i++){
			((TextField)grid.getChildren().get(i)).setText("");
			((TextField)grid.getChildren().get(i)).setEditable(true);
		}

	}


}
