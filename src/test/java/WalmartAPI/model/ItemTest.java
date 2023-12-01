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
 * Class: ItemTest
 *
 * Description:
 * A class that tests the Item class.
 * ****************************************
 */

package WalmartAPI.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A class that tests the Item class.
 */
class ItemTest {
    /** Item object to be used throughout the test */
    private Item item;

    /**
     * Set up the test.
     */
    @BeforeEach
    void setUp() {
        item = new Item("name", 1.0, "url", 5.0,"itemId", "category", "description");
    }

    /**
     * Test the getName method.
     */
    @Test
    void getName() {
        assertEquals("name", item.getName());
    }

    /**
     * Test the getPrice method.
     */
    @Test
    void getPrice() {
        assertEquals(1.0, item.getPrice());
    }

    /**
     * Test the getUrl method.
     */
    @Test
    void getUrl() {
        assertEquals("https://www.walmart.com/ip/itemId", item.getUrl());
    }

    /**
     * Test the getImageUrl method.
     */
    @Test
    void getImageUrl() {
        assertEquals("url", item.getImageUrl());
    }

    /**
     * Test the getRating method.
     */
    @Test
    void getRating() {
        assertEquals(5.0, item.getRating());
    }

    /**
     * Test the getItemId method.
     */
    @Test
    void getItemId() {
        assertEquals("itemId", item.getItemId());
    }

    /**
     * Test the getCategory method.
     */
    @Test
    void getCategory() {
        assertEquals("category", item.getCategory());
    }

    /**
     * Test the getDescription method.
     */
    @Test
    void getDescription() {
        assertEquals("description", item.getDescription());
    }

    /**
     * Test the toString method.
     */
    @Test
    void testToString() {
        assertEquals("Name: name\n" +
                "Price: 1.0\n" +
                "URL: https://www.walmart.com/ip/itemId\n" +
                "Image URL: url\n" +
                "Rating: 5.0\n" +
                "Item ID: itemId\n" +
                "Category: category\n" +
                "Description: description\n",
                item.toString());
    }
}