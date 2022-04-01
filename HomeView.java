package org.openjfx;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;

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

    HomeView(int xSize, int ySize, ArrayList<Button> buttonList, String newPageTitle, Image newLogo){
        super(xSize, ySize, buttonList, newPageTitle, newLogo);

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

        view.add(menu, 0, 0, 3, 1);

        view.add(cakeLabel, 0, 1);
        view.add(iceCreamLabel, 1, 1);
        view.add(smoothieLabel, 2, 1);


        try{
            InputStream cakeIn = new FileInputStream("/home/ejoerz/test/sample/src/main/java/org/openjfx/cake.jpeg");
            cakeImage = new Image(cakeIn);
            cakeImageView = new ImageView(cakeImage);

            cakeImageView.setFitHeight(ySize*.45);
            cakeImageView.setFitWidth(xSize*.25);
            cakeImageView.setPreserveRatio(true);

            InputStream iceCreamIn = new FileInputStream("/home/ejoerz/test/sample/src/main/java/org/openjfx/iceCream.jpg");
            iceCreamImage = new Image(iceCreamIn);
            iceCreamImageView = new ImageView(iceCreamImage);

            iceCreamImageView.setFitHeight(ySize*.45);
            iceCreamImageView.setFitWidth(xSize*.25);
            iceCreamImageView.setPreserveRatio(true);

            InputStream smoothieIn = new FileInputStream("/home/ejoerz/test/sample/src/main/java/org/openjfx/smoothiePicture.jpeg");
            smoothieImage = new Image(smoothieIn);
            smoothieImageView = new ImageView(smoothieImage);
            smoothieImageView.setPreserveRatio(true);

            smoothieImageView.setFitHeight(ySize*.45);
            smoothieImageView.setFitWidth(xSize*.25);

            view.add(cakeImageView, 0, 2);
            view.add(iceCreamImageView, 1, 2);
            view.add(smoothieImageView, 2, 2);



        }
        catch(Exception e){
            System.out.println("One of the files is not where you think it is");
            System.out.println(e.toString());
        }

        this.mainView.add(view, 0, 1);



    }

    
}
