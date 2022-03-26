// Coded by Katelyn Vanderwolde
// Last Modified 3/23/22
// LoginView is page for users to sign into their account their username and password

public class LoginView {

	Text userNameText;
	Text passwordText;
	Text errorText;
	TextField userNameTextField;
	TextField passwordTextField;
	
	Button loginButton;
	
	VBox wholeView;
	VBox buttonsVBox; // logout, go to menu, go to profile, etc
	ImageView topLogoView;

	HBox topHBox;
	HBox middleHBox;
	HBox bottomHBox;
	
	
	public LoginView(int xSize, int ySize, ButtonList<Button> topButtons, String newPageTitle, String newLogo, Image newLogo) {
		super(new GridPane(), xSize, ySize, Color.web("FFFFFF")); 
		
		// Whole Login Page
		wholeView = (VBox)super.getRoot();
		
		// Initialize VBox
		buttonsVBox = new VBox();
		
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
		loginButton = new Button();
		
		//Initialize HBoxes
		topHBox = new HBox();
		middleHBox = new HBox();
		bottomHBox = new HBox();
		
		// Get username and password input
		userNameText.getText();
		passwordText.getText();
		

		
		// buttonsVBox is logout, go to menu, go to profile, etc
		for(Buttons b : topButtons) {
			 buttonsVBox.getChildren().add(b);
		}
		 
		topLogoView.setImage(newLogo);
		
		// Add functionalities to certain HBoxes and VBoxes
		topHBox.getChildren.addAll(topLogoView, buttonsVBox); 
		middleHBox.getChildren.addAll(userNameText, userNameTextField, passwordText, passwordTextField);
		bottomHBox.getChildren.addAll(loginButton, errorText);
		
		wholeView.getChildren().addAll(topHBox, middleHBox, bottomHBox);
		
		
		
	}
	
}
