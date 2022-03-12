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

    // ArrayList<Order> orders;
    // int test;
    // ArrayList<MenuItem> menuList;
    // MenuView menu; 
    Stage stage;
    // OrdersView ordersView;

    

    

    EventHandler<MouseEvent> handleTest1 = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            System.out.println("Button Test 1 was Pushed " + ((Button)e.getSource()).getHeight());
        }
    };
    EventHandler<MouseEvent> handleTest2 = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            System.out.println("Button Test 2 was Pushed "+ ((Button)e.getSource()).getWidth());
        }
    };
    EventHandler<MouseEvent> handleTest3 = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            System.out.println("Button Test 3 was Pushed "+ ((Button)e.getSource()).getMaxHeight());
        }
    };

    EventHandler<MouseEvent> handleTest4 = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e) {
            System.out.println("Button Test 4 was Pushed "+ ((Button)e.getSource()).getMaxHeight());
        }
    };



   

    @Override
    public void start(Stage stage) {
        this.stage = stage;

        Button test1 = new Button("Test 1");
        Button test2 = new Button("Test 2");
        Button test3 = new Button("Test 3");
        Button test4 = new Button("Test 4");


        test1.setOnMouseClicked(handleTest1);
        test2.setOnMouseClicked(handleTest2);
        test3.setOnMouseClicked(handleTest3);
        test4.setOnMouseClicked(handleTest4);

        ArrayList<Button> buttonList = new ArrayList<Button> ();

        buttonList.add(test1);
        buttonList.add(test2);
        buttonList.add(test3);
        buttonList.add(test4);
        Image newImage;

        try {
            InputStream in = new FileInputStream("/home/ejoerz/test/sample/src/main/java/org/openjfx/test.png");
            newImage = new Image(in);
            BaseModel b = new BaseModel(900, 700, buttonList, "This is a Test1", newImage);
            System.out.println("The actual height of a scene is " + b.getHeight());
            stage.setScene(b);
            stage.show();
        }
        catch (Exception fileE) {
            System.out.println("The File is not where you think it is");
            
        }

        
        

    }

    public static void main(String[] args) {
        launch();
    }

    // Everything below here is a basic utility method for quick debugging that won't be in the final version, or event handlers that I wrote based on a quick mockup that I did that I plan on reusing and don't want to have to figure out how to write again, but won't compile properly without all the other classes



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