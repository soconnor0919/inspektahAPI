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
 * Class: WalmartSearchModelTest
 *
 * Description:
 * A class that tests the model for the Walmart
 * product search application.
 * ****************************************
 */

package WalmartAPI.logic;

import WalmartAPI.model.Item;
import org.junit.jupiter.api.Test;
import WalmartAPI.model.SortType;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A class that tests the model for the Walmart
 * product search application.
 */
class WalmartSearchModelTest {
    /**
     * Test the search method.
     *
     * @throws IOException If an error occurs during the API request or response processing.
     */
    @Test
    void search() throws IOException {
        WalmartSearchModel model = new WalmartSearchModel();
        Item[] result = model.search("iPad", SortType.RELEVANCE, 10);
        assertTrue(result.length > 0);
        assertNotEquals(result[0].getItemId(), "");
    }
}