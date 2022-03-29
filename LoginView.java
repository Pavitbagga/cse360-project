// Coded by Katelyn Vanderwolde
// Last Modified 3/28/22
// LoginView is page for users to sign into their account their username and password
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.util.ArrayList;


public class LoginView extends BaseModel{

	Text instructionsText;
	Text userNameText;
	Text passwordText;
	Text errorText;
	TextField userNameTextField;
	TextField passwordTextField;
	
	Button loginButton;
	
	VBox wholeView;

	VBox topVBox;
	VBox middleVBox;
	VBox bottomVBox;
	
	HBox mainHBox1;
	HBox mainHBox2;
	HBox mainHBox3;

	public LoginView(int xSize, int ySize, ArrayList<Button> topButtons, String newPageTitle, Image newLogo) {
		super(xSize, ySize, topButtons, newPageTitle, newLogo); 
		
		// Whole Login Page
		wholeView = new VBox();


		
		//newPageTitle = new String("Please login with your username and password");
		
		// Initialize Texts and Textfields
		instructionsText = new Text("Please login with your user name and password :)");
		userNameText = new Text("User Name:");
		passwordText = new Text("Password:");
		errorText = new Text();
		userNameTextField = new TextField();
		passwordTextField = new TextField();
		
		// Initialize Login Button
		loginButton = new Button("Login");
		
		//Initialize VBoxes and HBoxes
		topVBox = new VBox();
		middleVBox = new VBox(10);
		bottomVBox = new VBox();

		mainHBox1 = new HBox();
		mainHBox2 = new HBox();
		mainHBox3 = new HBox();

		
		// Get username and password input
		userNameTextField.getText();
		passwordTextField.getText();

		

		// Add functionalities to certain HBoxes and VBoxes
		topVBox.getChildren().addAll(instructionsText);
		topVBox.setAlignment(Pos.CENTER);
		middleVBox.getChildren().addAll(userNameText, userNameTextField, passwordText, passwordTextField);
		middleVBox.setAlignment(Pos.CENTER);
		bottomVBox.getChildren().addAll(loginButton, errorText);
		bottomVBox.setAlignment(Pos.CENTER);

		mainHBox1.getChildren().addAll(topVBox);
		mainHBox1.setAlignment(Pos.BASELINE_CENTER);
		mainHBox2.setPadding(new Insets(50, 0, 0, 0));
		mainHBox2.getChildren().addAll(middleVBox);
		mainHBox2.setAlignment(Pos.BASELINE_CENTER);
		mainHBox2.setPadding(new Insets(20, 0, 0, 0));
		mainHBox3.getChildren().addAll(bottomVBox);
		mainHBox3.setAlignment(Pos.BASELINE_CENTER);
		mainHBox3.setPadding(new Insets(30, 0, 0, 0));

		wholeView.getChildren().addAll(mainHBox1, mainHBox2, mainHBox3);
		
		this.mainView.add(wholeView, 0, 1);
		
	}
	
}
