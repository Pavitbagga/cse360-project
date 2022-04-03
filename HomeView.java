package org.openjfx;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class HomeView  extends BaseModel{

    GridPane view;

    Button menu;
    Text cakeLabel;
    Text iceCreamLabel;
    Text smoothieLabel;

    Image cakeImage;
    Image smoothieImage;
    Image iceCreamImage;

    ImageView cakeImageView;
    ImageView smoothieImageView;
    ImageView iceCreamImageView;

    //added
    HBox mainHbox1;
    HBox mainHbox2;
    HBox mainHbox3;

    HomeView(int xSize, int ySize, ArrayList<Button> buttonList, String newPageTitle, Image newLogo, String newPWD){
        super(xSize, ySize, buttonList, newPageTitle, newLogo, newPWD);

        view = new GridPane();

        ColumnConstraints c1 = new ColumnConstraints();
        ColumnConstraints c2 = new ColumnConstraints();
        ColumnConstraints c3 = new ColumnConstraints();

        c1.setPercentWidth(30.0);
        c2.setPercentWidth(30.0);
        c3.setPercentWidth(30.0);

        RowConstraints r1 = new RowConstraints();
        RowConstraints r2 = new RowConstraints();
        RowConstraints r3 = new RowConstraints();

        r1.setPercentHeight(20.0);
        r2.setPercentHeight(20.0);
        r3.setPercentHeight(60.0);

        mainHbox1 = new HBox();
        mainHbox2 = new HBox();
        mainHbox3 = new HBox();

        view.getColumnConstraints().add(c1);
        view.getColumnConstraints().add(c2);
        view.getColumnConstraints().add(c3);

        view.getRowConstraints().add(r1);
        view.getRowConstraints().add(r2);
        view.getRowConstraints().add(r3);




        menu = new Button("Menu");
        cakeLabel = new Text("Cake");
        iceCreamLabel =  new Text("Ice Cream/Gelato");
        smoothieLabel = new Text("Smoothies");

        // HBoxes and setPadding help center labels with pictures
        mainHbox1.getChildren().addAll(cakeLabel);
        mainHbox2.getChildren().addAll(iceCreamLabel);
        mainHbox3.getChildren().addAll(smoothieLabel);

        mainHbox1.setPadding(new Insets(0, 5, 0,100));
        mainHbox2.setPadding(new Insets(0, 50, 0 ,60));
        mainHbox3.setPadding(new Insets(0, 5, 0, 80));


        view.add(menu, 0, 0);
        view.add(mainHbox1, 0, 1);
        view.add(mainHbox2, 1, 1);
        view.add(mainHbox3, 2, 1);
     //   view.add(cakeLabel, 0, 1);
     //   view.add(iceCreamLabel, 1, 1);
     //   view.add(smoothieLabel, 2, 1);




        try{
            InputStream cakeIn = new FileInputStream(pwd + "cake.jpeg");
            cakeImage = new Image(cakeIn);
            cakeImageView = new ImageView(cakeImage);

            cakeImageView.setFitHeight(ySize*.45);
            cakeImageView.setFitWidth(xSize*.25);
            cakeImageView.setPreserveRatio(true);

            InputStream iceCreamIn = new FileInputStream(pwd + "iceCream.jpg");
            iceCreamImage = new Image(iceCreamIn);
            iceCreamImageView = new ImageView(iceCreamImage);

            iceCreamImageView.setFitHeight(ySize*.45);
            iceCreamImageView.setFitWidth(xSize*.25);
            iceCreamImageView.setPreserveRatio(true);

            InputStream smoothieIn = new FileInputStream(pwd + "smoothie.jpeg");
            smoothieImage = new Image(smoothieIn);
            smoothieImageView = new ImageView(smoothieImage);
            smoothieImageView.setPreserveRatio(true);

            smoothieImageView.setFitHeight(ySize*.45);
            smoothieImageView.setFitWidth(xSize*.25);

            view.add(cakeImageView, 0, 2);
            view.add(iceCreamImageView, 1, 2);
            view.add(smoothieImageView, 2, 2);
            view.setAlignment(Pos.BASELINE_CENTER);



        }
        catch(Exception e){
            System.out.println("One of the files is not where you think it is");
            System.out.println(e.toString());
        }

        this.mainView.add(view, 0, 1);



    }

    
}
