/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Brian King
 *
 * Names: O'Connor, Sean
 *        Sanders, Alec
 *        Gaines, Geoffrey
 *        Finkler, Aidan
 *
 * Project: csci205_final_project
 * Package: WalmartAPI
 * Class: WalmartSearchView
 *
 * Description:
 * A class that represents the GUI for the Walmart
 * product search application.
 * ****************************************
 */

package WalmartAPI;

import WalmartAPI.gui.ItemCard;
import WalmartAPI.model.Item;
import WalmartAPI.model.SortType;
import WalmartAPI.logic.WalmartSearchController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;

import java.io.IOException;
import java.util.Objects;

public class WalmartSearchView extends Application {
    // The controller
    private final WalmartSearchController searchController;

    // GUI components
    private TextField searchBox;
    private Button searchButton;
    private ComboBox<SortType> sortTypeComboBox;
    private ComboBox<Integer> quantityComboBox;
    private Label placeholderLabel;
    private GridPane itemsGridPane;

    /**
     * Constructor.
     */
    public WalmartSearchView() {
        this.searchController = new WalmartSearchController();
    }

    /**
     * The main method.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Override the start method from Application.
     */
    @Override
    public void start(@SuppressWarnings("exports") javafx.stage.Stage primaryStage) {
        primaryStage.setTitle("InspektahAPI");

        // Create GUI components
        createSearchBox();
        createSearchButton();
        createSortTypeComboBox();
        createQuantityComboBox();
        createPlaceholderLabel();
        createItemsGridPane();

        // Layout setup
        BorderPane root = new BorderPane();
        root.getStyleClass().add("root"); // Add the style class
        root.setTop(createTopBar());
        root.setLeft(createSideBar());
        root.setCenter(createCenterPane());

        Scene scene = new Scene(root, 800, 600);

        // Load the CSS file from the resources folder
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("css/styles.css")).toExternalForm());


        primaryStage.setScene(scene);
        primaryStage.show();
    }


    /**
     * Create the top bar that contains the search box and search button.
     */
    private HBox createTopBar() {
        HBox topBar = new HBox(10);
        topBar.setId("topBar"); // Set an ID for the top bar
        topBar.setAlignment(Pos.CENTER_RIGHT);
        topBar.setPadding(new Insets(10));

        // Load the logo image
        Image logoImage = new Image(getClass().getResourceAsStream("images/logo.png"));

        // Create ImageView with the logo image
        ImageView logoImageView = new ImageView(logoImage);

        // Set the size of the logo image
        logoImageView.setFitWidth(170); // Adjust the width as needed
        logoImageView.setFitHeight(55); // Adjust the height as needed

        // Allow the search box to grow to fill available width
        HBox.setHgrow(searchBox, Priority.ALWAYS);

        topBar.getChildren().addAll(logoImageView, searchBox, searchButton);

        // Set the action when the search button is clicked
        searchButton.setOnAction(event -> {
            try {
                performSearch();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        // Allow searching by pressing Enter key
        searchBox.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    performSearch();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        return topBar;
    }

    /**
     * Create the sidebar that contains the options.
     */
    private VBox createSideBar() {
        VBox sideBar = new VBox(10);
        sideBar.setId("sideBar"); // Set an ID for the sidebar
        sideBar.setAlignment(Pos.TOP_LEFT);
        sideBar.setPadding(new Insets(10));

        // Add styling to the options label
        Label optionsLabel = new Label("Options");
        optionsLabel.setStyle("-fx-font-size: 16;"); // Set the font size

        // Add sort type and quantity options to the sidebar
        sideBar.getChildren().addAll(
                optionsLabel,
                new Separator(), // Add a horizontal rule
                new Label("Sort Type:"),
                sortTypeComboBox,
                new Label("Quantity:"),
                quantityComboBox
        );

        return sideBar;
    }

    /**
     * Create the center pane that displays the search results.
     */
    private BorderPane createCenterPane() {
        BorderPane centerPane = new BorderPane();

        // Show placeholder label initially
        centerPane.setCenter(placeholderLabel);

        return centerPane;
    }

    /**
     * Create the search box.
     */
    private void createSearchBox() {
        searchBox = new TextField();
        searchBox.setPromptText("Enter product name...");
    }

    /**
     * Create the search button.
     */
    private void createSearchButton() {
        searchButton = new Button("Search");
    }

    /**
     * Create the sort type combo box.
     */
    private void createSortTypeComboBox() {
        sortTypeComboBox = new ComboBox<>();
        sortTypeComboBox.getItems().addAll(SortType.values());
        sortTypeComboBox.setValue(SortType.RELEVANCE);
    }

    /**
     * Create the quantity combo box.
     */
    private void createQuantityComboBox() {
        quantityComboBox = new ComboBox<>();
        quantityComboBox.getItems().addAll(5, 10, 25);
        quantityComboBox.setValue(10);
    }

    /**
     * Create the placeholder label displayed when no search results are found.
     */
    private void createPlaceholderLabel() {
        placeholderLabel = new Label("Enter a search query to find products.");
    }

    /**
     * Create the grid pane that displays the search results.
     */
    private void createItemsGridPane() {
        itemsGridPane = new GridPane();
        itemsGridPane.setHgap(10);
        itemsGridPane.setVgap(10);
        itemsGridPane.setPadding(new Insets(10));
    }

    /**
     * Perform a search using the user's query and update the UI with the results.
     *
     * @throws IOException
     */
    private void performSearch() throws IOException {
        String query = searchBox.getText();
        SortType sortType = sortTypeComboBox.getValue();
        int quantity = quantityComboBox.getValue();

        // Perform search and update the UI with the results
        updateItemsGrid(searchController.performSearch(query, sortType, quantity));
    }

    /**
     * Update the items grid with the given items.
     *
     * @param items The items to display
     */
    private void updateItemsGrid(Item[] items) {
        itemsGridPane.getChildren().clear();

        if (items.length > 0) {
            for (Item item : items) {
                ItemCard itemCard = new ItemCard(item);
                itemsGridPane.add(itemCard, 0, itemsGridPane.getChildren().size());
            }

            // Make the items pane scrollable
            ScrollPane scrollPane = new ScrollPane(itemsGridPane);
            scrollPane.setFitToHeight(true);
            scrollPane.setFitToWidth(true);

            // Set the itemsGridPane as the center of the main BorderPane
            ((BorderPane) searchBox.getScene().getRoot()).setCenter(scrollPane);
        } else {
            // If no items found, display the placeholder label
            ((BorderPane) searchBox.getScene().getRoot()).setCenter(placeholderLabel);
        }
    }
}
