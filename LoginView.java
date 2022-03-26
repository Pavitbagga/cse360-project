// Coded by Katelyn Vanderwolde
// Last Modified 3/23/22
// LoginView is page for users to sign into their account their username and password
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBoz;
import javafx.scene.text.Text;


public class LoginView {

	Text userNameText;
	Text passwordText;
	Text errorText;
	TextField userNameTextField;
	TextField passwordTextField;
	
	Button loginButton;
	
	VBox wholeView;
	//VBox buttonsVBox; // logout, go to menu, go to profile, etc
	ImageView topLogoView;

	HBox topHBox;
	HBox middleHBox;
	HBox bottomHBox;
	
	
	
	public LoginView(int xSize, int ySize, ButtonList<Button> topButtons, String newPageTitle, String newLogo, Image newLogo) {
		super(xSize, ySize, topButtons, newLogo); 
		
		// Whole Login Page
		wholeView = new VBox();
		
		
		// Initialize Logo Image 
		topLogoView = new ImageView();

		
		//newPageTitle = new String("Please login with your username and password");
		
		// Initialize Texts and Textfields
		userNameText = new Text();
		passwordText = new Text();
		errorText = new Text();
		userNameTextField = new Textfield();
		passwordTextField = new Textfield();
		
		// Initialize Login Button
		loginButton = new Button("Login");
		
		//Initialize HBoxes
		topHBox = new HBox();
		middleHBox = new HBox();
		bottomHBox = new HBox();
		
		// Set texts
		userNameText.setText("User Name");
		passwordText.setText("Password");
		
		// Get username and password input
		userNameTextField.getText();
		passwordTextField.getText();
		
		topLogoView.setImage(newLogo);
		

		// Add functionalities to certain HBoxes and VBoxes
		topHBox.getChildren.addAll(topLogoView); //might addVButtons
		middleHBox.getChildren.addAll(userNameText, userNameTextField, passwordText, passwordTextField);
		bottomHBox.getChildren.addAll(loginButton, errorText);
		
		wholeView.getChildren().addAll(topHBox, middleHBox, bottomHBox);
		
		this.mainView.add(wholeView, 0, 1);
		
	}
	
}
