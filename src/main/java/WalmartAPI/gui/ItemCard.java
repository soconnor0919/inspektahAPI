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
 * Package: WalmartAPI.gui
 * Class: ItemCard
 *
 * Description:
 * A class that represents an item card
 * for the Walmart API application-
 * An item card displays the image, title,
 * price, and rating of an item.
 * ****************************************
 */

package WalmartAPI.gui;

import WalmartAPI.model.Item;
import WalmartAPI.model.RatingStars;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Locale;

/**
 * A class that represents an item card
 * for the Walmart API application-
 * An item card displays the image, title,
 * price, and rating of an item.
 */
public class ItemCard extends HBox {

    /**
     * Create a new item card
     *
     * @param item The item to display
     */
    public ItemCard(Item item) {
        // Set spacing and style class
        setSpacing(10);
        getStyleClass().add("item-card");

        // Display the image on the left quarter
        ImageView imageView = new ImageView(new Image(item.getImageUrl()));
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);

        // Create a container for the image
        VBox imageBox = new VBox(imageView);
        imageBox.setAlignment(Pos.CENTER);

        // Display the title with Tooltip
        Label titleLabel = new Label(item.getName());
        titleLabel.setStyle("-fx-font-weight: bold;");

        Tooltip tooltip = new Tooltip(item.getName());
        titleLabel.setTooltip(tooltip);

        // Format the price with two decimal places
        String formattedPrice = String.format(Locale.US, "%.2f", item.getPrice());
        Label priceLabel = new Label("$" + formattedPrice);
        priceLabel.setStyle("-fx-font-size: 14pt;"); // Set font size

        // Display the rating using RatingStars
        RatingStars ratingStars = new RatingStars(item.getRating());

        // Create a container for the title and price
        VBox titleBox = new VBox(titleLabel, priceLabel);
        titleBox.setAlignment(Pos.TOP_LEFT);

        // Create a container for the rating
        VBox ratingBox = new VBox(ratingStars);
        ratingBox.setAlignment(Pos.BOTTOM_LEFT);

        // Add the image, titleBox, and ratingBox to the ItemCard
        getChildren().addAll(imageBox, titleBox, ratingBox);

        setAlignment(Pos.CENTER_LEFT);
    }
}
