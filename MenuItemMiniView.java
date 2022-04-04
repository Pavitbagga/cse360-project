

import java.io.FileInputStream;
import java.io.InputStream;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;

public class MenuItemMiniView extends GridPane {
    
    ImageView menuImage;
    Text menuName;
    Button menuButton;
    MenuItem innerMenuItem;
    String pwd;


    MenuItemMiniView(MenuItem newItem, int xSize, int ySize, String newPWD){
        menuImage = new ImageView();
        menuName = new Text();
        menuButton = new Button("View Item");
        innerMenuItem = newItem;

        this.pwd = newPWD;
        
        menuName.setText(newItem.getName());
        
        RowConstraints r1 = new RowConstraints();

        r1.setPercentHeight(100.0);
        this.getRowConstraints().add(r1);

        this.setPrefHeight(ySize * 0.85 * 0.14);
        this.setPrefWidth(xSize * 0.85 * 0.9);


        ColumnConstraints c1 = new ColumnConstraints();
        ColumnConstraints c2 = new ColumnConstraints();
        ColumnConstraints c3 = new ColumnConstraints();

        c1.setPercentWidth(30.0);
        c2.setPercentWidth(35.0);
        c3.setPercentWidth(30.0);

        this.getColumnConstraints().add(c1);
        this.getColumnConstraints().add(c2);
        this.getColumnConstraints().add(c3);


        try{
            InputStream in = new FileInputStream(pwd + newItem.getPicture().getUrl());
            Image menuImg = new Image(in);
            menuImage.setImage(menuImg);
            menuImage.setFitHeight(this.getPrefHeight()*0.95);
            menuImage.setFitWidth(this.getPrefWidth() * .3 * 0.95);
            menuImage.setPreserveRatio(true);

            this.add(menuImage, 0, 0);
            this.add(menuName, 1, 0);
            this.add(menuButton, 2, 0);

            this.setAlignment(Pos.CENTER);
        }
        catch(Exception FileE){
            System.out.println("Error with menuItemMiniView Image");
            System.out.println(FileE.toString());

        }




    }
}
