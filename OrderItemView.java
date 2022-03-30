package org.openjfx;

import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;


public class OrderItemView extends GridPane{

    

    OrderItemView(Order newOrder) {

        ColumnConstraints c1 = new ColumnConstraints();
        ColumnConstraints c2 = new ColumnConstraints();
        ColumnConstraints c3 = new ColumnConstraints();

        c1.setPercentWidth(15);
        c2.setPercentWidth(60);
        c3.setPercentWidth(25);

        RowConstraints r1 = new RowConstraints();
        RowConstraints r2 = new RowConstraints();


        this.getRowConstraints().addAll(r1, r2);
        this.getColumnConstraints().addAll(c1, c2, c3);

        Text num = new Text(String.valueOf(newOrder.getOrderNum()));

        this.add(num, 1, 0);
        

        Button deleteSelfButton = new Button("Delete");
        this.add(deleteSelfButton, 2, 0);


    }
    
}
