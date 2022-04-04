

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


import java.util.ArrayList;

public class CouponView extends BaseModel {

    TextField searchbar;
    Button goButton;

    Text customerName;
    TextField enterName;
    Text percentOff;
    TextField enterPercent;

    Button giveCoupon;

    HBox searchAndGo;
    HBox customer;
    HBox percents;

    VBox aVbox;

    public CouponView (int xSize, int ySize, ArrayList<Button> topButtons, String newPageTitle, Image newLogo, String newPWD) {

        super(xSize, ySize, topButtons, newPageTitle, newLogo, newPWD);

        searchbar = new TextField("Search");
        goButton = new Button("Go");

        customerName = new Text("Customer Name: ");
        enterName = new TextField();
        percentOff = new Text("Percent Off: ");
        enterPercent = new TextField();

        giveCoupon = new Button("Give Coupon");

        searchAndGo = new HBox(20);
        customer = new HBox(20);
        percents = new HBox(20);
        aVbox = new VBox(20);

        searchAndGo.getChildren().addAll(searchbar,goButton);
        searchAndGo.setAlignment(Pos.CENTER);

        customer.getChildren().addAll(customerName,enterName);
        customer.setAlignment(Pos.CENTER);

        percents.getChildren().addAll(percentOff,enterPercent);
        percents.setAlignment(Pos.CENTER);

        aVbox.getChildren().addAll(searchAndGo,customer,percents,giveCoupon);
        aVbox.setAlignment(Pos.CENTER);

        this.mainView.add(aVbox,0,1);



    }
}
