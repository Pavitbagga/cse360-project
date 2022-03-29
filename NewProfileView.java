// Coded by Katelyn Vanderwolde
// Last Modified 3/28/22
// NewProfile allows user to create account with certain information,
// such as name, location, contact, and payment.

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;


public class NewProfileView extends BaseModel{

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



		leftMiddleVBox = new VBox(14.4);
		rightMiddleVBox = new VBox(5);

		//leftBottomVBox = new VBox();
		rightBottomVBox = new VBox();

		// Initialize HBoxes
		topHBox = new HBox();
		middleHBox = new HBox();
		bottomHBox = new HBox();



		// Initialized Text
		firstNameText = new Text("First Name: ");
		firstNameText.setFont(new Font(18));
		lastNameText = new Text("Last Name: ");
		lastNameText.setFont(new Font(18));

		emailText = new Text("Email ID: ");
		emailText.setFont(new Font(18));
		phoneNumberText = new Text("Phone Number: ");
		phoneNumberText.setFont(new Font(18));


		addressLine1Text = new Text("Primary Address: ");
		addressLine1Text.setFont(new Font(18));
		addressLine2Text = new Text("Secondary Address: ");
		addressLine2Text.setFont(new Font(18));
		zipCodeText = new Text("ZipCode: ");
		zipCodeText.setFont(new Font(18));
		aptNumPOBoxText = new Text("Apt PO Box Number: ");
		aptNumPOBoxText.setFont(new Font(18));
		cityText = new Text("City: ");
		cityText.setFont(new Font(18));
		stateText = new Text("State: ");
		stateText.setFont(new Font(18));

		cardNumText = new Text("Card Number: ");
		cardNumText.setFont(new Font(18));
		cardExpDateText = new Text("Card Expiration Date: ");
		cardExpDateText.setFont(new Font(18));
		securityNumText = new Text("Security Number (CCV): ");
		securityNumText.setFont(new Font(18));

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
		createAccountButton = new Button("Create Account");


		// Labels
		leftMiddleVBox.getChildren().addAll(firstNameText, lastNameText, emailText, phoneNumberText,
				addressLine1Text, addressLine2Text, zipCodeText, aptNumPOBoxText, cityText, stateText,
				cardNumText, cardExpDateText, securityNumText);
		//Inputs
		rightMiddleVBox.getChildren().addAll(firstNameTextField, lastNameTextField, emailTextField, phoneNumberTextField,
				addressLine1TextField, addressLine2TextField, zipCodeTextField, aptNumPoBoxTextField,
				cityTextField, stateTextField, cardNumTextField, cardExpDateTextField, securityNumTextField);
		rightMiddleVBox.setSpacing(13);
		rightMiddleVBox.setPadding(new Insets(14, 0, 0, 200 ));

		// Bottom button
		rightBottomVBox.getChildren().addAll(createAccountButton);
		rightBottomVBox.setPadding(new Insets(10,0,10,300));

		// Add VBoxes to HBoxes
		middleHBox.getChildren().addAll(leftMiddleVBox, rightMiddleVBox);
		middleHBox.setAlignment(Pos.BASELINE_CENTER);
		bottomHBox.getChildren().addAll(rightBottomVBox);
		bottomHBox.setAlignment(Pos.BASELINE_RIGHT);

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