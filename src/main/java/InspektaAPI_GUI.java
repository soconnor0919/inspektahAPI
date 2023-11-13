/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Brian King / Prof. Joshua Stough
 *
 * Name: Team17
 * Section: 01, 61(lab)
 * Date: 11/13/23
 * Time: 5:41 PM
 *
 * Project: csci205_final_project
 * Package: PACKAGE_NAME
 * Class: InspektaAPI_GUI
 *
 * Description:
 *
 * ****************************************
 */


/**Import JavaFX*/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;

import java.awt.*;

import static jdk.javadoc.internal.doclets.toolkit.util.DocFinder.search;


/**This program creates a GUI to display the info in our item*/
public class InspektaAPI_GUI extends Application{

    //Fields
    private Stage window;
    private TextField searchName;
    private Label searchLabel;
    public static void main(String[] args) {

        //Launch the GUI
        launch(args);
    }//end main

    @Override
    public void start(Stage PrimaryStage){

        //Labels
        //Create a label for search bar
        Label searchLabel = new Label("Search for an item: ");

        //Create a welcome label
        Label label = new Label("Welcome to InspektaAPI_GUI");


        //TextFields
        //Create a textfield for the search bar
        TextField searchName = new TextField();


        //Buttons
        //Create a button to search for the item
        Button searchButton = new Button("Search");

        //Register the button to an event handler
        searchButton.setOnAction(e -> {
            //Call the search method
            search(searchName.getText());
        });

        //Create an empty label to display the result
        resultLabel = new Label();

        //Create a layout
        VBox layout = new VBox(10);

        //Set the layout alignment to center
        layout.setAlignment(Pos.CENTER);

        //Set the padding to 20px
        layout.setPadding(new Insets(20, 20, 20, 20));

        //Create a scene
        Scene scene = new Scene(layout, 300, 250);

        //Add the label, textfield, and button to the layout
        layout.getChildren().addAll(searchLabel, searchName, searchButton, resultLabel);

        //Set the title of the window
        window.setTitle("InspektaAPI_GUI");

        //Set the scene of the window
        window.setScene(scene);

        //Display the window
        window.show();


        //Create a new stage
        Stage window = new Stage();


    }//end start

}//end InspektaAPI_GUI
