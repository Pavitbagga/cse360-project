// Coded by Katelyn Vanderwolde
// Last Modified 3/28/22
// NewProfile allows user to create account with certain information,
// such as name, location, contact, and payment.

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.util.ArrayList;


public class NewProfileView extends BaseModel{

	Text titleText;
	Text firstNameText;
	Text lastNameText;
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

	TextField firstNameTextField;
	TextField lastNameTextField;
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

	Button createAccountButton;

	VBox wholeView;

	VBox leftMiddleVBox;
	VBox rightMiddleVBox;
	VBox rightBottomVBox;

	HBox topHBox;
	HBox middleHBox;
	HBox bottomHBox;

	ScrollPane profile;


	public NewProfileView(int xSize, int ySize, ArrayList<Button> topButtons, String newPageTitle, Image newLogo) {
		super(xSize, ySize, topButtons, newPageTitle, newLogo);

		// Whole Login Page
		wholeView = new VBox();


		profile = new ScrollPane();



		leftMiddleVBox = new VBox();
		rightMiddleVBox = new VBox();

		//leftBottomVBox = new VBox();
		rightBottomVBox = new VBox();

		// Initialize HBoxes
		topHBox = new HBox();
		middleHBox = new HBox();
		bottomHBox = new HBox();



		// Initialized Text
		firstNameText = new Text("First Name: ");
		lastNameText = new Text("Last Name: ");

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

		// Initialized TextFields
		firstNameTextField = new TextField();
		lastNameTextField = new TextField();

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


		// Initialized Buttons
		createAccountButton = new Button("CREATE ACCOUNT");


		// Labels
		leftMiddleVBox.getChildren().addAll(firstNameText, lastNameText, emailText, phoneNumberText,
				addressLine1Text, addressLine2Text, zipCodeText, aptNumPOBoxText, cityText, stateText,
				cardNumText, cardExpDateText, securityNumText);
		//Inputs
		rightMiddleVBox.getChildren().addAll(firstNameTextField, lastNameTextField, emailTextField, phoneNumberTextField,
				addressLine1TextField, addressLine2TextField, zipCodeTextField, aptNumPoBoxTextField,
				cityTextField, stateTextField, cardNumTextField, cardExpDateTextField, securityNumTextField);

		// Bottom button
		rightBottomVBox.getChildren().addAll(createAccountButton);

		// Add VBoxes to HBoxes
		middleHBox.getChildren().addAll(leftMiddleVBox, rightMiddleVBox);
		bottomHBox.getChildren().addAll(rightBottomVBox);

		// Add HBoxes to the whole Profile page
		wholeView.getChildren().addAll(middleHBox, bottomHBox);

		// Add input to ScrollPane
		profile.setContent(rightMiddleVBox);

		this.mainView.add(wholeView, 0, 1);


	}

	public void addAllFieldsToProfile(User newUser) {
		profile.setContent(rightMiddleVBox);
	}

	public void removeAllFromNewProfile() {
		rightMiddleVBox.getChildren().clear(); //unsure ?
		profile.setContent(rightMiddleVBox);

	}


}
