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
 * Package: WalmartAPI.model
 * Class: RatingStars
 *
 * Description:
 * Creates a rating star object that
 * displays the rating of an item
 * ****************************************
 */

package WalmartAPI.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * Creates a rating star object that displays the rating of an item
 */
public class RatingStars extends HBox {
    /**
     * Creates a rating star object that displays the rating of an item
     * @param rating The rating of the item
     */
    public RatingStars(double rating) {
        // PNG files are in the "/images" directory
        String basePath = "/images/";

        // Create an HBox to contain the star images
        for (int i = 0; i < 5; i++) {
            ImageView star;

            // Determine the state of the star based on the rating
            if (rating >= i + 1) {
                star = new ImageView(new Image(getClass().getResource(basePath + "star-fill.png").toExternalForm()));
            } else if (rating > i) {
                star = new ImageView(new Image(getClass().getResource(basePath + "star-half.png").toExternalForm()));
            } else {
                star = new ImageView(new Image(getClass().getResource(basePath + "star.png").toExternalForm()));
            }

            star.setFitWidth(15); // Set the star width
            star.setFitHeight(15); // Set the star height
            getChildren().add(star);
        }
    }
}
