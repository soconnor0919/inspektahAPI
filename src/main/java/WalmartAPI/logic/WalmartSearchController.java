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
 * Package: WalmartAPI.logic
 * Class: WalmartSearchController
 *
 * Description:
 * A class that represents the controller for the Walmart
 * product search application.
 * ****************************************
 */

package WalmartAPI.logic;

import WalmartAPI.model.Item;
import WalmartAPI.model.SortType;

import java.io.IOException;

/**
 * A class that represents the controller for the Walmart
 * product search application.
 */
public class WalmartSearchController {
    // The model
    private final WalmartSearchModel searchModel;

    /**
     * Constructor.
     */
    public WalmartSearchController() {
        this.searchModel = new WalmartSearchModel();
    }

    /**
     * Perform a search based on user input.
     *
     * @param userQuery    The user's search query.
     * @param sortType     The sort type for the search.
     * @param itemsPerPage The number of items per page.
     * @return An array of Item objects representing the search results.
     */
    public Item[] performSearch(String userQuery, SortType sortType, int itemsPerPage) {
        try {
            // Delegate the search functionality to the model
            return searchModel.search(userQuery, sortType, itemsPerPage);
        } catch (IOException e) {
            // Handle or log the exception appropriately
            e.printStackTrace();
            return new Item[0]; // Return an empty array in case of an error
        }
    }
}
