


import javafx.event.EventHandler;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.text.Text;

/**
 * This is a basic skeleton to test running classes for now, will alter to make final project properly
 */
public class App extends Application{

    int currentUserIDToAssign;
    int currentCouponNum;
    int currentUserLoggedIn;
    ArrayList<User> userList;
    ArrayList<Order> orders;
    ArrayList<MenuItem> menuList;
    Image topLogo;
    Order currentOrder;
    int nextOrderNumber;

    HomeView homeView;
    MenuView menuView;
    LoginView loginView;
    NewProfileView newProfileView;
    CartView cartView;
    CheckoutView checkOutView;
    ProfileView profileView;
    waitTimeView waitView; 
    EditItemView editItemView;
    OrderView orderView;
    CouponView couponView;
    String currentCoupon;

    Customer guest;

    ArrayList<MenuItemMiniView> menuItemMiniViewList;

    String pwd = "/home/ejoerz/test/sample/src/main/java/org/openjfx/";

    
    
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
    Button menu7;
    Button profile7;
    Button logout7;

    // ProfileView Buttons
    Button logout8;
    Button menu8;
    
    // WaitView Buttons
    Button logout9;


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
    Button profile12;
    Button orders12;
    Button logout12;
    

    

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
            currentOrder = new Order(nextOrderNumber, guest);
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
            System.out.println("Customer : Name: " + guest.getFirstName() + " UserID: " + guest.getUserId() + " City: " + guest.getAddress().getCity() + ":");            

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
                    if(userList.get(userIndex).getClass() == Customer.class){
                        goToMenuView();
                    }
                    else if (userList.get(userIndex).getClass() == Restaurant.class){
                        setOrderView();
                    }
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
            if(findUserId(currentUserLoggedIn) == -1){
                profileView.addAllFieldsToProfile(guest);
                profileView.saveChanges.setVisible(false);
                profileView.editAccountInfo.setVisible(false);
            }
            else{
                profileView.addAllFieldsToProfile(userList.get(findUserId(currentUserLoggedIn)));
                for(int i = 0; i < profileView.overallBox.getChildren().size(); i++){
                    ((Button)((HBox)profileView.overallBox.getChildren().get(i)).getChildren().get(4)).setOnMouseClicked(useCurrentCouponHandler);
                }
            }
            
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
            try{
                InputStream in = new FileInputStream(pwd + "test.png");
                topLogo = new Image(in);

                MenuItemView temp = new MenuItemView(900, 700, buttonListMenuItem3, ((MenuItemMiniView)((Button) e.getSource()).getParent()).innerMenuItem.getName(), topLogo, ((MenuItemMiniView)((Button) e.getSource()).getParent()).innerMenuItem, -2, pwd);

                temp.regular.setOnMouseClicked(regularButtonHandler);
                temp.medium.setOnMouseClicked(mediumButtonHandler);
                temp.large.setOnMouseClicked(largeButtonHandler);

                temp.plus.setOnMouseClicked(incrementButtonHandler);
                temp.minus.setOnMouseClicked(decrementButtonHandler);

                temp.addToCart.setOnMouseClicked(addItemToCartHandler);

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

    EventHandler<MouseEvent> regularButtonHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            ((Button) e.getSource()).setStyle("-fx-background-color: #00FF00");
            ((MenuItemView)((Button) e.getSource()).getScene()).buttonSelected = 0;
            ((MenuItemView)((Button) e.getSource()).getScene()).medium.setStyle("");
            ((MenuItemView)((Button) e.getSource()).getScene()).large.setStyle("");
        }
    };
    EventHandler<MouseEvent> mediumButtonHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            ((Button) e.getSource()).setStyle("-fx-background-color: #00FF00");
            ((MenuItemView)((Button) e.getSource()).getScene()).buttonSelected = 1;
            ((MenuItemView)((Button) e.getSource()).getScene()).regular.setStyle("");
            ((MenuItemView)((Button) e.getSource()).getScene()).large.setStyle("");
        }
    };

    EventHandler<MouseEvent> largeButtonHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            ((Button) e.getSource()).setStyle("-fx-background-color: #00FF00");
            ((MenuItemView)((Button) e.getSource()).getScene()).buttonSelected = 2;
            ((MenuItemView)((Button) e.getSource()).getScene()).regular.setStyle("");
            ((MenuItemView)((Button) e.getSource()).getScene()).medium.setStyle("");
        }
    };

    EventHandler<MouseEvent> incrementButtonHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            int temp = Integer.parseInt(((MenuItemView)((Button) e.getSource()).getScene()).quantity.getText());
            temp ++;

            ((MenuItemView)((Button) e.getSource()).getScene()).quantity.setText("" + temp);
        }
    };

    EventHandler<MouseEvent> decrementButtonHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            int temp = Integer.parseInt(((MenuItemView)((Button) e.getSource()).getScene()).quantity.getText());
            if(temp > 0){
                temp--;
            }
            

            ((MenuItemView)((Button) e.getSource()).getScene()).quantity.setText("" + temp);
        }
    };

    EventHandler<MouseEvent> addItemToCartHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            OrderItem temp = new OrderItem(((MenuItemView)((Button) e.getSource()).getScene()).item, "", ((MenuItemView)((Button) e.getSource()).getScene()).buttonSelected, (Integer.parseInt(((MenuItemView)((Button) e.getSource()).getScene()).quantity.getText())), (Integer.parseInt(((MenuItemView)((Button) e.getSource()).getScene()).quantity.getText())) * ((MenuItemView)((Button) e.getSource()).getScene()).item.getPrice());
            currentOrder.addOrderItem(temp);
            goToMenuView();
        }
    };



    


    public void goToMenuView(){
        menuView.removeAllItems();
            menuView.addAll(menuItemMiniViewList);
            System.out.println("The event handler has started");
            for(int i = 0; i < menuView.menuItems.getChildren().size(); i++){

                ((MenuItemMiniView)menuView.menuItems.getChildren().get(i)).menuButton.setOnMouseClicked(menuItemViewHandler);
                

            }
            stage.setScene(menuView);
            stage.show();
    }

    EventHandler<MouseEvent> cartViewHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            removeAllItemsFromCart(cartView);
            addAllItemsToCart(currentOrder, cartView);
            stage.setScene(cartView);
            stage.show();
        }
    };

    EventHandler<MouseEvent> removeCartViewHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            

            cartView.itemsContainter.getChildren().remove(((CartItemView)((Button) e.getSource()).getParent()));
            currentOrder.removeOrderItem(((CartItemView)((Button) e.getSource()).getParent()).item);

            removeAllItemsFromCart(cartView);
            addAllItemsToCart(currentOrder, cartView);
            stage.setScene(cartView);
            stage.show();
        }
    };

    EventHandler<MouseEvent> editCartViewHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            

            try{
                InputStream in = new FileInputStream(pwd + "test.png");
                topLogo = new Image(in);

                int temp1 = findItem(((CartItemView)((Button) e.getSource()).getParent()).item);

                MenuItemView temp = new MenuItemView(900, 700, buttonListMenuItem3, ((CartItemView)((Button) e.getSource()).getParent()).item.getItem().getName(), topLogo, ((CartItemView)((Button) e.getSource()).getParent()).item.getItem(), temp1, pwd);

                temp.buttonSelected =  ((CartItemView)((Button) e.getSource()).getParent()).item.getSize();

                if(temp.buttonSelected == 0){
                    temp.regular.setStyle("-fx-background-color: #00FF00");
                    temp.medium.setStyle("");
                    temp.large.setStyle("");
                }
                else if(temp.buttonSelected == 1){
                    temp.regular.setStyle("");
                    temp.medium.setStyle("-fx-background-color: #00FF00");
                    temp.large.setStyle("");
                }
                else if(temp.buttonSelected == 2){
                    temp.regular.setStyle("");
                    temp.medium.setStyle("");
                    temp.large.setStyle("-fx-background-color: #00FF00");
                }
                temp.regular.setOnMouseClicked(regularButtonHandler);
                temp.medium.setOnMouseClicked(mediumButtonHandler);
                temp.large.setOnMouseClicked(largeButtonHandler);

                temp.amount.setText(((CartItemView)((Button) e.getSource()).getParent()).price.getText());



                temp.plus.setOnMouseClicked(incrementButtonHandler);
                temp.minus.setOnMouseClicked(decrementButtonHandler);

                temp.quantity.setText(((CartItemView)((Button) e.getSource()).getParent()).quantity.getText());

                temp.addToCart.setOnMouseClicked(addEditedItemToCartHandler);

                stage.setScene(temp);
                stage.show();  
            }
            catch(Exception E){
                System.out.println("The File is not where you think it is for " + ((MenuItemMiniView)((Button) e.getSource()).getParent()).innerMenuItem.getName());
                System.out.println(E.toString());
            
            }
        }
    };


    // TODO bug with pricing changes when editing item
    EventHandler<MouseEvent> addEditedItemToCartHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            int temp = ((MenuItemView)((Button) e.getSource()).getScene()).thisIndex;
            currentOrder.getOrderContents().get(temp).setSize(((MenuItemView)((Button) e.getSource()).getScene()).buttonSelected);
            currentOrder.getOrderContents().get(temp).setQuantity(Integer.parseInt(((MenuItemView)((Button) e.getSource()).getScene()).quantity.getText()));
            currentOrder.getOrderContents().get(temp).setPrice(currentOrder.getOrderContents().get(temp).getItem().getPrice());

            removeAllItemsFromCart(cartView);
            addAllItemsToCart(currentOrder, cartView);
            stage.setScene(cartView);
            stage.show();
        }
    };



    public void addAllItemsToCart(Order newOrder, CartView cart)
	{
		for(int i = 0; i < newOrder.getOrderContents().size(); i++){
			CartItemView temp = new CartItemView(newOrder.getOrderContents().get(i), cart.insideXSize, cart.insideYSize);
			cart.itemsContainter.getChildren().add(temp);
            temp.remove.setOnMouseClicked(removeCartViewHandler);
            temp.edit.setOnMouseClicked(editCartViewHandler);

		}

		cart.total.setText("" + newOrder.getTotalPrice());
	}
	
	public void removeAllItemsFromCart(CartView cart)
	{
		cart.itemsContainter.getChildren().clear();
	}

    EventHandler<MouseEvent> cancelCartViewHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            

            currentOrder = new Order(nextOrderNumber, guest);
            goToMenuView();
        }
    };

    EventHandler<MouseEvent> checkoutViewHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            
            checkOutView.removeAllItems();
            
            if(currentUserLoggedIn == -1) {
                checkOutView.addAllItemsToCart(currentOrder, guest);
                checkOutView.firstNameTextField.setText("Enter First Name");
                checkOutView.lastNameTextField.setText("Enter Last Name");
                checkOutView.addressLine1Text.setText("Enter Address Line 1");
                checkOutView.addressLine2Text.setText("Enter Address Line 2");
                

            }
            else{
                checkOutView.addAllItemsToCart(currentOrder, userList.get(findUserId(currentUserLoggedIn)));
            }
            
            checkOutView.editCartButton.setOnMouseClicked(cartViewHandler);
            checkOutView.placeOrderButton.setOnMouseClicked(placeOrderHandler);
            stage.setScene(checkOutView);
            stage.show();
        }
    };

    EventHandler<MouseEvent> placeOrderHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            if(currentUserLoggedIn == -1){
                Customer tempCustomer = new Customer(checkOutView.firstNameTextField.getText(), checkOutView.lastNameTextField.getText(), "guest", "", -1, checkOutView.emailTextField.getText(), checkOutView.phoneNumTextField.getText());
                Order temp = new Order(nextOrderNumber, tempCustomer);
                Address tempAddress = new Address(checkOutView.addressLine1TextField.getText(), checkOutView.addressLine2TextField.getText(), checkOutView.aptNumPoBoxTextField.getText(), checkOutView.zipCodeTextField.getText(), checkOutView.cityTextField.getText(), checkOutView.stateTextField.getText());

                Payment tempPayment = new Payment(checkOutView.cardNumTextField.getText(), tempAddress, checkOutView.secCodeTextField.getText(), checkOutView.cardExpDateTextField.getText());

                temp.getOrderer().setAddress(tempAddress);
                temp.getOrderer().setPaymentInfo(tempPayment);

                for(int i = 0; i < currentOrder.getOrderContents().size(); i++){
                    temp.addOrderItem(currentOrder.getOrderContents().get(i));
                }

                orders.add(temp);

            }
            else{
                Order temp = new Order(nextOrderNumber, (Customer) userList.get(findUserId(currentUserLoggedIn)));
                for(int i = 0; i < currentOrder.getOrderContents().size(); i++){
                    temp.addOrderItem(currentOrder.getOrderContents().get(i));
                }
                orders.add(temp);
            }

            nextOrderNumber++;

            waitView.readyTime.setText("15");
            waitView.numberOrders.setText("2");

            stage.setScene(waitView);
            stage.show();

        }
    };



    EventHandler<MouseEvent> ordersViewHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            
           setOrderView();
        }
    };

    EventHandler<MouseEvent> cancelOrderHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            System.out.println("cancelOrderHandler was clicked");
            int tempIndex = findOrder(((OrderItemView)((Button)e.getSource()).getParent()).item);
            if(tempIndex > -1){
                orders.remove(tempIndex);
            }
            else{
                System.out.println("Somehow the cancelOrderHandler is wrong (Line 620)");
            }
            
            setOrderView();
        }
    };

    public void setOrderView(){
        orderView.removeAllOrders();
            orderView.addAllOrders(orders);
            for(int i = 0; i < orderView.orderVbox.getChildren().size(); i++){
                ((OrderItemView)(orderView.orderVbox.getChildren().get(i))).cancel.setOnMouseClicked(cancelOrderHandler);
                ((OrderItemView)(orderView.orderVbox.getChildren().get(i))).markAsComplete.setOnMouseClicked(cancelOrderHandler);
            }

            stage.setScene(orderView);
            stage.show();
    }



    EventHandler<MouseEvent> editItemViewHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            
            editItemView.removeAllFields();;
            stage.setScene(editItemView);
            stage.show();
        }
    };

    EventHandler<MouseEvent> editItemSearchHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            
            String temp = editItemView.searchBar.getText();
            editItemView.removeAllFields();
            editItemView.searchBar.setText(temp);
            int tempIndex = findMenuItem(temp);
            if(tempIndex == -1){
                
                editItemView.foodItemNewName.setText("Try Again");
            }
            else{
                editItemView.item = menuList.get(tempIndex);
                editItemView.foodItemNewName.setText(editItemView.item.getName());
                editItemView.prepTimeTextField.setText("" + editItemView.item.getPrepTime());
                editItemView.newPriceTextField.setText("" + editItemView.item.getPrice());
                editItemView.selectedCategory = editItemView.item.getCategory();
                editItemView.foodTagsTextField.setText(editItemView.item.getPicture().getUrl());
                
                if(editItemView.selectedCategory == 0){
                    editItemView.cakeRadioButton.setStyle("-fx-background-color: #00FF00");
                    editItemView.smoothieRadioButton.setStyle("");
                    editItemView.iceCreamRadioButton.setStyle("");
                }
                else if (editItemView.selectedCategory == 1){
                    editItemView.cakeRadioButton.setStyle("");
                    editItemView.smoothieRadioButton.setStyle("-fx-background-color: #00FF00");
                    editItemView.iceCreamRadioButton.setStyle("");
                }

                else if (editItemView.selectedCategory == 2){
                    editItemView.cakeRadioButton.setStyle("");
                    editItemView.smoothieRadioButton.setStyle("");
                    editItemView.iceCreamRadioButton.setStyle("-fx-background-color: #00FF00");
                }

            }
        }
    };

    EventHandler<MouseEvent> cakeRadioButtonHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            editItemView.selectedCategory = 0;
            editItemView.cakeRadioButton.setStyle("-fx-background-color: #00FF00");
            editItemView.smoothieRadioButton.setStyle("");
            editItemView.iceCreamRadioButton.setStyle("");
        }
    };

    EventHandler<MouseEvent> smoothieRadioButtonHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            editItemView.selectedCategory = 1;
            editItemView.cakeRadioButton.setStyle("");
            editItemView.smoothieRadioButton.setStyle("-fx-background-color: #00FF00");
            editItemView.iceCreamRadioButton.setStyle("");
        }
    };

    EventHandler<MouseEvent> iceCreamRadioButtonHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            editItemView.selectedCategory = 2;
            editItemView.cakeRadioButton.setStyle("");
            editItemView.smoothieRadioButton.setStyle("");
            editItemView.iceCreamRadioButton.setStyle("-fx-background-color: #00FF00");
        }
    };
    EventHandler<MouseEvent> editExistingItemButtonHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            editItemView.selectedMode = 0;
            editItemView.editExistingItemButton.setStyle("-fx-background-color: #00FF00");
            editItemView.addNewItemButton.setStyle("");
            editItemView.deleteItemButton.setStyle("");
            editItemView.searchBar.setVisible(true);
            editItemView.searchGoButton.setVisible(true);
            editItemView.createItemButton.setText("Create Item");
            
        }
    };
    EventHandler<MouseEvent> createNewItemButtonHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            editItemView.selectedMode = 1;
            editItemView.editExistingItemButton.setStyle("");
            editItemView.addNewItemButton.setStyle("-fx-background-color: #00FF00");
            editItemView.deleteItemButton.setStyle("");
            editItemView.removeAllFields();
            editItemView.searchBar.setVisible(false);
            editItemView.searchGoButton.setVisible(false);
            editItemView.createItemButton.setText("Create Item");

        }
    };

    EventHandler<MouseEvent> deleteItemButtonHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            editItemView.selectedMode = 2;
            editItemView.editExistingItemButton.setStyle("");
            editItemView.addNewItemButton.setStyle("");
            editItemView.deleteItemButton.setStyle("-fx-background-color: #00FF00");
            editItemView.removeAllFields();
            editItemView.searchBar.setVisible(true);
            editItemView.searchGoButton.setVisible(true);

            editItemView.createItemButton.setText("Remove Item");

        }
    };

    EventHandler<MouseEvent> createNewItemHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            if(editItemView.selectedMode == 0){
                int tempIndex = findMenuItem(editItemView.item.getName());
                if(tempIndex != -1){
                    menuList.get(tempIndex).setName(editItemView.foodItemNewName.getText());
                    menuList.get(tempIndex).setPictureURL(editItemView.foodTagsTextField.getText());
                    menuList.get(tempIndex).setPrice(Integer.parseInt(editItemView.newPriceTextField.getText()));
                    menuList.get(tempIndex).setPrepTime(Integer.parseInt(editItemView.prepTimeTextField.getText()));
                    menuList.get(tempIndex).setCategory(editItemView.selectedCategory);
                    for(int i = 0; i < menuItemMiniViewList.size(); i++){
                        if(menuItemMiniViewList.get(i).innerMenuItem == menuList.get(tempIndex)){
                            menuItemMiniViewList.get(i).menuName.setText(editItemView.foodItemNewName.getText());
                            try{
                                InputStream in = new FileInputStream(pwd + editItemView.foodTagsTextField.getText());
                                Image menuImg = new Image(in);
                                menuItemMiniViewList.get(i).menuImage.setImage(menuImg);
                                menuList.get(tempIndex).getPicture().setUrl(editItemView.foodTagsTextField.getText());
                                editItemView.ingredientListTextField.setText("Picture Succesful");
                            }
                            catch(Exception e2){
                                System.out.println(e2.toString());
                                editItemView.ingredientListTextField.setText("Please Try Again");
                            }
                        }
                    }

                    System.out.println("Edited");
                }
            }
            else if (editItemView.selectedMode == 1){
                MenuItem temp = new MenuItem(editItemView.foodItemNewName.getText(), new Picture(editItemView.foodTagsTextField.getText(), ""), Integer.parseInt(editItemView.newPriceTextField.getText()), Integer.parseInt(editItemView.prepTimeTextField.getText()), editItemView.selectedCategory);

                menuList.add(temp);
                MenuItemMiniView temp2 = new MenuItemMiniView(temp, 900, 700, pwd);
                menuItemMiniViewList.add(temp2);
                System.out.println("Created");
            }

            else if(editItemView.selectedMode == 2){
                int tempIndex = findMenuItem(editItemView.item.getName());
                if(tempIndex != -1){
                    for(int i = 0; i < menuItemMiniViewList.size(); i++){
                        if(menuItemMiniViewList.get(i).innerMenuItem == menuList.get(tempIndex)){
                            menuItemMiniViewList.remove(i);
                        }
                    }
                    menuList.remove(tempIndex);
                }
                System.out.println("Deleted");
            }

        }
    };

    EventHandler<MouseEvent> couponViewHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            couponView.giveCoupon.setOnMouseClicked(giveCouponHandler);
            couponView.enterName.setEditable(false);
            couponView.giveCoupon.setDisable(true);
            couponView.enterName.setText("");
            couponView.enterPercent.setText("");
            
            stage.setScene(couponView);
            stage.show();

        }
    };

    EventHandler<MouseEvent> couponSearchBarHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            
            int tempIndex = findUserName(couponView.searchbar.getText());
            couponView.enterPercent.setText("");
            if(tempIndex > -1){
                if(userList.get(tempIndex).getClass() == Customer.class){
                    couponView.enterName.setText(userList.get(tempIndex).userName);
                    couponView.giveCoupon.setDisable(false);
                    
                }
                else{
                    couponView.enterName.setText("Not a customer");
                }
               
            }
            else{
                couponView.enterName.setText("Try Again");
                
            }


        }
    };

    EventHandler<MouseEvent> giveCouponHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            
            int tempIndex = findUserName(couponView.enterName.getText());
            if(tempIndex > -1){
                String tempString = "";
                int random;
                Random rand = new Random();
                for(int i = 0; i < 4; i++){
                    random = rand.nextInt(25);
                    random += 97;
                    tempString += Character.toString(random);
                }
                tempString += currentCouponNum;
                for(int i = 0; i < 4; i++){
                    random = rand.nextInt(25);
                    random += 97;
                    tempString += Character.toString(random);
                }

                Coupon tempCoupon = new Coupon(Integer.parseInt(couponView.enterPercent.getText()), "", tempString);
                ((Customer)userList.get(tempIndex)).setCoupon(tempCoupon);
                currentCouponNum ++;
                couponView.enterName.setText("");
                couponView.enterPercent.setText("");
                couponView.giveCoupon.setDisable(true);
            }
            
        }
    };

    EventHandler<MouseEvent> useCurrentCouponHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            System.out.println("Using a coupon");

            currentCoupon = ((Text)((HBox)((Button)e.getSource()).getParent()).getChildren().get(1)).getText();

        }
    };

    EventHandler<MouseEvent> cancelCheckoutOrderHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            currentOrder = new Order(nextOrderNumber, guest);
            goToMenuView();

        }
    };



    

    



    


    
   

    @Override
    public void start(Stage stage) {
        this.stage = stage;

        currentCoupon = "";
        nextOrderNumber = 2;
        SaveState tempIn = null;
        try{
            FileInputStream fileIn = new FileInputStream(pwd + "tempFile.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            tempIn = (SaveState) in.readObject();
            in.close();
            fileIn.close();

            nextOrderNumber = tempIn.nextOrderNumber;
            userList = tempIn.getUserList();
            menuList = tempIn.getMenuList();
            orders = tempIn.getOrderList();
            currentUserIDToAssign = tempIn.getCurrentUserIDtoAssign();
            currentCouponNum = tempIn.getCurrentCouponNum();

        }catch(Exception e4){
            e4.printStackTrace();
        }

        guest = new Customer("Guest", "Guest", "guest", "", -1, "", "");
        Address guestAddress = new Address("", "", "", "", "", "");
        guest.setAddress(guestAddress);
        Payment guestPayment = new Payment("", guestAddress, "", "");
        guest.setPaymentInfo(guestPayment);

        // currentCouponNum = 10;
        // orders = new ArrayList<Order>();

        currentOrder = new Order(-2, guest);

        // userList = new ArrayList<User>();

        // menuList = new ArrayList<MenuItem>();
        menuItemMiniViewList = new ArrayList<MenuItemMiniView>();

        // currentUserIDToAssign = userList.size();
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
        cart2 = new Button("Cart");
        cart2.setOnMouseClicked(cartViewHandler);
        profile2 = new Button("Profile");
        profile2.setOnMouseClicked(profileHandler);
        
        buttonListMenu2.add(logout2);
        buttonListMenu2.add(cart2);
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

        ArrayList<Button> buttonListCart6 = new ArrayList<Button>();
        logout6 = new Button("Logout");
        logout6.setOnMouseClicked(logoutHandler);
        profile6 = new Button("Profile");
        profile6.setOnMouseClicked(profileHandler);
        menu6 = new Button("Menu");
        menu6.setOnMouseClicked(menuViewHandler);

        buttonListCart6.add(menu6);
        buttonListCart6.add(profile6);
        buttonListCart6.add(logout6);

        ArrayList<Button> buttonListCheckout7 = new ArrayList<Button>();
        logout7 = new Button("Logout");
        logout7.setOnMouseClicked(logoutHandler);
        profile7 = new Button("Profile");
        profile7.setOnMouseClicked(profileHandler);
        menu7 = new Button("Menu");
        menu7.setOnMouseClicked(menuViewHandler);

        buttonListCheckout7.add(menu7);
        buttonListCheckout7.add(profile7);
        buttonListCheckout7.add(logout7);




        ArrayList<Button> buttonListProfile8 = new ArrayList<Button>();
        logout8 = new Button("Logout");
        logout8.setOnMouseClicked(logoutHandler);
        menu8 = new Button("Menu");
        menu8.setOnMouseClicked(menuViewHandler);
        buttonListProfile8.add(menu8);
        buttonListProfile8.add(logout8);

        ArrayList<Button> buttonListWait9 = new ArrayList<Button>();
        logout9 = new Button("Logout");
        logout9.setOnMouseClicked(logoutHandler);
        buttonListWait9.add(logout9);

        ArrayList<Button> buttonListEditItem10 = new ArrayList<Button>();
        logout10 = new Button("Logout");
        logout10.setOnMouseClicked(logoutHandler);
        profile10 = new Button("Profile");
        profile10.setOnMouseClicked(profileHandler);
        orders10 = new Button("Orders");
        orders10.setOnMouseClicked(ordersViewHandler);
        buttonListEditItem10.add(logout10);
        buttonListEditItem10.add(orders10);
        buttonListEditItem10.add(profile10);


        ArrayList<Button> buttonListOrder11 = new ArrayList<Button>();
        logout11 = new Button("Logout");
        logout11.setOnMouseClicked(logoutHandler);
        profile11 = new Button("Profile");
        profile11.setOnMouseClicked(profileHandler);
        createItem11 = new Button("Create/Edit Item");
        createItem11.setOnMouseClicked(editItemViewHandler);
        createCoupon11 = new Button("Create Coupon");
        createCoupon11.setOnMouseClicked(couponViewHandler);
        buttonListOrder11.add(logout11);
        buttonListOrder11.add(profile11);
        buttonListOrder11.add(createItem11);
        buttonListOrder11.add(createCoupon11);

        ArrayList<Button> buttonListCoupon12 = new ArrayList<Button>();
        logout12 = new Button("Logout");
        logout12.setOnMouseClicked(logoutHandler);
        profile12 = new Button("Profile");
        profile12.setOnMouseClicked(profileHandler);
        orders12 = new Button("Orders");
        orders12.setOnMouseClicked(ordersViewHandler);
        buttonListCoupon12.add(logout12);
        buttonListCoupon12.add(orders12);
        buttonListCoupon12.add(profile12);

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

       

        Picture p1 = new Picture("frozenchocolatecake.jpeg", "Frozen Chocolate Mousse Cake");
        Picture p2 = new Picture("strawberrybananasmoothie.jpeg", "Strawberry Banana Smoothie");
        Picture p3 = new Picture("gelatoswirl.jpeg", "Gelato Swirl");
        Picture p4 = new Picture("mangosmoothie.jpeg", "Merry Mango Smoothie");
        Picture p5 = new Picture("sundaefunday.jpeg", "Sunday Fundae");
        Picture p6 = new Picture("cherrycherry.jpeg", "Cherry Cherry Ice Cream");
        Picture p7 = new Picture("peachysmoothie.jpg", "It's Quite Peachy Smoothie");
        Picture p8 = new Picture("cheesecake.jpeg", "No Bake Frozen Cheesecake");
        Picture p9 = new Picture("carameltopped.jpeg", "Caramel Topped Ice Cream Dessert");
        Picture p10 = new Picture("oreoicecreamcake.jpeg", "Oreo Ice Cream Cake");
        Picture p11 = new Picture("greenberrysmoothie.jpeg", "Green Berry Smoothie");

        MenuItem m1 = new MenuItem("Frozen Chocolate Mousse Cake", p1, 10, 5, 0);
        MenuItem m2 = new MenuItem("Strawberry banana smoothie", p2, 13, 23, 1);
        MenuItem m3 = new MenuItem("Gelato swirl", p3, 15, 34, 2);
        MenuItem m4 = new MenuItem("Merry mango smoothie", p4, 18, 10, 1);
        MenuItem m5 = new MenuItem("Sundae funday", p5, 10, 5, 2);
        MenuItem m6 = new MenuItem("Cherry Cherry ice cream", p6, 13, 23, 2);
        MenuItem m7 = new MenuItem("It's quite peachy smoothie", p7, 15, 34, 1);
        MenuItem m8 = new MenuItem("No bake frozen cheesecake", p8, 18, 10, 0);
        MenuItem m9 = new MenuItem("Caramel topped ice cream dessert", p9, 10, 5, 2);
        MenuItem m10 = new MenuItem("Oreo ice cream cake", p10, 13, 23, 0);
        MenuItem m11 = new MenuItem("Green berry smoothie", p11, 15, 34, 1);

        m1.addIngredient("dark chocolate");
        m1.addIngredient("eggs");
        m1.addIngredient("flour");
        m1.addIngredient("strawberries");
        m1.addIngredient("butter");
        m2.addIngredient("strawberries");
        m2.addIngredient("bananas");
        m2.addIngredient("vanilla ice cream");
        m2.addIngredient("milk");
        m3.addIngredient("mint");
        m3.addIngredient("milk chocolate");
        m3.addIngredient("cream");
        m3.addIngredient("sugar");
        m4.addIngredient("mangos");
        m4.addIngredient("milk");
        m4.addIngredient("honey");
        m5.addIngredient("vanilla ice cream");
        m5.addIngredient("bananas");
        m5.addIngredient("chocolate syrup");
        m5.addIngredient("strawberry syrup");
        m5.addIngredient("whip cream");
        m6.addIngredient("cherries");
        m6.addIngredient("dairy ice cream");
        m6.addIngredient("chocolate syrup");
        m7.addIngredient("peaches");
        m7.addIngredient("coconut milk");
        m7.addIngredient("peach yogurt");
        m8.addIngredient("strawberries");
        m8.addIngredient("blueberries");
        m8.addIngredient("blackberries");
        m8.addIngredient("butter");
        m8.addIngredient("sugar");
        m8.addIngredient("vanilla");
        m8.addIngredient("lemon juice");
        m8.addIngredient("cheesecake filling");
        m8.addIngredient("cream cheese");
        m8.addIngredient("graham cracker");
        m9.addIngredient("cashews");
        m9.addIngredient("shortbread cookies");
        m9.addIngredient("chocolate");
        m9.addIngredient("sugar");
        m9.addIngredient("vanilla");
        m9.addIngredient("milk");
        m9.addIngredient("pretzel sticks");
        m9.addIngredient("ice cream");
        m9.addIngredient("caramel");
        m10.addIngredient("oreos");
        m10.addIngredient("oreo ice cream");
        m10.addIngredient("fudge sauce");
        m10.addIngredient("whipped cream");
        m11.addIngredient("celery");
        m11.addIngredient("avocado");
        m11.addIngredient("rasberry");
        m11.addIngredient("blueberry");

        System.out.println("Got to the start here 1");

        // menuList.add(m1);
        // menuList.add(m2);
        // menuList.add(m3);
        // menuList.add(m4);
        // menuList.add(m5);
        // menuList.add(m6);
        // menuList.add(m7);
        // menuList.add(m8);
        // menuList.add(m9);
        // menuList.add(m10);
        // menuList.add(m11);

        OrderItem o1 = new OrderItem(m1,"no strawberries", 1, 1, m1.getPrice());
        OrderItem o2 = new OrderItem(m10,"none",2,2,m10.getPrice());
        Order ethansOrder = new Order(1,ethan);
        ethansOrder.addOrderItem(o1);
        ethansOrder.addOrderItem(o2);

        // System.out.println(o1.toString());
        // System.out.println(o2.toString());


        OrderItem o3 = new OrderItem(m3,"none",1,4,m3.getPrice());
        Order johnsOrder = new Order(2, john);
        johnsOrder.addOrderItem(o3);

        OrderItem o4 = new OrderItem(m6,"none",1,1,m6.getPrice());
        OrderItem o5 = new OrderItem(m9,"no pretzel sticks, no cashews", 2, 5, m9.getPrice());
        OrderItem o6 = new OrderItem(m11,"none",1,1,m11.getPrice());
        Order deansOrder = new Order(3,dean);
        deansOrder.addOrderItem(o4);
        deansOrder.addOrderItem(o5); 
        deansOrder.addOrderItem(o6);

        // currentOrder = ethansOrder;

        // orders.add(deansOrder);
        // orders.add(johnsOrder);
        for (int i = 0; i < menuList.size(); i++){
            MenuItemMiniView temp = new MenuItemMiniView(menuList.get(i), 900, 700, pwd);
            menuItemMiniViewList.add(temp);
        }
        


        // userList.add(ethan);
        // userList.add(john);
        // userList.add(dean);
        // userList.add(todd);

        // currentUserIDToAssign = 4;
        
        try {



            InputStream in = new FileInputStream(pwd + "test.png");
            topLogo = new Image(in);
            homeView = new HomeView(900, 700, buttonListHome1, "Frozen Delight Home Page", topLogo, pwd);
            
            
            
            newProfileView = new NewProfileView(900, 700, buttonListNewProfile5, "Create New Account", topLogo, pwd);
            newProfileView.createAccountButton.setOnMouseClicked(createAccountHandler);
            newProfileView.customerRadio.setOnMouseClicked(customerRadioHandler);
            newProfileView.restaurantRadio.setOnMouseClicked(restaurantRadioHandler);

            profileView = new ProfileView(900, 700, buttonListProfile8, "User Profile", topLogo, pwd);
            profileView.saveChanges.setOnMouseClicked(saveChangesToProfileHandler);
            profileView.editAccountInfo.setOnMouseClicked(editProfileInfoHandler);

            loginView = new LoginView(900, 700, buttonListLogin4, "Log In", topLogo, pwd);
            loginView.loginButton.setOnMouseClicked(loginHandler);

            menuView = new MenuView(900, 700, buttonListMenu2, "Frozen Delight Menu", topLogo, pwd);

            

            cartView = new CartView(900, 700, buttonListCart6, "Cart", topLogo, currentOrder, pwd);
            cartView.cancelOrderButton.setOnMouseClicked(cancelCartViewHandler);
            cartView.checkOutButton.setOnMouseClicked(checkoutViewHandler);

            checkOutView = new CheckoutView(900, 700, buttonListCheckout7, "Checkout", topLogo, currentOrder, pwd);
            checkOutView.logInButton.setOnMouseClicked(loginButtonHandler);
            checkOutView.cancelOrderButton.setOnMouseClicked(cancelCheckoutOrderHandler);


            waitView = new waitTimeView(900, 700, buttonListWait9, "Checkout", topLogo, pwd);

            orderView = new OrderView(900, 700, buttonListOrder11, "Orders", topLogo, pwd);

            editItemView = new EditItemView(900, 700, buttonListEditItem10, "Edit Item", topLogo, pwd);
            editItemView.searchGoButton.setOnMouseClicked(editItemSearchHandler);
            editItemView.cakeRadioButton.setOnMouseClicked(cakeRadioButtonHandler);
            editItemView.smoothieRadioButton.setOnMouseClicked(smoothieRadioButtonHandler);
            editItemView.iceCreamRadioButton.setOnMouseClicked(iceCreamRadioButtonHandler);
            editItemView.addNewItemButton.setOnMouseClicked(createNewItemButtonHandler);
            editItemView.editExistingItemButton.setOnMouseClicked(editExistingItemButtonHandler);
            editItemView.deleteItemButton.setOnMouseClicked(deleteItemButtonHandler);
            editItemView.createItemButton.setOnMouseClicked(createNewItemHandler);

            couponView = new CouponView(900, 700, buttonListCoupon12, "Coupons", topLogo, pwd);
            couponView.giveCoupon.setOnMouseClicked(giveCouponHandler);
            couponView.goButton.setOnMouseClicked(couponSearchBarHandler);

            homeView.menu.setOnMouseClicked(menuViewHandler);

            stage.setScene(homeView);
            stage.show();
        }
        catch (Exception fileE) {
            System.out.println("The File is not where you think it is App");
            System.out.println(fileE.toString());
            // System.out.println(fileE.getStackTrace()[0].getLineNumber());
            
        }

        

        

    }

    public static void main(String[] args) {
        launch();
    }

    // Everything below here is a basic utility method for quick debugging that won't be in the final version, or event handlers that I wrote based on a quick mockup that I did that I plan on reusing and don't want to have to figure out how to write again, but won't compile properly without all the other classes

    @Override
    public void stop(){
        
        SaveState tempSave = new SaveState(orders, userList, menuList, nextOrderNumber, currentUserIDToAssign, currentCouponNum);
        try{
            FileOutputStream fileOut = new FileOutputStream(pwd + "tempFile.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(tempSave);
            out.close();
            System.out.println("This should execute when stopped");
        }
        catch(Exception e3){
            e3.printStackTrace();
        }
        

    }


    EventHandler<MouseEvent> currentHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            System.out.println("Current User logged in is: " + currentUserLoggedIn + " Name: " + userList.get(findUserId(currentUserLoggedIn)).getFirstName());
        }
    };


    public int findItem(OrderItem item){
        for (int i = 0; i < currentOrder.getOrderContents().size(); i++){
            if (item == currentOrder.getOrderContents().get(i)){
                return i;
            }
        }
        return -1;

    }

    public int findOrder(Order item){
        for (int i = 0; i < orders.size(); i++){
            if (item == orders.get(i)){
                return i;
            }
        }
        return -1;

    }


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

    public int findMenuItem(String name){
        for (int i = 0; i < menuList.size(); i++){
            if(menuList.get(i).getName().equals(name)){
                return i;
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
