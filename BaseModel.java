import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class BaseModel extends Scene{

    public GridPane mainView;
    public VBox topButtonHolder;
    public ArrayList<Button> topButtons;
    public ImageView topLogo;
    public Image logo;
    public GridPane topView;
    public ArrayList<ColumnConstraints> columns;
    public ArrayList<RowConstraints> rows;
    public VBox topLogoBox;
    public Text pageTitle;

    BaseModel(int xSize, int ySize, ArrayList<Button> buttonList, String newPageTitle, Image newLogo) {
        
        
        // Calls constructor for Scene, initializing with new GridPane as the root node in the node tree
        super(new GridPane(), xSize, ySize, Color.web("FFFFFF"));
        
        // Takes the GridPane called in the super constructor and assigns mainView attribute to it for manipulation purposes
        mainView = (GridPane) super.getRoot();

        // Initializes the rest of the class members
        topButtonHolder = new VBox();
        topButtons = buttonList;
        topView = new GridPane();
        topLogo = new ImageView();
        columns = new ArrayList<ColumnConstraints>();
        rows = new ArrayList<RowConstraints>();
        pageTitle = new Text();
        topLogoBox = new VBox();

        // Add values to members from constructor

        logo = newLogo;
        pageTitle.setText(newPageTitle);
        
            // Setting image to be proper dimensions and adding to container for alignment later
        topLogo.setImage(logo);
        topLogo.setFitHeight(ySize*0.15);
        topLogo.setFitWidth(xSize*0.6);
        topLogo.setPreserveRatio(true);
        topLogoBox.getChildren().add(topLogo);
            // Adding buttons to the top of the view
        for (int i = 0; i < topButtons.size(); i++) { // Using default size for buttons
            topButtonHolder.getChildren().add(topButtons.get(i));           
        }


        // Initializing columns for topView GridPane
        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        ColumnConstraints col3 = new ColumnConstraints();
        col1.setPercentWidth(20.0);
        col2.setPercentWidth(60.0);
        col3.setPercentWidth(20.0);


        columns.add(col1);
        columns.add(col2);
        columns.add(col3);

        // Initializing rows for mainView Gridpane
        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();

        row1.setPercentHeight(15.0);
        row2.setPercentHeight(85.0);

        rows.add(row1);
        rows.add(row2);

        // Initializing single column for mainView proper width
        ColumnConstraints col0 = new ColumnConstraints();
        col0.setPercentWidth(95.0);



        // Adding rows and columns to appropriate places
        mainView.getRowConstraints().addAll(rows);
        topView.getColumnConstraints().addAll(columns);
        mainView.getColumnConstraints().add(col0);

        // Setting Gaps and alignments
        mainView.setHgap(5.0);
        mainView.setVgap(5.0);
        topLogoBox.setAlignment(Pos.CENTER);
        mainView.setAlignment(Pos.CENTER);
        topView.setAlignment(Pos.CENTER);
        topButtonHolder.setAlignment(Pos.TOP_RIGHT);


        
        // Gluing everyting together
            // Puts topView GridPane in column 0 row 0 of mainView (We haven't declared any columns for this yet, so the entire thing is column 0)
        mainView.add(topView, 0 , 0);

            // Adding the button Holder to topView column 2 row 0 (There's no declared rows for this, so the entire thing is row 0)
        topView.add(topButtonHolder, 2, 0);
        
            // Adding the Page title to column 0, row 0 (There's no declared rows for this, so the entire thing is row 0)
        topView.add(pageTitle, 0, 0);

            // Adding the VBox topLogoBox to column 1, row 0 (There's no declared rows for this, so the entire thing is row 1)
        topView.add(topLogoBox, 1, 0);

        



    }
}
