/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Brian King
 *
 * Name: O'Connor, Sean
 * Section: 09:00
 * Date: 11/10/23
 *
 * Project: csci205_final_project
 * Package: WalmartAPI
 * Class: WalmartAPI.SortType
 *
 * Description:
 * Indicates a sort type when searching the
 * walmart API
 * ****************************************
 */

package WalmartAPI;

// Indicates a sort type when searching the walmart API
public enum SortType {
    // Sort by bestseller
    BEST_SELLER("bestseller"),
    // Sort by price
    PRICE("price"),
    // Sort by title
    TITLE("title"),
    // Sort by relevance
    RELEVANCE("relevance"),
    // Sort by customer rating
    CUSTOMER_RATING("customerRating"),
    // Sort by new
    NEW("new");

    // The sort type
    private String sortType;

    /**
     * Create a new sort type
     * @param sortType
     */
    SortType(String sortType) {
        this.sortType = sortType;
    }

    /**
     * Get the sort type
     * @return The sort type
     */
    public String getSortType() {
        return sortType;
    }
}
