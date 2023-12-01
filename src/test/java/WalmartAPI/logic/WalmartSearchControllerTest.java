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
 * Class: WalmartSearchControllerTest
 *
 * Description:
 * A class that tests the controller for the Walmart
 * Search application.
 * ****************************************
 */

package WalmartAPI.logic;

import WalmartAPI.model.Item;
import WalmartAPI.model.SortType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A class that tests the controller for the Walmart
 * product search application.
 */
class WalmartSearchControllerTest {

    /**
     * Test the performSearch method.
     */
    @Test
    void performSearch() {
        WalmartSearchController controller = new WalmartSearchController();
        Item[] item = controller.performSearch("iPad", SortType.RELEVANCE, 10);
        assertNotEquals(item, new Item[0]);
    }
}