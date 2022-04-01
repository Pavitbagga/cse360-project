package org.openjfx;



import javafx.event.EventHandler;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import javafx.scene.input.MouseEvent;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * This is a basic skeleton to test running classes for now, will alter to make final project properly
 */
public class App extends Application{

    int currentUserIDToAssign;
    int currentUserLoggedIn;
    ArrayList<User> userList;
    ArrayList<Order> orders;
    ArrayList<MenuItem> menuList;
    Image topLogo;

    HomeView homeView;
    MenuView menuView;
    LoginView loginView;
    NewProfileView newProfileView;
    CartView cartView;
    // CheckOutView checkOutView;
    ProfileView profileView;
    // WaitView waitView; 
    EditItemView editItemView;
    OrderView orderView;
    // CouponView couponView;

    ArrayList<MenuItemMiniView> menuItemMiniViewList;

    
    
    Stage stage;
    
    // Home Page Buttons
    Button loginButton1;
    Button createAccountButton1;
    
    // MenuView Buttons
    Button checkOut2;
    Button cart2;
    Button profile2;
    Button logout2;

    // MenuItemView Buttons
    // Button cart3;
    Button menu3;
    Button logout3;
    ArrayList<Button> buttonListMenuItem3;

    // LoginView Buttons
    Button logout4;

    // NewProfileView Buttons
    Button logout5;
    
    // CartView Buttons
    Button menu6;
    Button profile6;
    Button logout6;

    // CheckOutView Buttons
    // Button menu7;
    // Button profile7;
    // Button logout7;

    // ProfileView Buttons
    Button logout8;
    Button menu8;
    
    // WaitView Buttons
    // Button logout9;
    // Button menu9;
    // Button profile9;

    // EditItemView Buttons
    Button logout10;
    Button orders10;
    Button profile10;

    // OrderView Buttons
    Button profile11;
    Button createItem11;
    Button createCoupon11;
    Button logout11;

    // CouponView
    // Button profile12;
    // Button orders12;
    // Button logout12;
    

    

    EventHandler<MouseEvent> loginButtonHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            loginView.removeAllFieldsFromLogin();
            loginView.instructionsText.setText("Please login with your user name and password :)");
            stage.setScene(loginView);
            stage.show();
        }
    };
    EventHandler<MouseEvent> createAccountButtonHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            setCustomerButton();
            newProfileView.removeAllFromNewProfile();
            stage.setScene(newProfileView);
            stage.show();
        }
    };
    EventHandler<MouseEvent> logoutHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            currentUserLoggedIn = -1;
            stage.setScene(homeView);
            stage.show();
        }
    };

    EventHandler<MouseEvent> menuHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            System.out.println("Menu was selected");
        }
    };

    EventHandler<MouseEvent> printUsersHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            for(int i = 0; i < userList.size(); i++){
                if(userList.get(i).getClass() == Customer.class){
                    System.out.println("Customer : Name: " + userList.get(i).getFirstName() + " UserID: " + userList.get(i).getUserId());
                }
                if(userList.get(i).getClass() == Restaurant.class){
                    System.out.println("Restaurant : Name: " + userList.get(i).getFirstName() + "UserID: " + userList.get(i).getUserId());
                }
               
            }
        }
    };

    EventHandler<MouseEvent> createAccountHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            newProfileView.errorMessage.setText("");
            if(newProfileView.selectedButton == 0){
                if(findEmail(newProfileView.emailTextField.getText())  == -1){
                    if(findUserName(newProfileView.userNameTextField.getText()) == -1){
                        Customer tempCustomer = new Customer(newProfileView.firstNameTextField.getText(), newProfileView.lastNameTextField.getText(),
                        newProfileView.userNameTextField.getText(), newProfileView.passwordTextField.getText(), currentUserIDToAssign,
                        newProfileView.emailTextField.getText(), 
                        newProfileView.phoneNumberTextField.getText());
                        Address tempAddress = new Address(newProfileView.addressLine1TextField.getText(), newProfileView.addressLine2TextField.getText(),
                            newProfileView.aptNumPoBoxTextField.getText(), newProfileView.zipCodeTextField.getText(),
                            newProfileView.cityTextField.getText(), newProfileView.stateTextField.getText());
                        tempCustomer.setAddress(tempAddress);
                        Payment tempPayment = new Payment(newProfileView.cardNumTextField.getText(), tempAddress, 
                            newProfileView.securityNumTextField.getText(), newProfileView.cardExpDateTextField.getText());
                        tempCustomer.setPaymentInfo(tempPayment);
                        currentUserIDToAssign++;
                        userList.add(tempCustomer);
                        loginView.removeAllFieldsFromLogin();
                        loginView.instructionsText.setText("Please login with your user name and password :)");
                        stage.setScene(loginView);
                        stage.show();
                    }
                    else{
                        newProfileView.errorMessage.setText("This username is already registered");
                    }
                    
                }
                else{
                    newProfileView.errorMessage.setText("This email is already registered");
                }
                
            }

            else if (newProfileView.selectedButton == 1){
                Restaurant tempRestaurant = new Restaurant(newProfileView.firstNameTextField.getText(), newProfileView.lastNameTextField.getText(),
                newProfileView.userNameTextField.getText(), newProfileView.passwordTextField.getText(), currentUserIDToAssign, 
                newProfileView.emailTextField.getText(), 0);
                currentUserIDToAssign++;
                userList.add(tempRestaurant);
                loginView.removeAllFieldsFromLogin();
                stage.setScene(loginView);
                stage.show();
            }

        }
    };

    EventHandler<MouseEvent> loginHandler = new EventHandler<MouseEvent>(){
        public void handle(MouseEvent e){
            String tempUserName = loginView.userNameTextField.getText();
            String tempPassword = loginView.passwordTextField.getText();
            int userIndex = findUserName(tempUserName);
            if(userIndex > -1){
                if(userList.get(userIndex).getPassword().equals(tempPassword)){
                    goToMenuView();
                    currentUserLoggedIn = userList.get(userIndex).getUserId();
                }
                else{
                    loginView.instructionsText.setText("Username or Password incorrect, please try again");
                }
            }
            else{
                loginView.instructionsText.setText("Username or Password incorrect, please try again");
            }
        }
    };

    EventHandler<MouseEvent> profileHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            profileView.removeAllFromProfile();
            profileView.addAllFieldsToProfile(userList.get(findUserId(currentUserLoggedIn)));
            stage.setScene(profileView);
            stage.show();
        }
    };

    EventHandler<MouseEvent> saveChangesToProfileHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            int index = findUserId(currentUserLoggedIn);
            userList.get(index).setFirstName(profileView.firstNameTextField.getText());
            userList.get(index).setLastName(profileView.lastNameTextField.getText());
            userList.get(index).setUserName(profileView.userNameTextField.getText());
            userList.get(index).setPassword(profileView.passwordTextField.getText());
            if(userList.get(index).getClass() == Customer.class){
                ((Customer)userList.get(index)).setEmail(profileView.emailTextField.getText());
                ((Customer)userList.get(index)).setPhoneNum(profileView.phoneNumberTextField.getText());
                Address tempAddress = new Address(profileView.addressLine1TextField.getText(), profileView.addressLine2TextField.getText(),
                    profileView.aptNumPoBoxTextField.getText(), profileView.zipCodeTextField.getText(),
                    profileView.cityTextField.getText(), profileView.stateTextField.getText());
                Payment tempPayment = new Payment(profileView.cardNumTextField.getText(), tempAddress, 
                    profileView.securityNumTextField.getText(), profileView.cardExpDateTextField.getText());
                    ((Customer)userList.get(index)).setAddress(tempAddress);
                    ((Customer)userList.get(index)).setPaymentInfo(tempPayment);
            }
            profileView.firstNameTextField.setEditable(false);
	        profileView.lastNameTextField.setEditable(false);
	        profileView.userNameTextField.setEditable(false);
	        profileView.passwordTextField.setEditable(false);
	        profileView.emailTextField.setEditable(false);
	        profileView.phoneNumberTextField.setEditable(false);
	        profileView.addressLine1TextField.setEditable(false);
	        profileView.addressLine2TextField.setEditable(false);
	        profileView.zipCodeTextField.setEditable(false);
	        profileView.aptNumPoBoxTextField.setEditable(false);
	        profileView.cityTextField.setEditable(false);
	        profileView.stateTextField.setEditable(false);
	        profileView.cardNumTextField.setEditable(false);
	        profileView.cardExpDateTextField.setEditable(false);
	        profileView.securityNumTextField.setEditable(false);

        }
    };

    EventHandler<MouseEvent> editProfileInfoHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            profileView.firstNameTextField.setEditable(true);
	        profileView.lastNameTextField.setEditable(true);
	        profileView.userNameTextField.setEditable(true);
	        profileView.passwordTextField.setEditable(true);
	        profileView.emailTextField.setEditable(true);
	        profileView.phoneNumberTextField.setEditable(true);
	        profileView.addressLine1TextField.setEditable(true);
	        profileView.addressLine2TextField.setEditable(true);
	        profileView.zipCodeTextField.setEditable(true);
	        profileView.aptNumPoBoxTextField.setEditable(true);
	        profileView.cityTextField.setEditable(true);
	        profileView.stateTextField.setEditable(true);
	        profileView.cardNumTextField.setEditable(true);
	        profileView.cardExpDateTextField.setEditable(true);
	        profileView.securityNumTextField.setEditable(true);

        }
    };

    EventHandler<MouseEvent> menuItemViewHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            System.out.println("This is correctly connected");
            try{
                InputStream in = new FileInputStream("/home/ejoerz/test/sample/src/main/java/org/openjfx/test.png");
                topLogo = new Image(in);

                MenuItemView temp = new MenuItemView(900, 700, buttonListMenuItem3, ((MenuItemMiniView)((Button) e.getSource()).getParent()).innerMenuItem.getName(), topLogo, ((MenuItemMiniView)((Button) e.getSource()).getParent()).innerMenuItem);
                stage.setScene(temp);
                stage.show();  
            }
            catch(Exception E){
                System.out.println("The File is not where you think it is for " + ((MenuItemMiniView)((Button) e.getSource()).getParent()).innerMenuItem.getName());
                System.out.println(E.toString());
            
            }
        }
    };

    EventHandler<MouseEvent> menuViewHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            goToMenuView();
        }
    };

    


    public void goToMenuView(){
        menuView.removeAllItems();
            menuView.addAll(menuItemMiniViewList);
            System.out.println("The event handler has started");
            for(int i = 0; i < menuView.menuItems.getChildren().size(); i++){

                ((MenuItemMiniView)menuView.menuItems.getChildren().get(i)).menuButton.setOnMouseClicked(menuItemViewHandler);
                System.out.println("The button " + ((MenuItemMiniView)menuView.menuItems.getChildren().get(i)).menuButton.getId() + " has been assigned");

            }
            stage.setScene(menuView);
            stage.show();
    }


    



   

    @Override
    public void start(Stage stage) {
        this.stage = stage;

        userList = new ArrayList<User>();

        menuList = new ArrayList<MenuItem>();
        menuItemMiniViewList = new ArrayList<MenuItemMiniView>();

        currentUserIDToAssign = userList.size();
        currentUserLoggedIn = -1;

        ArrayList<Button> buttonListHome1 = new ArrayList<Button>();
        loginButton1 = new Button("Login");
        createAccountButton1 = new Button("Create Account");
        Button printUsersButton = new Button("Print Users");
        printUsersButton.setOnMouseClicked(printUsersHandler);
        loginButton1.setOnMouseClicked(loginButtonHandler);
        createAccountButton1.setOnMouseClicked(createAccountButtonHandler);
        buttonListHome1.add(loginButton1);
        buttonListHome1.add(createAccountButton1);
        buttonListHome1.add(printUsersButton);


        ArrayList<Button> buttonListMenu2 = new ArrayList<Button>();
        logout2 = new Button("Logout");
        logout2.setOnMouseClicked(logoutHandler);
        Button currentLogin = new Button("Current Login");
        currentLogin.setOnMouseClicked(currentHandler);
        profile2 = new Button("Profile");
        profile2.setOnMouseClicked(profileHandler);
        
        buttonListMenu2.add(logout2);
        buttonListMenu2.add(currentLogin);
        buttonListMenu2.add(profile2);

        buttonListMenuItem3 = new ArrayList<Button>();
        menu3 = new Button("Return to Menu");
        logout3 = new Button("Logout");
        buttonListMenuItem3.add(menu3);
        buttonListMenuItem3.add(logout3);
        menu3.setOnMouseClicked(menuViewHandler);
        logout3.setOnMouseClicked(logoutHandler);


        ArrayList<Button> buttonListNewProfile5 = new ArrayList<Button>();
        logout5 = new Button("Return to Menu 5");
        logout5.setOnMouseClicked(logoutHandler);
        buttonListNewProfile5.add(logout5);


        ArrayList<Button> buttonListLogin4 = new ArrayList<Button>();
        logout4 = new Button("Return to Menu");
        logout4.setOnMouseClicked(logoutHandler);
        buttonListLogin4.add(logout4);

        ArrayList<Button> buttonListProfile8 = new ArrayList<Button>();
        logout8 = new Button("Logout");
        logout8.setOnMouseClicked(logoutHandler);
        menu8 = new Button("Menu");
        menu8.setOnMouseClicked(menuViewHandler);
        buttonListProfile8.add(menu8);
        buttonListProfile8.add(logout8);




        // DUMMY DATA SECTION
        Customer ethan = new Customer("Ethan", "Joerz", "e", "", 0, "ejoerz@asu.edu", "1234567890");
        Address ethanAddress = new Address("123 pennsylvania ave", "", "0", "85204", "Mesa", "Arizona");
        ethan.setAddress(ethanAddress);
        Payment ethanPayment = new Payment("123456789", ethanAddress, "348", "Tomorrow");
        ethan.setPaymentInfo(ethanPayment);

        Customer john = new Customer("John", "Gardner", "jgard", "password2", 1, "jgard@asu.edu", "2345678901");
        Address johnAddress = new Address("345 Arizona Ave", "", "0", "85211", "Gilbert", "Arizona");
        john.setAddress(johnAddress);
        Payment johnPayment = new Payment("789456123", johnAddress, "147", "Yesterday");
        john.setPaymentInfo(johnPayment);
        Customer dean = new Customer("Dean", "Farar", "dfarar", "password3", 2, "dfarar@asu.edu", "3456789012");
        Address deanAddress = new Address("987 N Mesa Dr", "Unit 123", "123", "85474", "Phoenix", "Arizona");
        dean.setAddress(deanAddress);
        Payment deanPayment = new Payment("456789123", deanAddress, "987", "March");
        dean.setPaymentInfo(deanPayment);
        Restaurant todd = new Restaurant("Todd", "Price", "tprice", "password4", 3, "Frozen Delight", 0);

        Picture p1 = new Picture("/home/ejoerz/test/sample/src/main/java/org/openjfx/cake.jpeg", "Dummy picture");
        Picture p2 = new Picture("/home/ejoerz/test/sample/src/main/java/org/openjfx/cake.jpeg", "Dummy picture");
        Picture p3 = new Picture("/home/ejoerz/test/sample/src/main/java/org/openjfx/cake.jpeg", "Dummy picture");
        Picture p4 = new Picture("/home/ejoerz/test/sample/src/main/java/org/openjfx/cake.jpeg", "Dummy picture");

        MenuItem m1 = new MenuItem("Item 1", p1, 10, 5, 1);
        MenuItem m2 = new MenuItem("Item 2", p2, 13, 23, 0);
        MenuItem m3 = new MenuItem("Item 3", p3, 15, 34, 1);
        MenuItem m4 = new MenuItem("Item 4", p4, 18, 10, 2);
        MenuItem m5 = new MenuItem("Item 5", p1, 10, 5, 1);
        MenuItem m6 = new MenuItem("Item 6", p2, 13, 23, 0);
        MenuItem m7 = new MenuItem("Item 7", p3, 15, 34, 1);
        MenuItem m8 = new MenuItem("Item 8", p4, 18, 10, 2);
        MenuItem m9 = new MenuItem("Item 9", p1, 10, 5, 1);
        MenuItem m10 = new MenuItem("Item 10", p2, 13, 23, 0);
        MenuItem m11 = new MenuItem("Item 11", p3, 15, 34, 1);
        MenuItem m12 = new MenuItem("Item 12", p4, 18, 10, 2);

        m1.addIngredient("Ingredient 1");
        m1.addIngredient("Ingredient 1.5");
        m1.addIngredient("Ingredient 2");
        m1.addIngredient("Ingredient 3");
        m1.addIngredient("Ingredient 4");
        m1.addIngredient("Ingredient 5");
        m1.addIngredient("Ingredient 6.5");
        m1.addIngredient("Ingredient 7");
        m1.addIngredient("Ingredient 8");
        m1.addIngredient("Ingredient 9");
        m1.addIngredient("Ingredient 10");
        m1.addIngredient("Ingredient 11");
        m1.addIngredient("Ingredient 12");
        m1.addIngredient("Ingredient 13");
        m1.addIngredient("Ingredient 14");
        m1.addIngredient("Ingredient 15");

        System.out.println("Got to the start here 1");

        menuList.add(m1);
        menuList.add(m2);
        menuList.add(m3);
        menuList.add(m4);
        menuList.add(m5);
        menuList.add(m6);
        menuList.add(m7);
        menuList.add(m8);
        menuList.add(m9);
        menuList.add(m10);
        menuList.add(m11);
        menuList.add(m12);

        for (int i = 0; i < menuList.size(); i++){
            MenuItemMiniView temp = new MenuItemMiniView(menuList.get(i), 900, 700);
            menuItemMiniViewList.add(temp);
        }
        

        System.out.println("Got to the start here 2");

        userList.add(ethan);
        userList.add(john);
        userList.add(dean);
        userList.add(todd);

        currentUserIDToAssign = 4;
        
        try {



            InputStream in = new FileInputStream("/home/ejoerz/test/sample/src/main/java/org/openjfx/test.png");
            topLogo = new Image(in);
            homeView = new HomeView(900, 700, buttonListHome1, "Frozen Delight Home Page", topLogo);
            
            
            
            newProfileView = new NewProfileView(900, 700, buttonListNewProfile5, "Create New Account", topLogo);
            newProfileView.createAccountButton.setOnMouseClicked(createAccountHandler);
            newProfileView.customerRadio.setOnMouseClicked(customerRadioHandler);
            newProfileView.restaurantRadio.setOnMouseClicked(restaurantRadioHandler);

            profileView = new ProfileView(900, 700, buttonListProfile8, "User Profile", topLogo);
            profileView.saveChanges.setOnMouseClicked(saveChangesToProfileHandler);
            profileView.editAccountInfo.setOnMouseClicked(editProfileInfoHandler);

            loginView = new LoginView(900, 700, buttonListLogin4, "Log In", topLogo);
            loginView.loginButton.setOnMouseClicked(loginHandler);

            menuView = new MenuView(900, 700, buttonListMenu2, "Frozen Delight Menu", topLogo);

            homeView.menu.setOnMouseClicked(menuViewHandler);

            stage.setScene(homeView);
            stage.show();
        }
        catch (Exception fileE) {
            System.out.println("The File is not where you think it is");
            System.out.println(fileE.toString());
            
        }

        

        

    }

    public static void main(String[] args) {
        launch();
    }

    // Everything below here is a basic utility method for quick debugging that won't be in the final version, or event handlers that I wrote based on a quick mockup that I did that I plan on reusing and don't want to have to figure out how to write again, but won't compile properly without all the other classes


    EventHandler<MouseEvent> currentHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            System.out.println("Current User logged in is: " + currentUserLoggedIn + " Name: " + userList.get(findUserId(currentUserLoggedIn)).getFirstName());
        }
    };



    public int findUserId(int newId){
        for (int i = 0; i < userList.size(); i++){
            if( newId == userList.get(i).getUserId()){
                return i;
            }
        }
        return -1;
    }


    public int findUserName(String tempUserName){
        for (int i = 0; i < userList.size(); i++){
            if( tempUserName.equals(userList.get(i).getUserName())){
                return i;
            }
        }
        return -1;
    }

    public int findEmail(String newEmail){
        for (int i = 0; i < userList.size(); i++){
            if(userList.get(i).getClass() == Customer.class){
                if(((Customer)userList.get(i)).getEmail().equals(newEmail)){
                    return i;
                }
            }
        }
        return -1;
    }


    EventHandler<MouseEvent> customerRadioHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            setCustomerButton();
        }
    };


    EventHandler<MouseEvent> restaurantRadioHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            setRestaurantButton();
        }
    };

    public void setCustomerButton(){
        newProfileView.customerRadio.setStyle("-fx-background-color: #00FF00");
            newProfileView.restaurantRadio.setStyle("");
            newProfileView.selectedButton = 0;
            newProfileView.firstNameText.setText("First Name: ");
            newProfileView.lastNameText.setText("Last Name: ");
            newProfileView.userNameText.setText("Username: ");
            newProfileView.passwordText.setText("Password: ");
            newProfileView.emailText.setText("Email ID: ");
            newProfileView.phoneNumberText.setText("Phone Number: ");
            newProfileView.addressLine1Text.setText("Address Line 1: ");
            newProfileView.addressLine2Text.setText("Address Line 2: ");
            newProfileView.zipCodeText.setText("ZipCode: ");
            newProfileView.aptNumPOBoxText.setText("Apt PO Box Number: ");
            newProfileView.cityText.setText("City: ");
            newProfileView.stateText.setText("State: ");
            newProfileView.cardNumText.setText("Card Number: ");
            newProfileView.cardExpDateText.setText("Card Expiration Date: ");
            newProfileView.securityNumText.setText("Security Number (CCV): ");
            
            newProfileView.lastNameTextField.setVisible(true);
            newProfileView.userNameText.setVisible(true);
            newProfileView.passwordText.setVisible(true);
            newProfileView.emailTextField.setVisible(true);
            newProfileView.phoneNumberTextField.setVisible(true);
            newProfileView.addressLine1TextField.setVisible(true);
            newProfileView.addressLine2TextField.setVisible(true);
            newProfileView.zipCodeTextField.setVisible(true);
            newProfileView.aptNumPoBoxTextField.setVisible(true);
            newProfileView.cityTextField.setVisible(true);
            newProfileView.stateTextField.setVisible(true);
            newProfileView.cardNumTextField.setVisible(true);
            newProfileView.cardExpDateTextField.setVisible(true);
            newProfileView.securityNumTextField.setVisible(true);

            newProfileView.removeAllFromNewProfile();
    }

    public void setRestaurantButton(){
        newProfileView.restaurantRadio.setStyle("-fx-background-color: #00FF00");
            newProfileView.customerRadio.setStyle("");
            newProfileView.selectedButton = 1;
            newProfileView.emailText.setText("Restaurant Name: ");
            newProfileView.phoneNumberText.setText("");
            newProfileView.addressLine1Text.setText("");
            newProfileView.addressLine2Text.setText("");
            newProfileView.zipCodeText.setText("");
            newProfileView.aptNumPOBoxText.setText("");
            newProfileView.cityText.setText("");
            newProfileView.stateText.setText("");
            newProfileView.cardNumText.setText("");
            newProfileView.cardExpDateText.setText("");
            newProfileView.securityNumText.setText("");
            
            newProfileView.phoneNumberTextField.setVisible(false);
            newProfileView.addressLine1TextField.setVisible(false);
            newProfileView.addressLine2TextField.setVisible(false);
            newProfileView.zipCodeTextField.setVisible(false);
            newProfileView.aptNumPoBoxTextField.setVisible(false);
            newProfileView.cityTextField.setVisible(false);
            newProfileView.stateTextField.setVisible(false);
            newProfileView.cardNumTextField.setVisible(false);
            newProfileView.cardExpDateTextField.setVisible(false);
            newProfileView.securityNumTextField.setVisible(false);

            newProfileView.removeAllFromNewProfile();
    }



    // public void printBtns(ArrayList<Button> list) {
    //     for (int i = 0; i < list.size(); i++) {
    //         System.out.println(list.get(i).getText());
    //     }
    // }
    // public void printVBox(VBox v) {
    //     for (int i = 0; i < v.getChildren().size(); i++) {
    //         Button temp = (Button) v.getChildren().get(i);
    //         System.out.println(temp.getText());
    //     }
    // }

    // public int findOrderNum(int num) {
    //     for(int i = 0; i < orders.size(); i++) {
    //         if(orders.get(i).orderNum == num) {
    //             return i;
    //         }
    //     }
    //     return -1;
    // }
    // EventHandler<MouseEvent> delOrder = new EventHandler<MouseEvent>() {
    //     public void handle(MouseEvent e) {
    //         Button source = (Button) e.getSource();
    //         GridPane parOrderNode = (GridPane) source.getParent();
    //         VBox parVBox = (VBox) parOrderNode.getParent();
    //         parVBox.getChildren().remove(parOrderNode);
    //         try {
    //         orders.remove(findOrderNum(Integer.parseInt(((Text) parOrderNode.getChildren().get(0)).getText())));
    //         }
    //         catch (Exception ex) {
    //             System.out.println("There was an Exception (Probably this does not exist");
    //         }


    //     }
    // };

    // EventHandler<MouseEvent> toMenuItem = new EventHandler<MouseEvent>() {
    //     public void handle(MouseEvent e) {
    //         Button t1 = ((Button) e.getSource());
    //         HBox t2 = ((HBox) t1.getParent());
    //         Button b1 = new Button("Return to Menu");
    //         b1.setOnMouseClicked(toMenuPage);
    //         ArrayList<Button> b1list = new ArrayList<Button>();
    //         b1list.add(b1);
    //         MenuItem m = new MenuItem(((Text)t2.getChildren().get(1)).getText(), ((Text)t2.getChildren().get(0)).getText(), Integer.parseInt(((Text)t2.getChildren().get(3)).getText()), ((Text)t2.getChildren().get(2)).getText());
    //         MenuItemView t3 = new MenuItemView(stage, 320, 240, b1list, m);
    //         System.out.println("the button for order "+ m.name + "Was pressed");
    //         stage.setScene(t3);
    //         stage.show();


    //     }
    // };

    // EventHandler<MouseEvent> toMenuPage = new EventHandler<MouseEvent>() {
    //     public void handle(MouseEvent e) {
    //         menu.removeAll();
    //         menu.addAllMenuItems(menuList);
    //         VBox par1 = ((VBox)menu.mainView.getChildren().get(1));
    //         System.out.println("The Value of the VBOx is " + ((Text)(par1.getChildren().get(0))).getText());

    //         for(int i = 1; i < par1.getChildren().size(); i++) {  
    //             HBox par2 = (HBox)par1.getChildren().get(i);
    //             Button par3 = (Button)par2.getChildren().get(4);
    //             System.out.println("The value of the button is " + par3.getText());
    //             par3.setOnMouseClicked(toMenuItem);
                

    //         }

    //         stage.setScene(menu);
    //         stage.show();
    //     }
    // };

    // EventHandler<MouseEvent> toOrders = new EventHandler<MouseEvent>() {
    //     public void handle(MouseEvent e) {
    //         System.out.println("This is " + ordersView.pageTitle.getText());
    //         printBtns(ordersView.topButtons);
    //         System.out.println("This is the VBox for " + ordersView.pageTitle.getText());
    //         printVBox(ordersView.topButtonHolder);
    //         ordersView.ordersBox.getChildren().clear();
    //         ordersView.addAllOrders(orders);
    //         for(int i = 0; i < ordersView.ordersBox.getChildren().size(); i++) {
    //             ((Button)((GridPane)ordersView.ordersBox.getChildren().get(i)).getChildren().get(1)).setOnMouseClicked(delOrder);
    //         }
    //         stage.setScene(ordersView);
    //         stage.show();
    //     }
    // };

}
