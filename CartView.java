package application;
import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;

public class CartView extends BaseModel
{
	Text total;
	VBox orderItemsList;
	Text yourCartText;
	Button cancelOrderButton;
	Button checkOutButton;
	Order thisOrder;

	
	public CartView(int xSize, int ySize, ArrayList<Button> topButtons, String newPageTitle, Image newLogo, Order newOrder)
	{
		super (xSize, ySize, topButtons, newPageTitle, newLogo);
		
	}
	
	public void addAllItemsToCart(Order newOrder)
	{
		
	}
	
	public void removeAllItemsFromCart()
	{
		
	}
	
}
