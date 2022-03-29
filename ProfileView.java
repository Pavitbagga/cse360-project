// Coded by Katelyn Vanderwolde
// Last Modified 3/23/22
// ProfileView shows user their account information, such as name, location, contact, and payment.
// Also, it allows them to edit that information.
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBoz;
import javafx.scene.text.Text;


public class ProfileView extends BaseModel{

	Text titleText;
	Text firstNameText;
	Text lastNameText;
	Text emailText;
	Text phoneNumberText;
	Text paymentInfoText;
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

	Button saveButton;
	Button editButton;
	
	VBox wholeView;

	
	VBox leftMiddleVBox;
	VBox rightMiddleVBox;
	
	VBox leftBottomVBox;
	VBox rightBottomVBox;
	
	HBox topHBox;
	HBox middleHBox;
	HBox bottomHBox;
	
	ScrollPane profile;
	

	public ProfileView(int xSize, int ySize, ButtonList<Button> topButtons, String newPageTitle, Image newLogo) {
		super(xSize, ySize, topButtons, newPageTitle, newLogo);  
		
		// Whole Login Page
		wholeView = new VBox();
		
		
		// Initialize Logo Image 
		topLogoView = new ImageView();
		
		profile = new ScrollPane();
		
		
		
		leftMiddleVBox = new VBox();
		rightMiddleVBox = new VBox();
		
		leftBottomVBox = new VBox();
		rightBottomVBox = new VBox();
		
		// Initialize HBoxes
		topHBox = new HBox();
		middleHBox = new HBox();
		bottomHBox = new HBox();
		
		
		
		// Initialized Text 
		titleText = new Text();
		firstNameText = new Text();
		lastNameText = new Text();
		
		emailText = new Text();
		phoneNumberText = new Text();
		

		addressLine1Text = new Text();
		addressLine2Text = new Text();
		zipCodeText = new Text();
		aptNumPOBoxText = new Text();
		cityText = new Text();
		stateText = new Text();
		
		cardNumText = new Text();
		cardExpDateText = new Text();
		securityNumText = new Text();

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
		saveButton = new Button("Save");
		editButton = new Button("Edit");

		
		// Labels
		leftMiddleVBox.getChildren.addAll(firstNameText, lastNameText, emailText, phoneNumberText, 
				addressLine1Text, addressLine2Text, zipCodeText, aptNumPOBoxText, cityText, stateText,
				cardNumText, cardExpDateText, securityNumText);
		//Inputs
		rightMiddleVBox.getChildren.addAll(firstNameTextField, lastNameTextField, emailTextField, phoneNumberTextField, 
				addressLine1TextField, addressLine2TextField, zipCodeTextField, aptNumPOBoxTextField, 
				cityTextField, stateTextField, cardNumTextField, cardExpDateTextField, securityNumTextField);
		
		// Bottom buttons
		leftBottomVBox.getChildren.addAll(editButton);
		rightBottomVBox.getChildren.addAll(saveButton);
		
		// Add VBoxes to HBoxes
		middleHBox.getChildren.addAll(leftMiddleVBox, rightMiddleVBox);
		bottomHBox.getChildren.addAll(leftBottomVBox, rightBottomVBox);
		
		// Add HBoxes to the whole Profile page
		wholeView.getChildren().addAll(topHBox, middleHBox, bottomHBox);
		
		// Add input to ScrollPane
		profile.setContent(rightMiddleVBox);
		
		this.mainView.add(wholeView, 0, 1);
		

	}
	
	public void addAllFieldsToProfile(User newUser) {
		profile.setContent(rightMiddleVBox);
	}
	
	public void removeAllFromProfile() {
		rightMiddleVBox.getChildren().clear(); //unsure ?
		profile.setContent(rightMiddleVBox);
		
	}


}

