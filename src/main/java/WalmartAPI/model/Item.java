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
 * Class: Item
 *
 * Description:
 * A class that represents an item
 * ****************************************
 */

package WalmartAPI.model;

/**
 * A class that represents an item
 */
public class Item {
    /**
     * The name of the item
     */
    private final String name;

    /**
     * The price of the item
     */
    private final double price;

    /**
     * The URL of the item
     */
    private final String url;

    /**
     * The image URL of the item
     */
    private final String imageUrl;

    /**
     * The rating of the item
     */
    private final double rating;

    /**
     * The item ID
     */
    private final String itemId;

    /**
     * The item category
     */
    private final String category;

    /**
     * The item description
     */
    private final String description;

    /**
     * Create a new item
     *
     * @param name        The name of the item
     * @param price       The price of the item
     * @param imageUrl    The image URL of the item
     * @param rating      The rating of the item
     * @param itemId      The item ID
     * @param category    The item category
     * @param description The item description
     */
    public Item(String name, double price, String imageUrl, double rating, String itemId, String category, String description) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.itemId = itemId;
        this.url = "https://www.walmart.com/ip/" + itemId;
        this.category = category;
        this.description = description;
    }

    /**
     * Get the name of the item
     *
     * @return The name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * Get the price of the item
     *
     * @return The price of the item
     */
    public double getPrice() {
        return price;
    }

    /**
     * Get the URL of the item
     *
     * @return The URL of the item
     */
    public String getUrl() {
        return url;
    }

    /**
     * Get the image URL of the item
     *
     * @return The image URL of the item
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Get the rating of the item
     *
     * @return The rating of the item
     */
    public double getRating() {
        return rating;
    }

    /**
     * Get the item ID
     *
     * @return The item ID
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * Get the category of the item
     *
     * @return The category of the item
     */
    public String getCategory() {
        return category;
    }

    /**
     * Get the description of the item
     *
     * @return The description of the item
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get the item as a string
     *
     * @return The item as a string
     */
    @Override
    public String toString() {
        return "Name: " + name +
                "\nPrice: " + price +
                "\nURL: " + url +
                "\nImage URL: " + imageUrl +
                "\nRating: " + rating +
                "\nItem ID: " + itemId +
                "\nCategory: " + category +
                "\nDescription: " + description +
                "\n";
    }
}
